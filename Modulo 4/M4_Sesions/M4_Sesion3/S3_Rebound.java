package M4_Sesion3;

import java.util.Scanner;

public class S3_Rebound {

    int numero;

    private void obtenerNumero() {
        System.out.println("Por favor ingrese un número");
        Scanner sc = new Scanner(System.in);
        numero = sc.nextInt();
    }

    private void primerPatron() {
        String patronPar = ".";
        String patronImpar = "*";
        for (int i = 1; i <= numero; i++) {
            if (i % 2 == 0) {
                System.out.print(patronPar);
            }
            if (i % 2 != 0) {
                System.out.print(patronImpar);
            }
        }
    }

    private void segundoPatron() {
        String segundoPatron = "*";
        for (int fila = 1; fila <= numero; fila++) {
            for (int columna = 1; columna <= numero; columna++) {
                if (fila == 1) {
                    System.out.print(segundoPatron);
                }
                if (fila == numero) {
                    System.out.print(segundoPatron);
                }
                if (fila != 1 && fila != numero) {
                    if (columna != 1 && columna != numero) {
                        System.out.print(" ");
                    } else {
                        System.out.print(segundoPatron);
                    }
                }
            }
            System.out.println(" ");
        }
    }

    public void patrones() {
        obtenerNumero();
        System.out.println("Patrón 1:");
        primerPatron();
        System.out.println(" ");
        System.out.println("Patrón 2:");
        segundoPatron();
    }
}
