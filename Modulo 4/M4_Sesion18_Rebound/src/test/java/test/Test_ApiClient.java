package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.Daza.modules.ApiClient;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests para la clase ApiClient")
public class Test_ApiClient {

    @Test
    @DisplayName("Test Api Connection")
    void testApiConnection() {
        assertEquals("Connection to the API : Valid", ApiClient.apiConnection());
    }

    @Test
    @DisplayName("Test Status Connection")
    void testStatusConnection() {
        assertEquals("Connection status with the ISS server : success", ApiClient.statusConnection());
    }
    String idFormat = "^\\d{10}$";;
    @Test
    @DisplayName("Test ID Connection")
    void testIdConnection() {
        assertTrue(ApiClient.idConnection().matches(idFormat), "Not valid");
    }

    String latLongFormat = "-?\\d{1,2}\\.\\d{4}";
    @Test
    @DisplayName("Test Latitude")
    void testInfoLatitude() {
        assertTrue(ApiClient.infoLat().matches(latLongFormat), "Not valid");
    }

    @Test
    @DisplayName("Test Longitude")
    void testInfoLongitude() {
        assertTrue(ApiClient.infoLong().matches(latLongFormat), "Not valid");
    }
}
