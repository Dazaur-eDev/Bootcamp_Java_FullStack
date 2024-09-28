package com.Daza.modules;

public class ApiResponse {
    private String apiConnection;
    private String statusConnection;
    private String latitude;
    private String longitude;
    private String idConnection;

    public ApiResponse(String apiConnection, String statusConnection, String latitude, String longitude, String idConnection) {
        this.apiConnection = apiConnection;
        this.statusConnection = statusConnection;
        this.latitude = latitude;
        this.longitude = longitude;
        this.idConnection = idConnection;
    }

    public String getApiConnection() {
        return apiConnection;
    }

    public void setApiConnection(String apiConnection) {
        this.apiConnection = apiConnection;
    }

    public String getStatusConnection() {
        return statusConnection;
    }

    public void setStatusConnection(String statusConnection) {
        this.statusConnection = statusConnection;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getIdConnection() {
        return idConnection;
    }

    public void setIdConnection(String idConnection) {
        this.idConnection = idConnection;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "apiConnection='" + apiConnection + '\'' +
                ", statusConnection='" + statusConnection + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", idConnection='" + idConnection + '\'' +
                '}';
    }
}
