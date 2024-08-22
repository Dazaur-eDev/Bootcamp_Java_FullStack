package M4_Sesion1;
import java.util.Scanner;


public class S1_Evaluation {
    public void listaCompra() {
        Scanner sc = new Scanner(System.in);
        int precioCocina = 299990;
        int precioLavadora = 234540;
        int precioComedor = 159990;
        int precioTelevisor = 345100;
        System.out.println("Se crea la lista de compras de acuerdo a ejercicio ");
        System.out.printf("Cocina: $ %d %n", precioCocina);
        System.out.printf("Lavadora: $ %d %n", precioLavadora);
        System.out.printf("Comedor: $ %d %n", precioComedor);
        System.out.printf("Televisor: $ %d %n", precioTelevisor);

        int totalCompraPesos = precioCocina + precioLavadora + precioComedor + precioTelevisor;
        float IVA = 0.19F;
        float ivaCompra = totalCompraPesos * IVA;
        float totalCompraPesosMasIva = totalCompraPesos + ivaCompra;
        float dolar = 919.71F;
        float totalCompraDolares = totalCompraPesosMasIva / dolar;

        System.out.println("El total de su compra es de: $ " + totalCompraPesos);
        System.out.printf("El IVA es de: $ %.2f", ivaCompra);
        System.out.printf(" considerando un IVA de %.2f %n", IVA);
        System.out.printf("El total más IVA es: $ %.2f %n", totalCompraPesosMasIva);
        System.out.printf("El total de su compra en dólares es de: %.2f %n", totalCompraDolares);
    }

    public void calcularIMC(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el peso para calcular el IMC en kg:");
        float peso = sc.nextFloat();

        System.out.println("Ingrese la altura para calcular el IMC en metros:");
        float altura = sc.nextFloat();

        System.out.println("Calculando su IMC...");
        double IMC = peso / (Math.pow(altura, 2));
        System.out.printf("Su índice de masa muscular IMC es: %.2f %n", IMC);
        System.out.println("Independiente de su resultado, haga ejercicio todos los días!... jejeje");
    }

}
