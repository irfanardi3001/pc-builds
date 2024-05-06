package com.simulation.entity;

public class Res {
    private String resolution;
    public Res(String resolution){
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return resolution;
    }
}
