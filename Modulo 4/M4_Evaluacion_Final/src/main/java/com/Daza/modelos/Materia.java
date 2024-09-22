package com.Daza.modelos;

import java.util.List;

public class Materia {
    private MateriaEnum nombre;
    private List<Double> notas;

    public Materia(MateriaEnum nombre, List<Double> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }
}
