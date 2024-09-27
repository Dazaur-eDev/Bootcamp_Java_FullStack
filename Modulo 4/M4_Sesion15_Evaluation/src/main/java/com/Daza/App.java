package com.Daza;

import com.Daza.modules.ApiClient;
import com.Daza.utils.ReadConsole;

import java.sql.SQLOutput;

public class App {
    public static void main(String[] args) {

        System.out.println("Welcome, follow the next three steps:");
        System.out.println("1.- Please enter your name");
        String userName = ReadConsole.dataInputString();
        System.out.println("2.- Please enter your email");
        String userEmail = ReadConsole.dataInputString();
        System.out.println("3.- Please enter your password");
        String userPassword = ReadConsole.dataInputString();
        System.out.println("_________________________________________________");
        System.out.println("Your username is " + userName);
        System.out.println("Your email is " + userEmail);
        System.out.println("Your password is " + userPassword);
        System.out.println("Searching your location with ip address");
        System.out.println("City: " + ApiClient.connection().getCity());
        System.out.println("Region: " + ApiClient.connection().getRegion());
        System.out.println("Country: " + ApiClient.connection().getCountry());
        System.out.println("City: " + ApiClient.connection().getContinent());
    }

}


