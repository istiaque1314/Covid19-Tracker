package com.istiaque.covid19tracker;

public class IndiaModel {

    private String StateName;

    public IndiaModel(String stateName) {
        StateName = stateName;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }
}
