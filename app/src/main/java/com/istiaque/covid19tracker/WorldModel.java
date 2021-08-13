package com.istiaque.covid19tracker;

public class WorldModel {

    private String Country_Name;
    private String Country_Image;

    public WorldModel(String country_Name, String country_Image) {
        Country_Name = country_Name;
        Country_Image = country_Image;
    }

    private String CountryCases;
    private String CountryTodayCases;
    private String CountryDeaths;
    private String CountryTodayDeaths;
    private String CountryRecovered;
    private String CountryActive;
    private String CountryCritical;
    private String CountryTests;
    private String CountryPopulation;
    private String CountryContinent;
    private String CountryUndefined;

    public WorldModel(String countryCases, String CountryTodayCases, String countryDeaths,String countryTodayDeaths, String countryRecovered, String countryActive, String countryCritical, String countryTests, String countryPopulation, String countryContinent, String countryUndefined) {
        CountryCases = countryCases;
        CountryTodayCases = CountryTodayCases;
        CountryDeaths = countryDeaths;
        CountryTodayDeaths = countryTodayDeaths;
        CountryRecovered = countryRecovered;
        CountryActive = countryActive;
        CountryCritical = countryCritical;
        CountryTests = countryTests;
        CountryPopulation = countryPopulation;
        CountryContinent = countryContinent;
        CountryUndefined = countryUndefined;
    }

    public String getCountry_Name() {
        return Country_Name;
    }

    public void setCountry_Name(String country_Name) {
        Country_Name = country_Name;
    }

    public String getCountry_Image() {
        return Country_Image;
    }

    public void setCountry_Image(String country_Image) {
        Country_Image = country_Image;
    }

    public String getCountryCases() {
        return CountryCases;
    }

    public void setCountryCases(String countryCases) {
        CountryCases = countryCases;
    }

    public String getCountryTodayCases() {
        return CountryTodayCases;
    }

    public void setCountryTodayCases(String countryTodayCases) {
        CountryTodayCases = countryTodayCases;
    }

    public String getCountryDeaths() {
        return CountryDeaths;
    }

    public void setCountryDeaths(String countryDeaths) {
        CountryDeaths = countryDeaths;
    }

    public String getCountryTodayDeaths() {
        return CountryTodayDeaths;
    }

    public void setCountryTodayDeaths(String countryTodayDeaths) {
        CountryTodayDeaths = countryTodayDeaths;
    }

    public String getCountryRecovered() {
        return CountryRecovered;
    }

    public void setCountryRecovered(String countryRecovered) {
        CountryRecovered = countryRecovered;
    }

    public String getCountryActive() {
        return CountryActive;
    }

    public void setCountryActive(String countryActive) {
        CountryActive = countryActive;
    }

    public String getCountryCritical() {
        return CountryCritical;
    }

    public void setCountryCritical(String countryCritical) {
        CountryCritical = countryCritical;
    }

    public String getCountryTests() {
        return CountryTests;
    }

    public void setCountryTests(String countryTests) {
        CountryTests = countryTests;
    }

    public String getCountryPopulation() {
        return CountryPopulation;
    }

    public void setCountryPopulation(String countryPopulation) {
        CountryPopulation = countryPopulation;
    }

    public String getCountryContinent() {
        return CountryContinent;
    }

    public void setCountryContinent(String countryContinent) {
        CountryContinent = countryContinent;
    }

    public String getCountryUndefined() {
        return CountryUndefined;
    }

    public void setCountryUndefined(String countryUndefined) {
        CountryUndefined = countryUndefined;
    }
}

