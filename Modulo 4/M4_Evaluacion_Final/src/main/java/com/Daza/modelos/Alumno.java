package com.Daza.modelos;

import java.util.HashSet;
import java.util.Set;

public class Alumno {
    private String rut;
    private String nombre;
    private String apellido;
    private String direccion;
    private Set<MateriaEnum> materiasAlumno = new HashSet<>();
}
