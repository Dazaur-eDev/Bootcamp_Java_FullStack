package com.Daza.vistas;

import com.Daza.Servicios.AlumnoServicio;
import com.Daza.Servicios.ArchivoServicio;
import com.Daza.modelos.Alumno;
import com.Daza.modelos.Materia;
import com.Daza.modelos.MateriaEnum;
import com.Daza.utils.ReadConsole;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static com.Daza.Servicios.AlumnoServicio.listaAlumnos;

public class Menu extends MenuTemplate {
    AlumnoServicio alumnoServicio = new AlumnoServicio();
    ArchivoServicio archivoServicio = new ArchivoServicio();

    @Override
    public void exportarDatos() {
        System.out.println(" --- EXPORTAR DATOS ---");
        if (!listaAlumnos.isEmpty()) {
            System.out.println("Se generará el archivo llamado promedios.txt en la siguiente carpeta del proyecto: ");
            Path directorio = null;
            String ruta = null;
            try {
                directorio = Paths.get("").toAbsolutePath();
                ruta = String.valueOf(directorio) + "/promedios.txt";
                System.out.println(directorio);
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
            archivoServicio.exportarDatos(listaAlumnos, ruta);
        } else {
            System.out.println("No existen alumnos inscritos, operación cancelada");
        }
    }

    @Override
    public void crearAlumno() {
        System.out.println(" --- CREAR ALUMNO ---");
        //While para forzar el ingreso de un valor distinto de vaío
        String rut = ReadConsole.dataInputString("RUT");
        while (rut.isEmpty()) {
            rut = ReadConsole.dataInputString("RUT");
        }
        String nombre = ReadConsole.dataInputStringOnlyLetters("nombre");
        while (nombre.isEmpty()) {
            nombre = ReadConsole.dataInputStringOnlyLetters("nombre");
        }
        String apellido = ReadConsole.dataInputStringOnlyLetters("apellido");
        while (apellido.isEmpty()) {
            apellido = ReadConsole.dataInputStringOnlyLetters("apellido");
        }
        String direccion = ReadConsole.dataInputString("dirección");
        while (direccion.isEmpty()) {
            direccion = ReadConsole.dataInputString("dirección");
        }
        Alumno nuevoAlumno = new Alumno(rut, nombre, apellido, direccion);
        alumnoServicio.crearAlumno(nuevoAlumno);
    }

    @Override
    public void agregarMateria() {
        boolean rutValidador = false;
        if (alumnoServicio.listarAlumnos() != null) {
            System.out.println(" --- AGREGAR MATERIA---");
            System.out.println("Listado de Rut de alumnos inscritos actualmente:");
            for (Alumno alumnos : alumnoServicio.listarAlumnos().values()) {
                System.out.println("    RUT: " + alumnos.getRut() + " Nombre: " + alumnos.getNombre() + " Apellido: " + alumnos.getApellido());
            }
            String rut = ReadConsole.dataInputString("rut del alumno");
            for (Alumno alumnos : alumnoServicio.listarAlumnos().values()) {
                if (alumnos.getRut().equals(rut)) {
                    rutValidador = true;
                    break;
                }
            }
            if (rutValidador) {
                System.out.println("Seleccione la materia que desea agregar:");
                System.out.println("1 - " + MateriaEnum.MATEMATICAS.name());
                System.out.println("2 - " + MateriaEnum.LENGUAJE.name());
                System.out.println("3 - " + MateriaEnum.CIENCIA.name());
                System.out.println("4 - " + MateriaEnum.HISTORIA.name());
                int materiaParaAgregar = ReadConsole.dataInputInt("número de la lista de asignaturas");
                Materia nuevaMateria;
                switch (materiaParaAgregar) {
                    case 1:
                        nuevaMateria = new Materia(MateriaEnum.MATEMATICAS, new ArrayList<>());
                        alumnoServicio.agregarMateria(rut, nuevaMateria);
                        break;
                    case 2:
                        nuevaMateria = new Materia(MateriaEnum.LENGUAJE, new ArrayList<>());
                        alumnoServicio.agregarMateria(rut, nuevaMateria);
                        break;
                    case 3:
                        nuevaMateria = new Materia(MateriaEnum.CIENCIA, new ArrayList<>());
                        alumnoServicio.agregarMateria(rut, nuevaMateria);
                        break;
                    case 4:
                        nuevaMateria = new Materia(MateriaEnum.HISTORIA, new ArrayList<>());
                        alumnoServicio.agregarMateria(rut, nuevaMateria);
                        break;
                    default:
                        System.out.println("Materia seleccionada no válida");
                }
            } else {
                System.out.println("Rut : " + rut + " no existe ");
            }
        } else {
            System.out.println("Operación cancelada");
        }
    }

    @Override
    public void agregarNotaPasoUno() {
        boolean rutValidador = false;
        if (alumnoServicio.listarAlumnos() != null) {
            System.out.println(" --- AGREGAR NOTA---");
            System.out.println("Listado de Rut de Alumnos inscritos actualmente:");
            for (Alumno alumnos : alumnoServicio.listarAlumnos().values()) {
                System.out.println("    RUT: " + alumnos.getRut() + " Nombre: " + alumnos.getNombre() + " Apellido: " + alumnos.getApellido());
            }
            String rut = ReadConsole.dataInputString("rut del alumno");
            for (Alumno alumnos : alumnoServicio.listarAlumnos().values()) {
                if (alumnos.getRut().equals(rut)) {
                    rutValidador = true;
                    break;
                }
            }
            if (rutValidador) {
                System.out.println("Seleccione la materia a la que desea agregar una nota:");
                System.out.println("1 - " + MateriaEnum.MATEMATICAS.name());
                System.out.println("2 - " + MateriaEnum.LENGUAJE.name());
                System.out.println("3 - " + MateriaEnum.CIENCIA.name());
                System.out.println("4 - " + MateriaEnum.HISTORIA.name());
                int materiaParaAgregar = ReadConsole.dataInputInt("número de la lista de asignaturas");
                double notaParaIngresar = 0.0;
                while (notaParaIngresar <= 0 || notaParaIngresar > 7) {
                    notaParaIngresar = ReadConsole.dataDoubleInt("la nota [Valores decimales entre 1,0 y 7,0]");
                }
                Materia materia;
                switch (materiaParaAgregar) {
                    case 1:
                        materia = new Materia(MateriaEnum.MATEMATICAS);
                        alumnoServicio.agregarNota(rut, materia, notaParaIngresar);
                        break;
                    case 2:
                        materia = new Materia(MateriaEnum.LENGUAJE);
                        alumnoServicio.agregarNota(rut, materia, notaParaIngresar);
                        break;
                    case 3:
                        materia = new Materia(MateriaEnum.CIENCIA);
                        alumnoServicio.agregarNota(rut, materia, notaParaIngresar);
                        break;
                    case 4:
                        materia = new Materia(MateriaEnum.HISTORIA);
                        alumnoServicio.agregarNota(rut, materia, notaParaIngresar);
                        break;
                    default:
                        System.out.println("Materia seleccionada no válida");
                }
            } else {
                System.out.println("Rut : " + rut + " no existe ");
            }
        } else {
            System.out.println("Operación cancelada");
        }
    }


    @Override
    public void listarAlumnos() {
        if (alumnoServicio.listarAlumnos() == null) {
            System.out.println("Operación cancelada");
        } else {
            System.out.println(" --- LISTADO DE ALUMNOS ---");
            int index = 1;
            for (Alumno alumnos : alumnoServicio.listarAlumnos().values()) {
                System.out.println("\n============");
                System.out.println("Datos de Alumno n° " + index);
                System.out.println("    RUT:" + alumnos.getRut());
                System.out.println("    Nombre:" + alumnos.getNombre());
                System.out.println("    Apellido:" + alumnos.getApellido());
                System.out.println("    Direccion:" + alumnos.getDireccion());

                System.out.println("Materias");
                if (alumnos.getMateriasAlumno().isEmpty()) {
                    System.out.println("    Alumno sin asignaturas inscritas");
                } else {
                    for (Materia materias : alumnos.getMateriasAlumno()) {
                        System.out.println("    " + materias.getNombre() + " : Notas " + materias.getNotas());
                    }
                }
                index++;
            }
        }
    }

    @Override
    public void terminarPrograma() {
        System.out.println(" --- FINALIZANDO ---");
        ReadConsole.closeScanner();
    }
}
