package com.daza.m5_sesion2_jsp_hotel.servicio;

import com.daza.m5_sesion2_jsp_hotel.modelo.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class HabitacionServicio {
    private static List<Habitacion> habitaciones;

    public HabitacionServicio() {
        habitaciones = new ArrayList<>((List.of(
                new Habitacion(1, "Habitación 1, Simple", "Habitación Clasica con cama extragrande, vistas al oceano y balcon", "./assets/images/img1.webp", 10000, 1, 20),
                new Habitacion(2, "Habitación 2, Doble - Simple", "Habitación Clasica con 2 camas grandes o dobles, vistas al oceano y balcon", "./assets/images/img2.webp", 20000, 1, 30),
                new Habitacion(3, "Habitación 3, Doble - Normal", "Habitación Superior en planta alta con vistas al oceano y 2 camas dobles", "./assets/images/img3.webp", 30000, 1, 40),
                new Habitacion(4, "Habitacion 4, Doble - King", "Suite Executive en planta superior con cama extragrande y vistas al oceano", "./assets/images/img4.jpg", 40000, 1, 100),
                new Habitacion(5, "Habitación 5, Doble - King", "Suite Executive en planta superior con cama extragrande y vistas al oceano", "./assets/images/img5.jpg", 50000, 2, 60),
                new Habitacion(6, "Habitación 6, Doble - King", "Suite Executive en planta superior con cama extragrande y vistas al oceano", "./assets/images/img6.jpg", 60000, 2, 80),
                new Habitacion(7, "Habitación 7, Doble - King", "Suite Executive en planta superior con cama extragrande y vistas al oceano", "./assets/images/img7.jpg", 70000, 1, 15),
                new Habitacion(8, "Habitación 8, Doble - King", "Suite Executive en planta superior con cama extragrande y vistas al oceano", "./assets/images/img8.webp", 80000, 4, 150)
        )));
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
    public int contarHabitaciones(){
        return habitaciones.size();
    }
    public Habitacion getHabitacionPorId(String id) {
        int idInt = Integer.parseInt(id);
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getId() == idInt) {
                return habitacion;
            }
        }
        return null;
    }
}
