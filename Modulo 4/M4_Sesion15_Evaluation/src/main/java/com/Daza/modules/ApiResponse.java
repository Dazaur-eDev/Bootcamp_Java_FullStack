package com.Daza.modules;

public class ApiResponse {
    private String city;
    private String region;
    private String country;
    private String continent;

    public ApiResponse(String city, String region, String country, String continent) {
        this.city = city;
        this.region = region;
        this.country = country;
        this.continent = continent;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "ApiResponse [" +
                "city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", continent='" + continent + '\'' +
                "]";
    }
}
