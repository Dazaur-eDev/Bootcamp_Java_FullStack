import M4_Sesion1.S1_Main;
import M4_Sesion2.S2_Main;
import M4_Sesion3.S3_Main;
import M4_Sesion4.S4_Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int flag = 0; //Bandera de salida del while principal
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a los ejercicios del Bootcamp de Java, si desea salir presione 0");
        while (flag != 1) {
            System.out.println("Escriba el numero de la sesion que desea evaluar:");
            System.out.print("Sesion : ");
            int sesion = sc.nextInt();
            if (sesion <= 4) {
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
                }
            } else {
                System.out.println("Sesión no disponible");
            }
        }
    }
}

//tipoDeDato nombreDeObjeto = new plantilla();