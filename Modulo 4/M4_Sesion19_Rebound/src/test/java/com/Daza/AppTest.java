package com.Daza;

import com.Daza.modules.BasketballTeam;
import com.Daza.modules.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Test for Player and BasketballTeam  Class")
class AppTest {

    Player player;
    Player playerMock;
    BasketballTeam basketballTeam;
    BasketballTeam basketballTeamMock;
    List<Player> listOfPlayersTeam = new ArrayList<>();
    List<Player> listOfPlayersTeamMock = new ArrayList<>();

    @BeforeEach
    void setup(){
        //Create the mock Player and a Player to validate
        playerMock = mock(Player.class);
        player = new Player("Daza", 33, 10);

        //Create the mock team and a team to validate and a list of player and the mocked list too
        basketballTeamMock = mock(BasketballTeam.class);
        listOfPlayersTeam.add(player);
        basketballTeam = new BasketballTeam("Los Dazabois", "Calama", listOfPlayersTeam);
        listOfPlayersTeamMock.add(playerMock);
        basketballTeamMock.createTeam("Los Dazabois", "Calama", listOfPlayersTeamMock);
    }

    @Test
    @DisplayName("Test for create a player")
    void testCreatePlayer() {
        when(playerMock.createPlayer("Daza",33,10)).thenReturn(player);

        when(playerMock.getName()).thenReturn(player.getName());
        when(playerMock.getAge()).thenReturn(player.getAge());
        when(playerMock.getNumber()).thenReturn(player.getNumber());

        assertEquals(playerMock.getName(), player.getName());
        assertEquals(playerMock.getAge(), player.getAge());
        assertEquals(playerMock.getNumber(), player.getNumber());
    }

    @Test
    @DisplayName("Verify Create Player")
    void verifyCreatePlayer() {
        Player createdPlayer = playerMock.createPlayer("Daza",33,10);
        verify(playerMock).createPlayer("Daza", 33, 10);
    }

    @Test
    @DisplayName("Test for create a team")
    void testCreateTeam() {
        when(basketballTeamMock.createTeam("Los Dazabois", "Calama", listOfPlayersTeamMock)).thenReturn(basketballTeam);

        when(basketballTeamMock.getName()).thenReturn(basketballTeam.getName());
        when(basketballTeamMock.getCity()).thenReturn(basketballTeam.getCity());

    }

    @Test
    @DisplayName("Verify Create Team")
    void verifyCreateTeam() {
        verify(basketballTeamMock).createTeam("Los Dazabois", "Calama", listOfPlayersTeamMock);
    }
}