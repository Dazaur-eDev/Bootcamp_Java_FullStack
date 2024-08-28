package M4_Sesion5;

import java.util.Scanner;

public class S5_Main {

    public static void S5() {

        System.out.println("Seleccione ejercicio que desea verificar:");
        System.out.println("1 - Rebound (Promedio General)");
        System.out.println("2 - Evaluation (App Productos Ingresar, modificar)");

        Scanner sc = new Scanner(System.in);
        int optionS5 = sc.nextInt();
        switch (optionS5) {
            case 1:
                S5_Rebound S5_Rebound = new S5_Rebound();
                S5_Rebound.promedioGeneral();
                break;
            case 2:
                S5_Evaluation S5_Evaluation = new S5_Evaluation();
                S5_Evaluation.appProductos();
                break;
        }
    }
}