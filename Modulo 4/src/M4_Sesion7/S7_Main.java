package M4_Sesion7;

import java.util.Scanner;

public class S7_Main {

    public static void S7() {
        System.out.println("Seleccione ejercicio que desea verificar:");
        System.out.println("1 - Rebound (Vehiculos (Autos-Bicicletas)");
        System.out.println("2 - Evaluation (Compra de cocina o refrigerador)");

        Scanner sc = new Scanner(System.in);
        int optionS7 = sc.nextInt();
        switch (optionS7) {
            case 1:
                S7_Rebound S7_Rebound = new S7_Rebound();
                S7_Rebound.vehiculo();
                break;
            case 2:
                S7_Evaluation S7_Evaluation = new S7_Evaluation();
                S7_Evaluation.comercio();
                break;
        }
    }
}
