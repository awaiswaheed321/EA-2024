package com.example.demo;

public class AppInfo {
    String appName;
    String packageName;
    String version;
    Integer num;
    Float weight;

    public AppInfo(String appName, String packageName, String version, Integer num, Float weight) {
        this.appName = appName;
        this.packageName = packageName;
        this.version = version;
        this.num = num;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "appName='" + appName + '\'' +
                ", packageName='" + packageName + '\'' +
                ", version='" + version + '\'' +
                ", num=" + num +
                ", weight=" + weight +
                '}';
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
