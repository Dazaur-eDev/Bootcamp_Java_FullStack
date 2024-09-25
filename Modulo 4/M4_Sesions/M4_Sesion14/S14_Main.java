package M4_Sesion14;

import M4_Sesion14.modules.ClubFullException;
import M4_Sesion14.modules.DuplicateMemberException;

import java.util.Scanner;

public class S14_Main {
    public static void S14() throws ClubFullException, DuplicateMemberException {
        System.out.println("Seleccione ejercicio que desea verificar:");
        System.out.println("1 - Rebound (Calculadora Divisiones (Excepciones))");
        System.out.println("2 - Evaluation (Aplicación Socios del Club)");
        Scanner sc = new Scanner(System.in);
        int optionS13 = sc.nextInt();
        switch (optionS13) {
            case 1:
                S14_Rebound S14_Rebound = new S14_Rebound();
                S14_Rebound.calculator();
                break;
            case 2:
                S14_Evaluation S14_Evaluation = new S14_Evaluation();
                S14_Evaluation.appMembersClub();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}
