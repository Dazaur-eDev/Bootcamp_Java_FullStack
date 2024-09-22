package com.Daza.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class leerConsola {

    private static final Scanner sc = new Scanner(System.in);  // Reuse the same Scanner instance

    public static int dataInputInt() {
        int data = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Ingrese número: ");
                data = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                sc.next();  // Limpia la entrada de datos no valida.
            }
        }
        return data;
    }

    public static String dataInputString() {
        sc.nextLine();
        String data = "";
        try {
            System.out.print("Ingrese texto: ");
            data = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return data;
    }

    public static void close() {
        sc.close();  // Cerrar el escaner para liberar recursos
        System.out.println("Objeto Scanner finalizado.");
    }
}
