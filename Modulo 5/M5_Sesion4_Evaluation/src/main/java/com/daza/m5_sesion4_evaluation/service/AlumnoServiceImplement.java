package com.daza.m5_sesion4_evaluation.service;

import com.daza.m5_sesion4_evaluation.model.Alumno;
import com.daza.m5_sesion4_evaluation.repository.AlumnoRepository;
import com.daza.m5_sesion4_evaluation.repository.AlumnoRepositoryImplement;

import java.util.List;

public class AlumnoServiceImplement implements AlumnoService{

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImplement() {
        this.alumnoRepository = new AlumnoRepositoryImplement();
    }

    @Override
    public List<Alumno> listarAlumnos() {
        // FILTROS PARA LIMPIAR LA INFORMACION
        return alumnoRepository.listarAlumnos();
    }

    @Override
    public void registrarAlumno(Alumno alumno) {
        //otras funciones
        alumnoRepository.insertarAlumno(alumno);
    }

    @Override
    public void retirarAlumno(long id) {
        //otras funciones
        alumnoRepository.eliminarAlumno(id);
    }
}
