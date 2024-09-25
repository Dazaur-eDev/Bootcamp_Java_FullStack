package M4_Sesion13;

import java.util.Scanner;

public class S13_Main {

    public static void S13() {
        System.out.println("Seleccione ejercicio que desea verificar:");
        System.out.println("1 - Rebound (Colecciones Arraylist Numerico)");
        System.out.println("2 - Evaluation (App Matriculas Centro Estudios Integrales)");
        Scanner sc = new Scanner(System.in);
        int optionS13 = sc.nextInt();
        switch (optionS13) {
            case 1:
                S13_Rebound S13_Rebound = new S13_Rebound();
                S13_Rebound.arrayListNumerico();
                break;
            case 2:
                S13_Evaluation S13_Evaluation = new S13_Evaluation();
                S13_Evaluation.appCentroEstudios();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}
