package M4_Sesion8;

import java.time.LocalDate;

public class Vegetales extends Producto {
    private LocalDate fechaEnvasado;
    private LocalDate fechaCaducidad;

    //Constructor
    public Vegetales(String nombre, String codigo, int precio, LocalDate fechaEnvasado, LocalDate fechaCaducidad) {
        super(nombre, codigo, precio);
        this.fechaEnvasado = fechaEnvasado;
        this.fechaCaducidad = fechaCaducidad;
    }

    //Getters
    public LocalDate getFechaEnvasado() {
        return fechaEnvasado;
    }

    public LocalDate fechaCaducidad() {
        return fechaCaducidad;
    }

    //Setters
    public void setFechaEnvasado(LocalDate fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    //toString
    @Override
    public String toString() {
        return "Vegetales [" +
                " nombre= " + getNombre() +
                ", codigo= " + getCodigo() +
                ", precio= " + getPrecio() +
                ", fechaEnvasado= " + fechaEnvasado +
                ", fechaCaducidad= " + fechaCaducidad + "]";
    }
}

