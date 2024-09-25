package M4_Sesion13.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadConsole {

    private static final Scanner sc = new Scanner(System.in);  // Reuse the same Scanner instance

    public static int dataInputInt() {
        int data = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Insert a number: ");
                data = sc.nextInt();
                validInput = true;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("No valid entry. Please use only numbers.");
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
                System.out.print("Insert a date (dd/MM/yyyy): ");
                String input = sc.nextLine();
                date = LocalDate.parse(input, formatter);
                validInput = true;
            } catch (DateTimeParseException e) {
                System.out.println("No valid entry. Please use the format dd/MM/yyyy.");
            }
        }
        return date;
    }

    public static String dataInputString() {
        String data = "";
        try {
            System.out.print("Insert a text: ");
            data = sc.nextLine(); // Leer la entrada de texto
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return data;
    }

    public static void closeScanner() {
        sc.close();  // Cerrar el escaner para liberar recursos
        System.out.println("Object Scanner terminated.");
    }



}
