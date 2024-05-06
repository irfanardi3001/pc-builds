package com.simulation.entity;

public class Psu {
    private String cappacity;
    public Psu(String cappacity){
        this.cappacity = cappacity;
    }

    public String getCappacity() {
        return cappacity;
    }

    public void setCappacity(String cappacity) {
        this.cappacity = cappacity;
    }

    @Override
    public String toString() {
        return cappacity;
    }
}
