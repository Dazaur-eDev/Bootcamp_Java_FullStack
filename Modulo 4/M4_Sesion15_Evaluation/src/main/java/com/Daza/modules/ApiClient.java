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

    private static final String API = "https://api.ipbase.com/v2/";
    private static final String ENDPOINT = "info";

    public static ApiResponse connection() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API).path(ENDPOINT);
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response apiResponse = invocationBuilder.get();
        String jsonResponse = apiResponse.readEntity(String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Parsear el JSON
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            // Acceder a los valores anidados de forma segura
            String continentName = rootNode.path("data").path("location").path("continent").path("name").asText();
            String countryName = rootNode.path("data").path("location").path("country").path("name").asText();
            String cityName = rootNode.path("data").path("location").path("city").path("name").asText();
            String regionName = rootNode.path("data").path("location").path("region").path("name").asText();

            ApiResponse apiObject = new ApiResponse(cityName, regionName, countryName, continentName);
            return apiObject;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
//
//    private static String extractValue(String json, String[] keys) {
//        String currentJson = json;
//
//        for (String key : keys) {
//
//            // CREAMOS PATRON DE BÚSQUEDA
//            String searchString = "\"" + key + "\"";
//
//            // BUSCAMOS LA POSICIÓN DE LA LLAVE
//            int keyIndex = currentJson.indexOf(searchString);
//            if (keyIndex == -1) {
//                return null;
//            }
//
//            // BUSCA EL "COLON" PARA SEPARAR CLAVE Y VALOR
//            int colonIndex = currentJson.indexOf(":", keyIndex);
//            if (colonIndex == -1) {
//                return null;
//            }
//
//            // BUSCAMOS EL INICIO DEL VALOR POSTERIOR AL "COLON"
//            int valueStartIndex = currentJson.indexOf("\"", colonIndex);
//            if (valueStartIndex == -1) {
//                return null;
//            }
//
//            // BUSCAMOS LA POSICIÓN FINAL DE LAS COMILLAS DE CIERRE.
//            int valueEndIndex = currentJson.indexOf("\"", valueStartIndex + 1);
//            if (valueEndIndex == -1) {
//                return null;
//            }
//
//            // SI ES LA ULTIMA CLAVE EXTRAEMOS EL VALOR
//            if (key.equals(keys[keys.length - 1])) {
//                return currentJson.substring(valueStartIndex + 1, valueEndIndex);
//            } else {
//                // SI NO ES LA ULTIMA CLAVE, CONTINÚA BUSCANDO
//                currentJson = currentJson.substring(valueEndIndex);
//            }
//        }
//        return null;



//        String[] continent = {"data", "location", "continent", "name"};
//        String continentName = extractValue(jsonResponse, continent);
//        System.out.println("Continent Name: " + continentName);
//
//        String[] country = {"data", "location", "country", "name"};
//        String countryName = extractValue(jsonResponse, country);
//        System.out.println("Country Name: " + countryName);
//
//        String[] city = {"data", "location", "city", "name"};
//        String cityName = extractValue(jsonResponse, city);
//        System.out.println("City Name: " + cityName);
//
//        String[] region = {"data", "location", "region", "name"};
//        String regionName = extractValue(jsonResponse, region);
//        System.out.println("Region Name: " + regionName);


//        ApiResponse apiObject = new ApiResponse(cityName, regionName, countryName, continentName);
//        return apiObject;
//    }
//}





//        "location": {
//        "continent": {
//        "name": "South America",
//        "country": { name: chilena peso name unidad Fomento *******
//        "name": "Chile",
//        "city": {
//        "name": "Antofagasta",
//        "region": {
//        "name": "De Antofagasta",
