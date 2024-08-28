package M4_Sesion3;

import java.util.Scanner;

public class S3_Evaluation {
    //____________________________________________________________________________________________ Ejercicio 1
    int flag = 0;

    public void contadorParesImpares() {
        while (flag == 0) {
            System.out.println("Ingrese un número entre 1 y 100");
            Scanner sc = new Scanner(System.in);
            int numeroIngresado = sc.nextInt();
            validadorNumero(numeroIngresado);
            if (flag != 0) {
                totalizador(numeroIngresado);
            }
        }
    }

    private void validadorNumero(int numeroIngresado) {
        if (numeroIngresado < 1 || numeroIngresado > 100) {
            System.out.println("-----------------Error");
            System.out.println("Numero incorrecto");
        } else {
            System.out.println("Numero válido");
            flag = 1;
        }
    }

    private void totalizador(int numeroIngresado) {
        float contadorTotalPares;
        float contadorTotalImpares;
        if (numeroIngresado % 2 == 0) {
            contadorTotalPares = numeroIngresado / 2;
            contadorTotalImpares = numeroIngresado / 2;
        } else {
            contadorTotalPares = numeroIngresado / 2;
            contadorTotalImpares = (numeroIngresado / 2) + 1;
        }
        System.out.printf("El total de números pares es de: %.0f %n", contadorTotalPares);
        System.out.printf("El total de números impares es de: %.0f %n", contadorTotalImpares);
    }

    //____________________________________________________________________________________________ Ejercicio 2
    int[] numerosIngresados = new int[10];
    int contadorDeCeros;
    int contadorDePositivos;
    int contadorDeNegativos;
    int contadorDePares;
    int contadorDeImpares;

    public void contadorTotal() {
        System.out.println("Ingresa 10 números positivos, negativos o el valor cero");
        ingresoNumeros();
        System.out.println("El total de números ingresados es de: " + numerosIngresados.length);
        contadorNumeros();
        System.out.println("El total de números ceros introducidos es de: " + contadorDeCeros);
        System.out.println("El total de números positivos introducidos es de: " + contadorDePositivos);
        System.out.println("El total de números negativos introducidos es de: " + contadorDeNegativos);
        System.out.println("El total de números pares introducidos es de: " + contadorDePares);
        System.out.println("El total de números impares introducidos es de: " + contadorDeImpares);
    }

    private void ingresoNumeros() {
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            Scanner sc = new Scanner(System.in);
            numerosIngresados[i] = sc.nextInt();
        }
    }

    private void contadorNumeros() {
        for (int i = 0; i < numerosIngresados.length; i++) {
            if (numerosIngresados[i] == 0) {
                contadorDeCeros += 1;
            }
            if (numerosIngresados[i] > 0) {
                contadorDePositivos += 1;
            }
            if (numerosIngresados[i] < 0) {
                contadorDeNegativos += 1;
            }
            if (numerosIngresados[i] % 2 == 0) {
                contadorDePares += 1;
            }
            if (numerosIngresados[i] % 2 != 0) {
                contadorDeImpares += 1;
            }
        }
    }
}
