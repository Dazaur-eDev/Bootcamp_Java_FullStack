package M4_Sesion2;

import java.util.Scanner;

public class S2_Evaluation {
//________________________________________________________________________________________Ejercicio 1
    public void obtenerClima() {

        //Ingreso de variables
        System.out.println("Bienvenido al portal del tiempo y clima");
        System.out.println("Por favor ingrese la temperatura de hoy en grado celcius");
        Scanner sc = new Scanner(System.in);
        float temperaturaDia = sc.nextFloat();

        //Restricciones
        String tipoClima = "";
        if (temperaturaDia <= 10) {
            tipoClima = "Frio";
        }
        if (temperaturaDia > 10 && temperaturaDia <= 20) {
            tipoClima = "Nublado";
        }
        if (temperaturaDia > 20 && temperaturaDia < 30) {
            tipoClima = "Caluroso";
        }
        if (temperaturaDia >= 30) {
            tipoClima = "Tropical";
        }

        //Procesamiento de datos
        float temperaturaDiaCelsius = temperaturaDia;
        float temperaturaDiaFarenheit = (temperaturaDiaCelsius * 9 / 5) + 32;

        //Resultado
        System.out.println(temperaturaDia + " grados celcius.");
        System.out.println("Hay " + temperaturaDia + " grados celcius. El tipo de clima hoy es " + tipoClima + ".");
        System.out.printf("Hay %.2f", temperaturaDiaCelsius);
        System.out.printf(" grados celcius o %.2f", temperaturaDiaFarenheit);
        System.out.printf(" grados farenheit. %n");
    }

//________________________________________________________________________________________Ejercicio 2
    public void cajero() {
        System.out.println("Bienvenido al Cajero Express");
        // Variables a utilizar
        int opcionCajero = 0;
        int bandera = 0;
        int saldo = 1000;
        int montoRetiro = 0;
        int montoDeposito = 0;

        while (bandera == 0) {
            //Mensaje bienvenida y adquisición de opciones
            System.out.println("Seleccione la opción que requiere:");
            System.out.println("0. Consultar saldo");
            System.out.println("1. Depositar dinero a mi cuenta");
            System.out.println("2. Retirar dinero de mi cuenta");
            System.out.println("3. Salir");

            Scanner sc = new Scanner(System.in);
            opcionCajero = sc.nextInt();

            if (opcionCajero < 0 || opcionCajero > 3) {
                System.out.println("Selección no válida, porfavor ingrese nuevamente");
            }
            switch (opcionCajero) {
                case 0:
                    System.out.println("Su saldo es de $" + saldo);
                    break;
                case 1:
                    System.out.println("Su saldo es de $" + saldo);
                    System.out.println("Indique la cantidad de dinero a depositar en su cuenta");
                    montoDeposito = sc.nextInt();
                    saldo += montoDeposito;
                    System.out.println("Su nuevo saldo actual es de $" + saldo);
                    break;
                case 2:
                    System.out.println("Su saldo es de $" + saldo);
                    System.out.println("Indique el monto a retirar de su cuenta");
                    montoRetiro = sc.nextInt();
                    if (montoRetiro>saldo) {
                        System.out.println("El saldo actual no es suficiente, intente con un monto inferior a " + saldo);
                        break;
                    }
                    saldo -= montoRetiro;
                    System.out.println("Su nuevo saldo actual es de $" + saldo);
                    break;
                case 3:
                    System.out.println("Gracias por operar con Cajero Express");
                    bandera = 1;
                    break;
            }
        }
    }
}

