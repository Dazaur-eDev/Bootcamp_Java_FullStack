package M4_Sesion9;

import java.util.Scanner;

public class S9_Main {

    public static void S9() {
        System.out.println("Seleccione ejercicio que desea verificar:");
        System.out.println("1 - Rebound (Generics Profesor/ Estudiante)");
        System.out.println("2 - Evaluation (Generics Bolsa Compra Zapatos/Camisa)");

        Scanner sc = new Scanner(System.in);
        int optionS9 = sc.nextInt();
        switch (optionS9) {
            case 1:
                S9_Rebound S9_Rebound = new S9_Rebound();
                S9_Rebound.genericos();
                break;
            case 2:
                S9_Evaluation S9_Evaluation = new S9_Evaluation();
                S9_Evaluation.genericosEvaluation();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}
