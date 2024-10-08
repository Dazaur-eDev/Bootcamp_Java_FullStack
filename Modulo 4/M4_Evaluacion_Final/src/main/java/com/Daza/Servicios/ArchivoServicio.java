package com.Daza.Servicios;

import com.Daza.modelos.Alumno;
import com.Daza.modelos.Materia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ArchivoServicio {
    PromedioServicioImp promedioServicioImp = new PromedioServicioImp();

    public void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ruta))) {
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            int contador = 1;
            printWriter.println("Registro de estudiantes Liceo Latinoamericano");
            for (Alumno alumno : alumnos.values()) {
                printWriter.println("=====================================");
                printWriter.println("Registro Número " + contador);
                printWriter.println("Alumno : " + alumno.getRut() + " - " + alumno.getNombre() + " " + alumno.getApellido());
                double promedioGeneral = 0;
                double totalPromediosPorAsignatura = 0;
                int contadorMaterias = 0;
                double promedioMateria;

                if (!alumno.getMateriasAlumno().isEmpty()) {
                    for (Materia materia : alumno.getMateriasAlumno()) {
                        printWriter.print("    " + materia.getNombre() + " : " + materia.getNotas());
                        promedioMateria = promedioServicioImp.calcularPromedio(materia.getNotas());
                        printWriter.printf(" Promedio : %.2f%n", promedioMateria);
                        totalPromediosPorAsignatura += promedioMateria;
                        contadorMaterias++;
                    }
                    promedioGeneral = totalPromediosPorAsignatura / contadorMaterias;
                    printWriter.printf("Promedio General : %.2f%n", promedioGeneral);
                } else {
                    printWriter.println(" Alumno sin materias asignadas");
                }
                contador++;
            }
            System.out.println("Se ha escrito el archivo de forma satisfactoria");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir el archivo: " + e.getMessage());
        }
    }
}
