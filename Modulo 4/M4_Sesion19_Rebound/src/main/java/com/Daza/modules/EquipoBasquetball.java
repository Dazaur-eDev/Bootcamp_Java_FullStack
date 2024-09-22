package com.Daza.modules;
import java.util.ArrayList;
import java.util.List;
public class EquipoBasquetball {
    private String nombreEquipo;
    private String ciudad;
    private static List<Jugador> nomina = new ArrayList();

    public EquipoBasquetball(String nombreEquipo, String ciudad, List<Jugador> nomina) {
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
        this.nomina = nomina;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public static EquipoBasquetball crearEquipo(String nombreEquipo, String ciudad, List<Jugador> nomina) {
        return new EquipoBasquetball(nombreEquipo, ciudad, nomina);
    }

    @Override
    public String toString() {
        return "EquipoBasquetball{" +
                "nombreEquipo='" + nombreEquipo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", listaJugadores=" + nomina +
                '}';
    }
}
