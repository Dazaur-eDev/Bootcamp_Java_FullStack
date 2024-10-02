package com.Daza;

import com.Daza.modules.BasketballTeam;
import com.Daza.modules.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void program() {
        Player player = new Player();
        BasketballTeam basketballTeam = new BasketballTeam();

        List<Player> listOfPlayersTeam1 = new ArrayList<>();
        listOfPlayersTeam1.add(player.createPlayer("Patricio", 33, 10));
        listOfPlayersTeam1.add(player.createPlayer("Daza", 22, 12));

        List<Player> listOfPlayersTeam2 = new ArrayList<>();
        listOfPlayersTeam2.add(player.createPlayer("Mike", 33, 10));
        listOfPlayersTeam2.add(player.createPlayer("Johnson", 27, 7));
        listOfPlayersTeam2.add(player.createPlayer("Mark", 22, 12));

        BasketballTeam team1 = basketballTeam.createTeam("Los Dazabois", "Calama", listOfPlayersTeam1);
        BasketballTeam team2 = basketballTeam.createTeam("Dallas", "NewYork", listOfPlayersTeam2);

        System.out.println("Equipo : " + team1.getName() + " - Total Players : " + listOfPlayersTeam1.size());
        System.out.println("Equipo : " + team2.getName() + " - Total Players : " + listOfPlayersTeam2.size());
    }
}