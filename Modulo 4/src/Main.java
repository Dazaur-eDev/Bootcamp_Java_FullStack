import M4_Sesion1.S1_Main;
import M4_Sesion2.S2_Main;
import M4_Sesion3.S3_Main;
import M4_Sesion4.S4_Main;

import java.util.Scanner;

import static M4_Sesion3.S3_Main.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S1_Main S1_Main = new S1_Main();
        System.out.println("Escriba el numero de la sesion que desea verificar:");
        System.out.print("Sesion : ");
        int sesion = sc.nextInt();
        switch (sesion) {
            case 1:
                S1_Main.S1();
                break;
            case 2:
                S2_Main.S2();
                break;
            case 3:
                S3_Main.S3();
                break;
            case 4:
                S4_Main.S4();
                break;
        }
    }
}

//tipoDeDato nombreDeObjeto = new plantilla();