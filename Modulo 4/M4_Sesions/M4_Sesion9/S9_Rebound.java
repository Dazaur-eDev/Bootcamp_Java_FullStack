package M4_Sesion9;

import M4_Sesion9.Modulos_R.Curso;
import M4_Sesion9.Modulos_R.Profesor;
import M4_Sesion9.Modulos_R.Alumno;

import java.util.ArrayList;

public class S9_Rebound {

    public void genericos() {
//        ________________________________________________________________________ Una forma usando un array
        ArrayList<Curso<String>> curso = new ArrayList<>();
        int contadorProfesores = 0;
        int contadorAlumnos = 0;

        curso.add(new Profesor("Andres", "30/02/2000", "Java"));
        curso.add(new Profesor("Luis", "30/02/2020", "Java"));
        curso.add(new Alumno("Patricio", "30/06/1991", "dos"));
        curso.add(new Alumno("Daniel", "30/06/1991", 3));

        for (Curso<String> c : curso) {
            if (c.getClass() == Profesor.class) {
                contadorProfesores++;
                System.out.print("SuperClase: ");
                System.out.print(c.getClass().getSuperclass());
                System.out.print(" - Clase: ");
                System.out.print(c.getClass().getSimpleName());
                System.out.print(" - Nombre: ");
                System.out.print(c.getNombre());
                System.out.print(" - Especialidad: ");
                System.out.print(((Profesor<?>) c).getEspecialidad());
                System.out.print(" - Fecha Nacimiento: ");
                System.out.println(c.getFechaNacimiento());

            } else if (c.getClass() == Alumno.class) {
                contadorAlumnos++;
                System.out.print("SuperClase: ");
                System.out.print(c.getClass().getSuperclass());
                System.out.print(" - Clase: ");
                System.out.print(c.getClass().getSimpleName());
                System.out.print(" - Nombre: ");
                System.out.print(c.getNombre());
                System.out.print(" - Tareas Pendientes: ");
                System.out.print(((Alumno<?>) c).getTareasPendientes());
                System.out.print(" - Fecha Nacimiento: ");
                System.out.println(c.getFechaNacimiento());
            }
        }
        System.out.println("El total de profesores es de " + contadorProfesores);
        System.out.println("El total de alumnos es de " + contadorAlumnos);

//        ________________________________________________________________________ Una forma usando dos arrays
//        ArrayList<Profesor<String>> profesores = new ArrayList<>();
//        profesores.add(new Profesor("Andres", "30/02/2000", "Java"));
//        profesores.add(new Profesor("Luis", 30022020, "Java"));
//        int contadorProfesores = 0;
//        ArrayList<Alumno<Integer>> alumnos = new ArrayList<>();
//        alumnos.add(new Alumno("Patricio", "30/06/1991", "dos"));
//        alumnos.add(new Alumno("Daniel", "30/06/1991", 3));
//        int contadorAlumnos = 0;
//
//        for (Profesor<String> p : profesores) {
//            System.out.print("SuperClase: ");
//            System.out.print(p.getClass().getSuperclass());
//            System.out.print(" - Clase: ");
//            System.out.print(p.getClass().getSimpleName());
//            System.out.print(" - Nombre: ");
//            System.out.print(p.getNombre());
//            System.out.print(" - Especialidad: ");
//            System.out.println(p.getEspecialidad());
////            System.out.println("");
////          System.out.println(a.toString());
//            contadorProfesores++;
//        }
//
//        for (Alumno<Integer> a : alumnos) {
//            System.out.print("SuperClase: ");
//            System.out.print(a.getClass().getSuperclass());
//            System.out.print(" - Clase: ");
//            System.out.print(a.getClass().getSimpleName());
//            System.out.print("  Nombre: ");
//            System.out.print(a.getNombre());
//            System.out.print(" - Tareas Pendientes: ");
//            System.out.println(a.getTareasPendientes());
////            System.out.println("");
////            System.out.println(a.toString());
//            contadorAlumnos++;
//        }
//        System.out.println("El total de profesores es de " + contadorProfesores);
//        System.out.println("El total de alumnos es de " + contadorAlumnos);
    }
}
