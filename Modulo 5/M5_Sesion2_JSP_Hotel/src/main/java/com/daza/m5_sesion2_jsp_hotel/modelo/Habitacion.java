package com.daza.m5_sesion2_jsp_hotel.modelo;

public class Habitacion {
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private int precio;
    private int piezas;
    private int metraje;

    public Habitacion(int id, String nombre, String descripcion, String imagen, int precio, int piezas, int metraje) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.piezas = piezas;
        this.metraje = metraje;
    }

    public Habitacion(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public int getMetraje() {
        return metraje;
    }

    public void setMetraje(int metraje) {
        this.metraje = metraje;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio=" + precio +
                ", piezas=" + piezas +
                ", metraje=" + metraje +
                '}';
    }
}
