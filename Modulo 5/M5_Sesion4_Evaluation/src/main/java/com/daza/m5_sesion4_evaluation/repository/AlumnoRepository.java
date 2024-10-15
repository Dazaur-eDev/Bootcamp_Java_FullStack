package com.daza.m5_sesion4_evaluation.repository;

import com.daza.m5_sesion4_evaluation.model.Alumno;

import java.util.List;

public interface AlumnoRepositorio {
    List<Alumno> listarAlumno();
    void insertarAlumno(Alumno alumno);
    void eliminarAlumno(Alumno alumno);
    Alumno buscarAlumno(Alumno alumno);
    void actualizarAlumno(Alumno alumno);
}
