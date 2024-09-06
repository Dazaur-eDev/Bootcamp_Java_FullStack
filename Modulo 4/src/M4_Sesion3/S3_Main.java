package M4_Sesion3;

import java.util.Scanner;

public class S3_Main {

    public static void S3() {

        System.out.println("Seleccione ejercicio que desea verificar:");
        System.out.println("1 - Rebound (Patrones)");
        System.out.println("2 - Evaluation ( Contar Pares e impares en N° 1 a 100 - Ingresar 10 n° enteros)");

        Scanner sc = new Scanner(System.in);
        int optionS3 = sc.nextInt();
        switch (optionS3) {
            case 1:
                S3_Rebound S3_Rebound = new S3_Rebound();
                S3_Rebound.patrones();
                break;
            case 2:
                S3_Evaluation S3_Evaluation = new S3_Evaluation();
                System.out.println("Seleccione la opcion que desea:");
                System.out.println("1 - Contar pares e impares");
                System.out.println("2 - 10 números enteros");

                int optionS3E = sc.nextInt();
                switch (optionS3E) {
                    case 1:
                        S3_Evaluation.contadorParesImpares();
                        break;
                    case 2:
                        S3_Evaluation.contadorTotal();
                        break;
                }
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}
