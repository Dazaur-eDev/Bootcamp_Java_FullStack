package M4_Sesion4;

import java.util.Scanner;

public class S4_Main {

    public static void S4() {

        System.out.println("Seleccione ejercicio que desea verificar:");
        System.out.println("1 - Rebound");
        System.out.println("2 - Evaluation");

        Scanner sc = new Scanner(System.in);
        int optionS4 = sc.nextInt();
        switch (optionS4) {
            case 1:
                S4_Rebound S4_Rebound = new S4_Rebound();
                //S4_Rebound.patrones();
                break;
            case 2:
                S4_Evaluation S4_Evaluation = new S4_Evaluation();
//                System.out.println("Seleccione la opcion que desea:");
//                System.out.println("1 - Contar pares e impares");
//                System.out.println("2 - 10 números enteros");
//
//                int optionS4E = sc.nextInt();
//                switch (optionS4E) {
//                    case 1:
//                        S3_Evaluation.contadorParesImpares();
//                        break;
//                    case 2:
//                        S3_Evaluation.contadorTotal();
//                        break;
//                }
                break;
        }
    }
}