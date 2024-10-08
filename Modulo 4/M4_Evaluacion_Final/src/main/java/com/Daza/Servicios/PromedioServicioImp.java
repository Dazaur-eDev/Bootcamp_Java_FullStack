package com.Daza.Servicios;

import java.util.List;

public class PromedioServicioImp {

    public double calcularPromedio(List<Double> notas) {
        double promedio = 0.0;
        double total = 0.0;

        if (notas == null || notas.isEmpty()) {
            return promedio;
        }

        for (Double nota : notas) {
            total += nota;
        }

        promedio = total / notas.size();
        return promedio;
    }
}
