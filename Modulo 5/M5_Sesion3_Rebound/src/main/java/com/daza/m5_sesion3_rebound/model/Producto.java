package com.daza.m5_sesion3_rebound.model;

public class Producto {
    private int id;
    private String concepto;
    private int importe;

    public Producto(){

    }

    public Producto(int id, String concepto, int importe) {
        this.id = id;
        this.concepto = concepto;
        this.importe = importe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", concepto='" + concepto + '\'' +
                ", importe=" + importe +
                '}';
    }
}
