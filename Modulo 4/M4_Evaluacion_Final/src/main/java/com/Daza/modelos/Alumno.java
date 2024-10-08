package com.Daza.modelos;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String rut;
    private String nombre;
    private String apellido;
    private String direccion;
    private List<Materia> materiasAlumno = new ArrayList<>();

    public Alumno(String rut, String nombre, String apellido, String direccion, List<Materia> materiasAlumno) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.materiasAlumno = materiasAlumno;
    }

    public Alumno(String rut, String nombre, String apellido, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Materia> getMateriasAlumno() {
        return materiasAlumno;
    }

    public void setMateriasAlumno(List<Materia> materias) {
        this.materiasAlumno = materias;
    }

    public void addMateriasAlumno(Materia materia) {
        this.materiasAlumno.add(materia);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "rut='" + rut + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", materiasAlumno=" + materiasAlumno +
                '}';
    }
}
