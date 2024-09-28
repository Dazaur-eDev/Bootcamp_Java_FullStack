package com.Daza.modules;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

public class ApiClient {

    private static final String API_ADDRESS = "http://api.open-notify.org/";
    private static final String ENDPOINT = "iss-now.json";

    public static ApiResponse connection() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_ADDRESS).path(ENDPOINT);
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response apiResponse = invocationBuilder.get();
        String jsonResponse = apiResponse.readEntity(String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            String statusConnection = rootNode.path("message").asText();
            String timestamp = rootNode.path("timestamp").asText();
            String latitude = rootNode.path("iss_position").path("latitude").asText();
            String longitude = rootNode.path("iss_position").path("longitude").asText();
            String apiConnection = "Valid";

            return new ApiResponse(apiConnection, statusConnection, latitude, longitude, timestamp);

        } catch (IOException e) {
            System.out.println("Error trying to grab data from API : " + e.getMessage());
            return null;
        }
    }

    public static String apiConnection() {
        return "Connection to the API : " + connection().getApiConnection();
    }

    public static String statusConnection() {
        return "Connection status with the ISS server : " + connection().getStatusConnection();
    }

    public static String idConnection() {
        return connection().getIdConnection();
    }

    public static String infoLat() {
        return connection().getLatitude();
    }

    public static String infoLong() {
        return connection().getLongitude();
    }
}
