package M4_Sesion2;

import java.util.Scanner;

public class S2_Main {

    public static void S2() {

        System.out.println("Seleccione ejercicio que desea verificar:");
        System.out.println("1 - Rebound (Minimarket)");
        System.out.println("2 - Evaluation (Temperatura - Cajero)");

        Scanner sc = new Scanner(System.in);
        int optionS2R = sc.nextInt();

        switch (optionS2R) {
            case 1:
                S2_Rebound S2_Rebound = new S2_Rebound();
                S2_Rebound.calculoTipoDePago();
                break;
            case 2:
                S2_Evaluation S2_Evaluation = new S2_Evaluation();

                System.out.println("Seleccione la opcion que desea:");
                System.out.println("1 - Temperatura");
                System.out.println("2 - Cajero");
                int optionS2E = sc.nextInt();
                switch (optionS2E) {
                    case 1:
                        S2_Evaluation.obtenerClima();
                        break;
                    case 2:
                        S2_Evaluation.cajero();
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}
