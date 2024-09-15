package M4_Sesion9;

import M4_Sesion9.Modulos_E.Bolsa;

import java.util.Scanner;

public class S9_Evaluation {

    public void genericosEvaluation() {

        boolean tokenSalida = false;
        int cantidadMaximaBolsa;

        Scanner sc = new Scanner(System.in);
        while (!tokenSalida) {
            menu();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("¿Cuántas unidades quieres llevar de Zapatos?");
                    cantidadMaximaBolsa = sc.nextInt();
                    Bolsa<String> bolsaZapatos = new Bolsa<String>(cantidadMaximaBolsa);
                    sc.nextLine();
                    for (int i = 1; i < cantidadMaximaBolsa + 1; i++) {
                        System.out.println("Escriba la marca que desea agregar:");
                        String marca = sc.nextLine();
                        bolsaZapatos.agregarItem(marca);
                    }
                    bolsaZapatos.mostrarItems();
                    break;
                case 2:
                    System.out.println("¿Cuántas unidades quieres llevar de Poleras?");
                    cantidadMaximaBolsa = sc.nextInt();
                    Bolsa<String> bolsaPoleras = new Bolsa<String>(cantidadMaximaBolsa);
                    sc.nextLine();
                    for (int i = 1; i < cantidadMaximaBolsa + 1; i++) {
                        System.out.println("Escriba el color que desea agregar:");
                        String color = sc.nextLine();
                        bolsaPoleras.agregarItem(color);
                    }
                    bolsaPoleras.mostrarItems();
                    break;
                case 3:
                    System.out.println("Hasta pronto");
                    tokenSalida = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public void menu() {
        System.out.println("Bienvenido");
        System.out.println("Que tipo de bolsa deseas:");
        System.out.println("1.- Zapatos");
        System.out.println("2.- Poleras");
        System.out.println("3.- Salir");
    }
}
