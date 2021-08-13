package com.istiaque.covid19tracker;

public class HelpModel {

    private String stateName;
    private String contactNumber;

    public HelpModel(String stateName, String contactNumber) {
        this.stateName = stateName;
        this.contactNumber = contactNumber;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
