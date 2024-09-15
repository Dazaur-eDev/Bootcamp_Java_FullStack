package M4_Sesion17;

import M4_Sesion17.Modulos_R.*;

import java.sql.SQLOutput;

public class S17_Main {
    public static void S17() {
        //Se considera todas las variables de estado en false para ir definiendo cada una.
        Alas alas = new Alas("35 metros", false);
        Motor motor = new Motor(false, false);
        Rueda rueda = new Rueda(true, false);
        Cabina cabina = new Cabina(180, 2, false, false);

        Avion avion = new Avion("Airbus", "A320", false, alas, motor, cabina, rueda);
        PistaAeropuerto pista = new PistaAeropuerto(false);
        System.out.println("Control porfavor habilitar pista. Gracias");
        pista.actualizarDisponibilidad(true);
        avion.recibirPasajeros();
        cabina.cerrarPuertas();
        cabina.setBuenEstado(true);
        cabina.setPuertasCerradas(true);
        cabina.cerrarPuertas();
        motor.cargarCombustible();
        motor.setTieneCombustible(true);
        motor.setBuenEstado(true);
        motor.cargarCombustible();
        alas.pruebaAlas();
        rueda.inflar();
        rueda.setBuenEstado(true);
        avion.despegar();
    }
}

