package com.example.speedtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.speedtest.models.SpeedTestResult;
import com.example.speedtest.service.SpeedTestService;

@RestController
@RequestMapping("/api/speedtest")
public class SpeedTestController {

    private final SpeedTestService speedTestService;

    public SpeedTestController(SpeedTestService speedTestService) {
        this.speedTestService = speedTestService;
    }

    @GetMapping("/run")
    public SpeedTestResult runSpeedTest() {
        return speedTestService.runSpeedTest();
    }
}
