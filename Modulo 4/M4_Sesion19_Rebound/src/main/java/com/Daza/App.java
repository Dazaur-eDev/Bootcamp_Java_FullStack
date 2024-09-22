package com.Daza;

import com.Daza.modules.EquipoBasquetball;
import com.Daza.modules.Jugador;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) {

        Jugador jugador1 = Jugador.crearJugador("Patricio", 33, 10);
        Jugador jugador2 = Jugador.crearJugador("Daniel", 27, 7);
        Jugador jugador3 = Jugador.crearJugador("Daza", 22, 12);

        List<Jugador> nomina = new ArrayList<>();
        nomina.add(jugador1);
        nomina.add(jugador2);
        nomina.add(jugador3);

        EquipoBasquetball equipo = EquipoBasquetball.crearEquipo("Los Dazabois", "Ciudad de Calama", nomina);
        System.out.println(equipo);
    }
}
