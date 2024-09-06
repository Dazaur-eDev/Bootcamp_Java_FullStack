package M4_Sesion4;

import java.util.Scanner;

public class S4_Main {

    public static void S4() {

        System.out.println("Seleccione ejercicio que desea verificar:");
        System.out.println("1 - Rebound (Clase Persona y calculo IMC )");
        System.out.println("2 - Evaluation (Clase Auto y métodos)");

        Scanner sc = new Scanner(System.in);
        int optionS4 = sc.nextInt();
        switch (optionS4) {
            case 1:
                S4_Rebound S4_Rebound = new S4_Rebound();
                S4_Rebound.calculo();
                break;
            case 2:
                S4_Evaluation S4_Evaluation = new S4_Evaluation();
                S4_Evaluation.mainAuto();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}