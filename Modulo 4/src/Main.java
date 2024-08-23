package M4_Sesion1;

import M4_Sesion1.S1_Evaluation;
import M4_Sesion1.S1_Rebound;
import M4_Sesion1.S1_Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S1_Main S1_Main = new S1_Main();
        System.out.println("Escriba el numero de la sesion que desea verificar:");
        System.out.println("Sesion : ");
        int sesion = sc.nextInt();
        switch (sesion) {
            case 1:
                S1_Main.main();
                break;
            case 2:
                //S2_Main.main();
                System.out.println("Sesión no disponible");
                break;
            case 3:
                //S3_Main.main();
                System.out.println("Sesión no disponible");
                break;
            case 4:
                //S4_Main.main();
                System.out.println("Sesión no disponible");
                break;
        }
    }
}

//tipoDeDato nombreDeObjeto = new plantilla();