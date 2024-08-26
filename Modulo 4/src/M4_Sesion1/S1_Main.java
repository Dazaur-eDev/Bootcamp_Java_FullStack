package M4_Sesion1;

import java.util.Scanner;

public class S1_Main {

    public static void S1() {

        System.out.println("Seleccione ejercicio que desea verificar:");
        System.out.println("1 - Rebound (Área y perímetro de un rectángulo)");
        System.out.println("2 - Evaluation (Venta e IMC)");

        Scanner sc = new Scanner(System.in);
        int optionS1R = sc.nextInt();

        switch (optionS1R) {
            case 1:
                S1_Rebound S1_Rebound = new S1_Rebound();

                System.out.println("Seleccione la opcion que desea calcular:");
                System.out.println("1 - Calcular el área");
                System.out.println("2 - Calcular el perímetro");


                int areaPerimetro = sc.nextInt();
                switch (areaPerimetro) {
                    case 1:
                        S1_Rebound.calcularArea();
                        break;
                    case 2:
                        S1_Rebound.calcularPerimetro();
                        break;
                }
                break;

            case 2:
                S1_Evaluation S1_Evaluation = new S1_Evaluation();

                System.out.println("Seleccione la opcion que desea calcular:");
                System.out.println("1 - Obtener lista de compra y valor de venta");
                System.out.println("2 - Calcular el IMC");

                int optionS1E = sc.nextInt();
                switch (optionS1E) {
                    case 1:
                        S1_Evaluation.listaCompra();
                        break;
                    case 2:
                        S1_Evaluation.calcularIMC();
                        break;
                }
                break;
        }
    }
}

