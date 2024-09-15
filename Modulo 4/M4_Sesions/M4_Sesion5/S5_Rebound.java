package M4_Sesion5;

import java.util.ArrayList;
import java.util.Scanner;

public class S5_Rebound {

    ArrayList<String> asignaturas = new ArrayList<>(5);
    ArrayList<Float> notas = new ArrayList<>(5);
    float sumaTotalNotas;

    public void promedioGeneral() {
        ingresoDatos();
        calculoPromedio();
        System.out.println("Las asignaturas ingresadas son = " + asignaturas);
        System.out.println("Las notas ingresadas son = " + notas);
    }

    private void ingresoDatos() {
        Scanner asignatura = new Scanner(System.in);
        Scanner nota = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese el nombre de la asignatura");
            asignaturas.add(asignatura.nextLine());
            System.out.println("Ingrese el promedio de la asignatura " + asignaturas.get(i));
            notas.add(nota.nextFloat());
        }
        System.out.println("Sus notas son las siguientes:");
        for (int i = 0; i < asignaturas.size(); i++) {
            System.out.println(asignaturas.get(i) + " = " + notas.get(i));
        }
    }

    private void calculoPromedio() {
        for (int i = 0; i < asignaturas.size(); i++) {
            sumaTotalNotas += notas.get(i);
        }
        System.out.printf("Su promedio general es =  %.2f %n", sumaTotalNotas / asignaturas.size());
    }
}
