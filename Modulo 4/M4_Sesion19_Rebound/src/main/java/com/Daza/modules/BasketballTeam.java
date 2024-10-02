package com.Daza.modules;

import java.util.ArrayList;
import java.util.List;

public class BasketballTeam {
    private String name;
    private String city;
    private List<Player> listOfPlayers = new ArrayList<>();

    public BasketballTeam(String name, String city, List<Player> listOfPlayers) {
        this.name = name;
        this.city = city;
        this.listOfPlayers = listOfPlayers;
    }

    public BasketballTeam() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String ciudad) {
        this.city = ciudad;
    }

    public BasketballTeam createTeam(String teamName, String city, List<Player> listOfPlayers) {
        return new BasketballTeam(teamName, city, listOfPlayers);
    }

    @Override
    public String toString() {
        return "BasketballTeam{" +
                "name='" + name + '\'' +
                ", ciudad='" + city + '\'' +
                ", listaJugadores=" + listOfPlayers +
                '}';
    }
}
