package M4_Sesion8;

import java.util.ArrayList;

public class S8_Rebound {
    public void listadoCurso() {

        ArrayList<Profesor> profesores = new ArrayList<>();
        profesores.add(new Profesor("ANDRES", 0,"INFORMATICA"));
        profesores.add(new Profesor("LUIS", 1,"INFORMATICA"));

        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("PATRICIO", 0, profesores.get(0), "ESTUDIAR"));
        estudiantes.add(new Estudiante("DANIEL", 1, null, "JUGAR A LA PELOTA"));


        //asignar un profesor a un estudiante después de la creación (solo para practicar el uso de getter y setters profe)
        estudiantes.get(1).setProfesor(profesores.get(1));

        //recorrer los arreglos de profesores y estudiantes
        System.out.println("El curso esta compuesto por:");
        for (Profesor listadoProfesores : profesores) {
            System.out.println(listadoProfesores.toString());
        }
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.toString());
        }
        //ejecutar métodos de acuerdo a distintas instancias de clase
        profesores.get(0).leer();
        profesores.get(1).realizarEjercicio();
        estudiantes.get(1).realizarEjercicio();
        estudiantes.get(0).leer();

    }
}
