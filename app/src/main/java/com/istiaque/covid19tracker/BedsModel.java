package com.istiaque.covid19tracker;

public class BedsModel {

    private String StateName;
    private String RuralHospitals;
    private String RuralBeds;
    private String UrbanHospitals;
    private String UrbanBeds;
    private String TotalHospitals;
    private String TotalBeds;

    public BedsModel(String stateName) {
        StateName = stateName;
    }

    public BedsModel(String ruralHospitals, String ruralBeds, String urbanHospitals, String urbanBeds, String totalHospitals, String totalBeds) {
        RuralHospitals = ruralHospitals;
        RuralBeds = ruralBeds;
        UrbanHospitals = urbanHospitals;
        UrbanBeds = urbanBeds;
        TotalHospitals = totalHospitals;
        TotalBeds = totalBeds;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getRuralHospitals() {
        return RuralHospitals;
    }

    public void setRuralHospitals(String ruralHospitals) {
        RuralHospitals = ruralHospitals;
    }

    public String getRuralBeds() {
        return RuralBeds;
    }

    public void setRuralBeds(String ruralBeds) {
        RuralBeds = ruralBeds;
    }

    public String getUrbanHospitals() {
        return UrbanHospitals;
    }

    public void setUrbanHospitals(String urbanHospitals) {
        UrbanHospitals = urbanHospitals;
    }

    public String getUrbanBeds() {
        return UrbanBeds;
    }

    public void setUrbanBeds(String urbanBeds) {
        UrbanBeds = urbanBeds;
    }

    public String getTotalHospitals() {
        return TotalHospitals;
    }

    public void setTotalHospitals(String totalHospitals) {
        TotalHospitals = totalHospitals;
    }

    public String getTotalBeds() {
        return TotalBeds;
    }

    public void setTotalBeds(String totalBeds) {
        TotalBeds = totalBeds;
    }
}
