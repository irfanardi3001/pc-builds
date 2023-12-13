package com.simulation.entity;

public class Ram {
    private String cappacity;
    public Ram(String cappacity){
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
