package M4_Sesion12;

import M4_Sesion12.S12_Evaluation;
import M4_Sesion12.S12_Rebound;

import java.util.Scanner;

public class S12_Main {

    public static void S12() {
        System.out.println("Seleccione ejercicio que desea verificar:");
        System.out.println("1 - Rebound (Sorteo Bicicleta )");
        System.out.println("2 - Evaluation ()");

        Scanner sc = new Scanner(System.in);
        int optionS12 = sc.nextInt();
        switch (optionS12) {
            case 1:
                S12_Rebound S12_Rebound = new S12_Rebound();
                S12_Rebound.sorteo();
                break;
            case 2:
                S12_Evaluation S12_Evaluation = new S12_Evaluation();
//                S12_Evaluation.();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}
