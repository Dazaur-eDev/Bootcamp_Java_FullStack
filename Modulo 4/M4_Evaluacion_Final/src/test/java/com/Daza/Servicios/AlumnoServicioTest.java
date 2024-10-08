package com.Daza.Servicios;

import com.Daza.modelos.Alumno;
import com.Daza.modelos.Materia;
import com.Daza.modelos.MateriaEnum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.mockito.Mockito.*;

@DisplayName("Pruebas para métodos de clase AlumnoServicio")
class AlumnoServicioTest {
    AlumnoServicio alumnoServicio;
    AlumnoServicio alumnoServicioMock;
    Materia materia;
    List<Materia> listaMateriasAlumno;
    Alumno alumno;
    Map<String, Alumno> listaAlumnos;

    @BeforeEach
    void setUp() {
        alumnoServicio = new AlumnoServicio();
        alumnoServicioMock = mock(AlumnoServicio.class);
        listaMateriasAlumno = new ArrayList<>();
        listaAlumnos = new LinkedHashMap<>();
        alumno = new Alumno("17656624-k", "Patricio", "Daza", "Cobija,Calama", listaMateriasAlumno);
        alumnoServicio.crearAlumno(alumno);
    }

    @DisplayName("Prueba Crear Alumno")
    @Test
    void crearAlumno() {
        alumno = new Alumno("17656624-5", "Patricio", "Daza", "Cobija,Calama", listaMateriasAlumno);
        alumnoServicio.crearAlumno(alumno);
        listaAlumnos.put(alumno.getRut(), alumno);

        Assertions.assertTrue(listaAlumnos.containsKey(alumno.getRut()));
        Assertions.assertEquals("17656624-5", alumno.getRut());
        Assertions.assertEquals("Patricio", listaAlumnos.get("17656624-5").getNombre());
        Assertions.assertEquals("Daza", alumno.getApellido());
        Assertions.assertEquals("Cobija,Calama", alumno.getDireccion());
    }

    @DisplayName("Prueba Agregar Materia")
    @Test
    void agregarMateria() {
        alumno = new Alumno("17656624-1", "Daniel", "Daza", "Cobija,Calama", listaMateriasAlumno);
        alumnoServicio.crearAlumno(alumno);
        listaAlumnos.put(alumno.getRut(), alumno);

        materia = new Materia(MateriaEnum.LENGUAJE, Arrays.asList(6.0, 4.0, 5.0));
        alumnoServicio.agregarMateria(alumno.getRut(), materia);
        Assertions.assertTrue(alumnoServicio.materiasPorAlumno(alumno.getRut()).contains(materia));
        Assertions.assertEquals(materia, alumno.getMateriasAlumno().get(0));
    }

    @DisplayName("Prueba Agregar Nota")
    @Test
    void agregarNota() {
        listaAlumnos.put(alumno.getRut(), alumno);
        List<Double> notas = new ArrayList<>();
        materia = new Materia(MateriaEnum.CIENCIA, notas);
        alumnoServicio.agregarNota(alumno.getRut(), materia, 2.0);

        Assertions.assertTrue(materia.getNotas().contains(2.0));
        Assertions.assertEquals(2.0,materia.getNotas().get(0));
    }

    @DisplayName("Prueba Materias por Alumno")
    @Test
    void materiasPorAlumno() {
        listaAlumnos.put(alumno.getRut(), alumno);

        materia = new Materia(MateriaEnum.HISTORIA, Arrays.asList(6.0, 4.0, 5.0));
        alumnoServicio.agregarMateria(alumno.getRut(), materia);
        when(alumnoServicioMock.materiasPorAlumno(alumno.getRut())).thenReturn(alumno.getMateriasAlumno());

        List<Materia> materiasDelAlumno = alumnoServicioMock.materiasPorAlumno(alumno.getRut());
        verify(alumnoServicioMock).materiasPorAlumno(alumno.getRut());

        Assertions.assertEquals(1, materiasDelAlumno.size());
        Assertions.assertEquals(MateriaEnum.HISTORIA, materiasDelAlumno.get(0).getNombre());
    }

    @DisplayName("Prueba Listar Alumnos")
    @Test
    void listarAlumnos() {
        listaAlumnos.put(alumno.getRut(), alumno);
        Assertions.assertFalse(listaAlumnos.isEmpty());
    }
}