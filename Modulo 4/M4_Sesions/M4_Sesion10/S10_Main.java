package M4_Sesion10;

import java.util.ArrayList;
import java.util.List;

public class S10_Main {

    public static void S10() {

        //Crear Director
        Director d1 = new Director("Marcelo", "Bielsa", 45, 10, false);
        //Crear Jugadores
        Jugador j1 = new Jugador("Patricio", "Daza", 33, 2, "Defensa", false);
        Jugador j2 = new Jugador("Daniel", "Urqueta", 30, 3, "Defensa", false);
        Jugador j3 = new Jugador("Juan", "Contador", 33, 4, "Defensa", false);
        Jugador j4 = new Jugador("Pedro", "Reyes", 26, 5, "Defensa", false);
        Jugador j5 = new Jugador("Mauro", "Briceño", 37, 6, "Mediocampista", false);
        Jugador j6 = new Jugador("Alexis", "Sanchez", 21, 7, "Mediocampista", false);
        Jugador j7 = new Jugador("Mauro", "Seneca", 27, 8, "Mediocampista", false);
        Jugador j8 = new Jugador("Eduardo", "Vargas", 35, 9, "Delantero", false);
        Jugador j9 = new Jugador("Mauricio", "Pinilla", 38, 10, "Delantero", false);
        Jugador j10 = new Jugador("Mauricio", "Pinilla", 27, 11, "Mediocampista", false);
        Jugador j11 = new Jugador("Claudio", "Bravo", 40, 1, "Arquero", false);

        // Lista para guardar los seleccionados con el director
        List<Persona> seleccion = new ArrayList();

        // Agregar al Director
        seleccion.add(d1);

        // Agregar a los jugadores desde listajugadores[]
        Jugador[] listaJugadores = {j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11};
        for (Jugador jugador : listaJugadores) {
            seleccion.add(jugador);
        }

        //Mostrar el listado completo del equipo desde lista Seleccion
        for (Persona jugador : seleccion) {
            System.out.println(jugador);
        }

        //Acciones
        listaJugadores[1].recibirTarjetaAmarilla();
        listaJugadores[1].setAmonestado(true);
        listaJugadores[2].recibirTarjetaRoja();
        listaJugadores[2].setAmonestado(true);
        d1.recibirTarjetaAmarilla();
        d1.hablar();
        listaJugadores[1].hablar();
        d1.celebrar();
        j2.celebrar();

    }
}