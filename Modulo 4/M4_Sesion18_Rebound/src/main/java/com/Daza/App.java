package com.Daza;

import static com.Daza.modules.ApiClient.*;

public class App {

    public static void main(String[] args) {
        System.out.println(apiConnection());
        System.out.println(statusConnection());
        System.out.print("Id Connection (Unix Time) : ");
        System.out.println(idConnection());
        System.out.print("International Station Latitude : ");
        System.out.println(infoLat());
        System.out.print("International Station Longitude : ");
        System.out.println(infoLong());
    }

}
