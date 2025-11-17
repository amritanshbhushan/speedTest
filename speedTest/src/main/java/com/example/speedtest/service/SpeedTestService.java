package com.example.speedtest.service;

import com.example.speedtest.models.SpeedTestResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.*;

@Service
public class SpeedTestService {
    private static final String SPEEDTEST_PATH = "C:\\Users\\HOME\\AppData\\Local\\Programs\\Python\\Python313\\Scripts\\speedtest-cli.exe";

    public SpeedTestResult runSpeedTest() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(SPEEDTEST_PATH, "--json");
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return new SpeedTestResult("Speedtest CLI failed with exit code: " + exitCode);
            }

            return parseSpeedTestResult(output.toString());

        } catch (IOException | InterruptedException e) {
            return new SpeedTestResult("Error running speed test: " + e.getMessage());
        }
    }

    private SpeedTestResult parseSpeedTestResult(String jsonOutput) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonOutput);
            System.out.println(jsonOutput);
            double download = jsonNode.get("download").asDouble() / 1_000_000; // Convert to Mbps
            double upload = jsonNode.get("upload").asDouble() / 1_000_000;
            int ping = jsonNode.get("ping").asInt();
            String location = jsonNode.get("server").get("name").asText() + ", " + jsonNode.get("server").get("country").asText();
            String ip = jsonNode.get("client").get("ip").asText();
            String provider = jsonNode.get("server").get("sponsor").asText();
            String isp = jsonNode.get("client").get("isp").asText();

            return new SpeedTestResult(download, upload, ping, location, ip, provider, isp);
        } catch (Exception e) {
            return new SpeedTestResult("Error parsing speed test result");
        }
    }
}
