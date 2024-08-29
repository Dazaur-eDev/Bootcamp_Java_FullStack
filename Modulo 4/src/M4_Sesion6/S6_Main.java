package M4_Sesion6;

import java.util.Scanner;

public class S6_Main {

    public static void S6() {
        System.out.println("Seleccione ejercicio que desea verificar:");
        System.out.println("1 - Rebound (App usuario: daza pass:1234)");
        System.out.println("2 - Evaluation ()");

        Scanner sc = new Scanner(System.in);
        int optionS6 = sc.nextInt();
        switch (optionS6) {
            case 1:
                S6_Rebound S6_Rebound = new S6_Rebound();
                S6_Rebound.calculoMatematicos();
                break;
            case 2:
                S6_Evaluation S6_Evaluation = new S6_Evaluation();
                S6_Evaluation.app();
                break;
        }
    }
}
