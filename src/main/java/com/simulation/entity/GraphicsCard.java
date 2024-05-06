package com.simulation.entity;

public class GraphicsCard {
    private BrandGPU brandGPU;
    private int gpuID;
    private int brandID;
    private String name;
    private String core;
    private String memory;
    private String bus;
    private String clock;
    private String power;
    private String benchmark;

    public BrandGPU getBrandGPU() {
        return brandGPU;
    }

    public void setBrandGPU(BrandGPU brandGPU) {
        this.brandGPU = brandGPU;
    }

    public int getGpuID() {
        return gpuID;
    }

    public void setGpuID(int gpuID) {
        this.gpuID = gpuID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(String benchmark) {
        this.benchmark = benchmark;
    }

    @Override
    public String toString() {
        return name;
    }
}
