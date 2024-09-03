package M4_Sesion8;

import java.util.ArrayList;

public class S8_Rebound {
    public void listaCurso() {

        Profesor profesor = new Profesor("Andres", 0, "Informática");
        Estudiante estudiante1 = new Estudiante("Patricio", 0, profesor, "estudiar");
        Estudiante estudiante2 = new Estudiante("Daniel", 1, profesor, "jugar a la pelota");
        Estudiante estudiante3 = new Estudiante("Daza", 2, profesor, "programar en java");
        Estudiante estudiante4 = new Estudiante("Urqueta", 3, profesor, "ver peliculas y series");
        Estudiante estudiante5 = new Estudiante("Patricio", 4, profesor, "escuchar LP");

        ArrayList<Object> listaCurso = new ArrayList<>();
        listaCurso.add(profesor);
        listaCurso.add(estudiante1);
        listaCurso.add(estudiante2);
        listaCurso.add(estudiante3);
        listaCurso.add(estudiante4);
        listaCurso.add(estudiante5);

        System.out.println("El curso esta compuesto por:");
        for (Object participanteCurso : listaCurso) {
            System.out.println(participanteCurso.toString());
        }

        profesor.leer();
        estudiante1.realizarEjercicio();
    }
}
