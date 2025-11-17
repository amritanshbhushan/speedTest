package com.example.speedtest.models;

public class SpeedTestResult {
    private double download;
    private double upload;
    private int ping;
    private String location;
    private String ip;
    private String provider;
    private String isp;
    private String error;

    // Constructor for successful response
    public SpeedTestResult(double download, double upload, int ping, String location, String ip, String provider, String isp) {
        this.download = download;
        this.upload = upload;
        this.ping = ping;
        this.location = location;
        this.ip = ip;
        this.provider = provider;
        this.isp = isp;
    }

    // Constructor for errors
    public SpeedTestResult(String error) {
        this.error = error;
    }

    // Getters
    public double getDownload() { return download; }
    public double getUpload() { return upload; }
    public int getPing() { return ping; }
    public String getLocation() { return location; }
    public String getIp() { return ip; }
    public String getProvider() { return provider; }
    public String getIsp() { return isp; }
    public String getError() { return error; }
}
