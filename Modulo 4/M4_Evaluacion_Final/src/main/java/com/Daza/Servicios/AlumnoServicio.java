package com.Daza.Servicios;

import com.Daza.modelos.Alumno;
import com.Daza.modelos.Materia;
import com.Daza.modelos.MateriaEnum;

import java.util.*;

public class AlumnoServicio {
    public static Map<String, Alumno> listaAlumnos = new LinkedHashMap<>();
    {
        //Alumno con notas y asignaturas asignadas
        List<Double> notasPrueba = new ArrayList<>();
        notasPrueba.add(6.5);
        notasPrueba.add(4.0);
        notasPrueba.add(7.0);
        List<Double> notasPrueba2 = new ArrayList<>();
        notasPrueba2.add(1.5);
        notasPrueba2.add(2.0);
        notasPrueba2.add(2.0);

        Materia matematicasPrueba = new Materia(MateriaEnum.MATEMATICAS, notasPrueba);
        Materia lenguajePrueba = new Materia(MateriaEnum.LENGUAJE, notasPrueba2);
        List<Materia> asignaturasPrueba = new ArrayList<>();
        asignaturasPrueba.add(matematicasPrueba);
        asignaturasPrueba.add(lenguajePrueba);

        Alumno alumnoPrueba = new Alumno("17656624-8", "Patricio", "Daza", "Cobija, Calama", asignaturasPrueba);
        listaAlumnos.put(alumnoPrueba.getRut(), alumnoPrueba);

        //Alumno sin notas ni asignaturas asignadas
        Alumno alumnoPrueba2 = new Alumno("17656624-9", "Daniel", "Urqueta", "Cobija, Calama");
        listaAlumnos.put(alumnoPrueba2.getRut(), alumnoPrueba2);
    }

    public void crearAlumno(Alumno nuevoAlumno) {
        if (nuevoAlumno != null) {
            if (listaAlumnos.containsKey(nuevoAlumno.getRut())) {
                System.out.println("Alumno ya existe");
            } else {
                listaAlumnos.put(nuevoAlumno.getRut(), nuevoAlumno);
                System.out.println(" --- ALUMNO AGREGADO ---");
                System.out.println("Nombre : " + nuevoAlumno.getNombre() + " " + nuevoAlumno.getApellido() + " - " + nuevoAlumno.getRut());
            }
        }
    }

    public void agregarMateria(String rutAlumno, Materia nuevaMateria) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            boolean materiaYaAsignada = alumno.getMateriasAlumno().stream()
                    .anyMatch(materia -> materia.getNombre().equals(nuevaMateria.getNombre()));
            if (!materiaYaAsignada) {
                alumno.addMateriasAlumno(nuevaMateria);
                System.out.println(" --- MATERIA AGREGADA ---");
                System.out.println("Materia asignada a alumno: " + alumno.getNombre() + " " + alumno.getApellido() + " - " + alumno.getRut());
            } else {
                System.out.println("Materia ya asignada, proceso cancelado");
            }
        } else {
            System.out.println("Alumno no existe");
        }
    }

    public void agregarNota(String rutAlumno, Materia nuevaMateria, double nota) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            Materia materiaActual = alumno.getMateriasAlumno().stream()
                    .filter(materia -> materia.getNombre().equals(nuevaMateria.getNombre()))
                    .findFirst()
                    .orElse(null);
            if (materiaActual != null) {
                materiaActual.getNotas().add(nota);
                System.out.println(" --- NOTA AGREGADA A " + nuevaMateria.getNombre() + " ---");
                System.out.println("Nota asignada a alumno: " + alumno.getNombre() + " " + alumno.getApellido() + " - " + alumno.getRut());
                System.out.println("Todas las notas de " + materiaActual.getNombre() + " son : " + materiaActual.getNotas());
            } else {
                alumno.addMateriasAlumno(nuevaMateria);
                nuevaMateria.getNotas().add(nota);
                System.out.println(" --- MATERIA AGREGADA ---");
                System.out.println("Materia asignada a alumno: " + alumno.getNombre() + " " + alumno.getApellido() + " - " + alumno.getRut());
                System.out.println(" --- NOTA AGREGADA A " + nuevaMateria.getNombre() + " ---");
                System.out.println("Nota asignada a alumno: " + alumno.getNombre() + " " + alumno.getApellido() + " - " + alumno.getRut());
                System.out.println("Todas las notas de " + nuevaMateria.getNombre() + " son : " + nuevaMateria.getNotas());

            }
        } else {
            System.out.println("Alumno no existe");
        }
    }


    public List<Materia> materiasPorAlumno(String rutAlumno) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            return alumno.getMateriasAlumno();
        } else {
            System.out.println("Alumno no existe en el listado");
            return null;
        }
    }

    public static Map<String, Alumno> listarAlumnos() {
        if (listaAlumnos.isEmpty()) {
            System.out.println("No existen alumnos inscritos");
            return null;
        } else {
            return listaAlumnos;
        }
    }
}
