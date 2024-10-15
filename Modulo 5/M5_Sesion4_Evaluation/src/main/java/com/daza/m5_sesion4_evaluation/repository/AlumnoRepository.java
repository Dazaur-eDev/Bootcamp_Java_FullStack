package com.daza.m5_sesion4_evaluation.repository;

import com.daza.m5_sesion4_evaluation.model.Alumno;

import java.util.List;

public interface AlumnoRepository {
    List<Alumno> listarAlumnos();
    void insertarAlumno(Alumno alumno);
    void eliminarAlumno(long id);
    Alumno buscarAlumno(Alumno alumno);
    void actualizarAlumno(Alumno alumno);

}
