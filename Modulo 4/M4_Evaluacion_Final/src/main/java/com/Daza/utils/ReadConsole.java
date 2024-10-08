package com.Daza.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadConsole {

    private static final Scanner sc = new Scanner(System.in);  // Reuse the same Scanner instance

    public static int dataInputInt(String text) {
        int data = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Ingresa " + text + ": ");
                data = sc.nextInt();
                validInput = true;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor utiliza números.");
                sc.next();  // Limpia la entrada de datos no valida.
            }
        }
        return data;
    }

    public static LocalDate dataInputLocalDate() {
        LocalDate date = null;
        boolean validInput = false;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (!validInput) {
            try {
                System.out.print("Ingresa fecha (dd/MM/yyyy): ");
                String input = sc.nextLine();
                date = LocalDate.parse(input, formatter);
                validInput = true;
            } catch (DateTimeParseException e) {
                System.out.println("Entrada no válida. Por favor ingresa en formato dd/MM/yyyy.");
            }
        }
        return date;
    }

    public static String dataInputString(String text) {
        String data = "";
        try {
            System.out.print("Ingresa " + text + ": ");
            data = sc.nextLine(); // Leer la entrada de texto
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return data;
    }

    public static String dataInputStringOnlyLetters(String text) {
        String data = "";
        boolean isOnlyLetters = false;
        try {
            while (!isOnlyLetters) {
                System.out.print("Ingresa " + text + ": ");
                data = sc.nextLine();
                if (!data.matches("^[a-zA-Z ]+$")) {
                    System.out.println("Error: Solo se permiten letras. Inténtalo nuevamente.");
                } else {
                    isOnlyLetters = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return data;
    }


    public static void closeScanner() {
        System.out.println("Objeto Scanner finalizado.");
        sc.close();  // Cerrar el escaner para liberar recursos
    }


    public static double dataDoubleInt(String text) {
        double data = 0.0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Ingresa " + text + ": ");
                data = sc.nextDouble();
                validInput = true;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor utiliza números con decimales.");
                sc.next();  // Limpia la entrada de datos no valida.
            }
        }
        return data;
    }
}
