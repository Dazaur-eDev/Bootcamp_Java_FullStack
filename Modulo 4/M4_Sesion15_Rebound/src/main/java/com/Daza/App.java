package com.Daza;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import com.Daza.modules.SimpleJoke;
import com.Daza.modules.TenJokes;
import com.Daza.utils.JsonSerializer;

import java.util.List;
import java.util.Scanner;

public class App {
    static int option = 0;
    static boolean tokenOut = false;

    public static void main(String[] args) {

        while (!tokenOut) {
            menu();
            dataInput();
            switch (option) {
                case 1:
                    jokes(option);
                    break;
                case 2:
                    jokes(option);
                    break;
                case 3:
                    tokenOut = true;
                    break;
                default:
                    System.out.println("Not valid option.");
                    break;
            }
            option = 0;
        }
    }

    public static int dataInput() {
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(System.in);
            option = Integer.parseInt(String.valueOf(sc.nextLine()));
        } catch (Exception e) {
            System.out.println("Please enter a number between 1 and 3");
        } finally {
//            sc.close();
        }
        return option;
    }

    public static void menu() {
        System.out.println("Welcome to practice program.");
        System.out.println("Options:");
        System.out.println("1.- One random Joke.");
        System.out.println("2.- Ten randoms Jokes.");
        System.out.println("3.- Exit program.");
    }

    public static void jokes(int option) {
        if (option == 1) {
            System.out.println("Receiving one joke from API...");
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("https://official-joke-api.appspot.com").path("random_Joke");

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            Response answerJoke = invocationBuilder.get();

            SimpleJoke joke = answerJoke.readEntity(new GenericType<>() {
            });
            System.out.println(joke.toJson());

        } else if (option == 2) {
            System.out.println("Receiving ten jokes from API...");
            Client client2 = ClientBuilder.newClient();
            WebTarget target2 = client2.target("https://official-joke-api.appspot.com").path("random_ten");

            Invocation.Builder invocationBuilder2 = target2.request(MediaType.APPLICATION_JSON);
            Response answerTenJokes = invocationBuilder2.get();
            List<TenJokes> tenJokes = answerTenJokes.readEntity(new GenericType<>() {
            });

            String jsonSerializer = JsonSerializer.toJsonArray(tenJokes);
            System.out.println(jsonSerializer);
        }
    }
}


