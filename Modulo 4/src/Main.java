import M4_Sesion1.S1_Main;
import M4_Sesion2.S2_Main;
import M4_Sesion3.S3_Main;
import M4_Sesion4.S4_Main;
import M4_Sesion5.S5_Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int flag = 0; //Bandera de salida del while principal
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a los ejercicios del Bootcamp de Java");
        while (flag != 1) {
            System.out.println("Escriba el numero de la sesión que desea evaluar:");
            for (int i = 0; i <= 6; i++) {
                if (i == 0) {
                    System.out.println(i + " .- Salir");
                }
                System.out.println((i + 1) + " .- Sesion " + (i + 1));
            }
            int sesion = sc.nextInt();
            if (sesion <= 5) {
                switch (sesion) {
                    case 0:
                        flag = 1;
                        break;
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
                    case 5:
                        S5_Main.S5();
                        break;
                    case 6:
                        //S6_Main.S6();
                        break;
                }
            } else {
                System.out.println("Sesión no disponible");
            }
        }
    }
}

//tipoDeDato nombreDeObjeto = new plantilla();