package M4_Sesion9;

import java.util.ArrayList;

public class S9_Rebound {

    public void genericos() {

        ArrayList<Profesor<String>> profesores = new ArrayList<>();
        profesores.add(new Profesor("Andres", "30/02/2000", "Java"));
        profesores.add(new Profesor("Luis", 30022020, "Java"));
        int contadorProfesores = 0;
        ArrayList<Alumno<Integer>> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Patricio", "30/06/1991", "dos"));
        alumnos.add(new Alumno("Daniel", 30061991, 3));
        int contadorAlumnos = 0;

        for (Profesor<String> p : profesores) {
            System.out.print("SuperClase: ");
            System.out.print(p.getClass().getSuperclass());
            System.out.print(" - Clase: ");
            System.out.print(p.getClass().getSimpleName());
            System.out.print(" - Nombre: ");
            System.out.print(p.getNombre());
            System.out.print(" - Especialidad: ");
            System.out.println(p.getEspecialidad());
//            System.out.println("");
//          System.out.println(a.toString());
            contadorProfesores ++;
        }

        for (Alumno<Integer> a : alumnos) {
            System.out.print("SuperClase: ");
            System.out.print(a.getClass().getSuperclass());
            System.out.print(" - Clase: ");
            System.out.print(a.getClass().getSimpleName());
            System.out.print("  Nombre: ");
            System.out.print(a.getNombre());
            System.out.print(" - Tareas Pendientes: ");
            System.out.println(a.getTareasPendientes());
//            System.out.println("");
//            System.out.println(a.toString());
            contadorAlumnos ++;
        }
        System.out.println("El total de profesores es de " + contadorProfesores);
        System.out.println("El total de alumnos es de " + contadorAlumnos);

    }
}
