package M4_Sesion2;

import java.util.Scanner;

public class S2_Rebound {
    private String tipoPago = "";
    public void calculoTipoDePago() {

        //Obtencion de información y generacion de variables
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al minimarket");
        System.out.println("Por favor ingrese su nombre");
        String nombreCliente = sc.nextLine();
        int valorTotalCompra = 0;

        //Obtener el valor total de la suma de los 5 productos
        for (int i = 1; i < 6; i++) {
            System.out.println("Ingrese el valor del producto " + i);
            int valorProducto = sc.nextInt();
            valorTotalCompra = valorTotalCompra + valorProducto;
        }
        metodoPago(valorTotalCompra);
        //Salida final de la compra
        System.out.println(nombreCliente + ", " + tipoPago);
        System.out.println("Gracias por venir al minimarket");
    }

    //Definir restricciones solicitadas
    public void metodoPago(int valorTotalCompra) {

        if (valorTotalCompra <= 10000) {
            tipoPago = "Pagarás con efectivo el total de: $" + valorTotalCompra;
        }
        if (valorTotalCompra > 10000 && valorTotalCompra <= 20000) {
            tipoPago = "Pagarás con tarjeta el total de: $" + valorTotalCompra;
        }
        if (valorTotalCompra > 20001) {
            tipoPago = "Pagarás con cheque el total de: $" + valorTotalCompra;
        }
    }
}
