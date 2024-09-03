package M4_Sesion8;

import java.util.Scanner;

public class S8_Main {

    public static void S8() {
        System.out.println("Seleccione ejercicio que desea verificar:");
        System.out.println("1 - Rebound ()");
        System.out.println("2 - Evaluation ()");

        Scanner sc = new Scanner(System.in);
        int optionS8 = sc.nextInt();
        switch (optionS8) {
            case 1:
                S8_Rebound S8_Rebound = new S8_Rebound();
                S8_Rebound.listaCurso();
                break;
            case 2:
                S8_Evaluation S8_Evaluation = new S8_Evaluation();
                //S8_Evaluation.app();
                break;
        }
    }
}
