import M4_Sesion1.S1_Main;
import M4_Sesion2.S2_Main;
import M4_Sesion3.S3_Main;
import M4_Sesion4.S4_Main;
import M4_Sesion5.S5_Main;
import M4_Sesion6.S6_Main;
import M4_Sesion7.S7_Main;
import M4_Sesion8.S8_Main;
import M4_Sesion9.S9_Main;
import M4_Sesion10.S10_Main;
import M4_Sesion11.S11_Main;
import M4_Sesion12.S12_Main;
import M4_Sesion17.S17_Main;

import java.util.Scanner;

public class Main {
    static int option;
    public static void main(String[] args) {

        int flag = 0; //Bandera de salida del while principal
        System.out.println("Bienvenido a los ejercicios del Bootcamp de Java");
        while (flag != 1) {
            System.out.println("Escriba el numero de la sesión que desea evaluar:");
            System.out.println("0 .- Salir");
            System.out.println("1 a 19 - N° Sesion");
            dataInput();
            switch (option) {
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
                    S6_Main.S6();
                    break;
                case 7:
                    S7_Main.S7();
                    break;
                case 8:
                    S8_Main.S8();
                    break;
                case 9:
                    S9_Main.S9();
                    break;
                case 10:
                    S10_Main.S10();
                    break;
                case 11:
                    S11_Main.S11();
                    break;
                case 12:
                    S12_Main.S12();
                    break;
                case 15:
                    System.out.println("Realizado en proyecto con arquitectura Maven, se encuentra en carpeta: 'Modulo 4/M4_Sesion15_Rebound'.");
                    break;
                case 17:
                    S17_Main.S17();
                    break;
                case 18:
                    System.out.println("Realizado en proyecto con arquitectura Maven, se encuentra en carpeta: 'Modulo 4/M4_Sesion18_Rebound'.");
                    break;
                default:
                    System.out.println("Sesión no disponible");
            }
        }
    }

    public static int dataInput() {
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(System.in);
            option = Integer.parseInt(String.valueOf(sc.nextLine()));
        } catch (Exception e) {
            System.out.println("Por favor ingrese valores entre 1 y 19.");
        } finally {
//            sc.close();
        }
        return option;
    }
}

//tipoDeDato nombreDeObjeto = new plantilla();