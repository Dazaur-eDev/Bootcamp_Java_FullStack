package org.example;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Modelo.Publicacion;
import org.example.util.JsonSerializer;

import java.util.List;

public class App {
    public static void main( String[] args ) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts");

        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response respuestaPublicaciones = invocationBuilder.get();
        List<Publicacion> listaPublicaciones = respuestaPublicaciones.readEntity(new GenericType<>() {});

        String jsonSerializer = JsonSerializer.toJsonArray(listaPublicaciones);
        System.out.println(jsonSerializer);

    }
}


