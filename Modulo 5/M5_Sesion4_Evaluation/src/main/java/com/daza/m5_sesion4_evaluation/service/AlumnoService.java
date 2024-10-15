package com.daza.m5_sesion4_evaluation.service;

import com.daza.m5_sesion4_evaluation.model.Alumno;

import java.util.List;

public interface AlumnoService {
    List<Alumno> listarAlumnos();
    void registrarAlumno(Alumno alumno);
    void retirarAlumno(long id);
}
