package M4_Sesion7;

import java.util.ArrayList;
import java.util.Scanner;

public class S7_Evaluation {

    boolean tokenSalida = false;
    private static ArrayList<Cocina> cocinas = new ArrayList<>();

    static {
        cocinas.add(new Cocina("LG1", 200000, 10, 4));
        cocinas.add(new Cocina("LG2", 400000, 1, 2));
    }

    private static ArrayList<Refrigerador> refrigeradores = new ArrayList<>();

    static {
        refrigeradores.add(new Refrigerador("Samsung1", 500000, 2, "A", 2));
        refrigeradores.add(new Refrigerador("Samsung2", 350000, 5, "D", 1));
    }

    public void comercio() {

        System.out.println("Ingrese su nombre:");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();

        System.out.println("Ingrese su rut:");
        Scanner sc2 = new Scanner(System.in);
        String rut = sc2.nextLine();

        System.out.println("Bienvenido " + nombre + " - " + rut);
        while (!tokenSalida) {
            System.out.println("¿Seleccione el producto que desea comprar?");
            System.out.println("1.- Cocina");
            System.out.println("2.- Refrigerador");
            System.out.println("3.- Salir");

            Scanner sc3 = new Scanner(System.in);
            int opcion = sc3.nextInt();
            switch (opcion) {
                case 1:
                    compraCocina();
                    break;
                case 2:
                    comprarRefrigerador();
                    break;
                case 3:
                    tokenSalida = true;
                    break;
            }
        }
    }

    public void compraCocina() {

        int index = 0;
        System.out.println("Seleccione el modelo que desea adquirir");
        for (Cocina c : cocinas) {
            index++;
            System.out.println(index + ".- " + c.getNombre());
        }
        System.out.println("¿Seleccione la cocina que desea comprar?");
        Scanner sc4 = new Scanner(System.in);
        int cocinaOpcion = sc4.nextInt();
        if (cocinaOpcion > index) {
            System.out.println("Opción no válida");
        }
        System.out.println("El valor es de $" + cocinas.get(cocinaOpcion - 1).getPrecio());
        System.out.println("Tiene " + cocinas.get(cocinaOpcion - 1).getCantidadQuemadores() + " quemadores");
        System.out.println("Cantidad disponible: " + cocinas.get(cocinaOpcion - 1).getCantidadDisponible() + " unidades");
        System.out.println("Presione Y para comprar o N para cancelar");
        Scanner sc5 = new Scanner(System.in);
        String opcionCompra = sc5.nextLine();
        if (opcionCompra.equals("y") || opcionCompra.equals("Y")) {
            System.out.println("¿Desea agregar un gas por $ 5000?");
            System.out.println("Presione Y para comprar o N para cancelar");
            Scanner sc6 = new Scanner(System.in);
            String opcionGas = sc6.nextLine();
            if (opcionGas.equals("y") || opcionGas.equals("Y")) {
                cocinas.get(cocinaOpcion - 1).incluyeGas();
                int nuevaCantidad = cocinas.get(cocinaOpcion - 1).getCantidadDisponible() - 1;
                cocinas.get(cocinaOpcion - 1).setCantidadDisponible(nuevaCantidad);
                System.out.println("Nueva cantidad disponible: " + cocinas.get(cocinaOpcion - 1).getCantidadDisponible());
            } else if (opcionGas.equals("n") || opcionGas.equals("N")) {
                System.out.println("Felcidades! Ha comprado su cocina sin Gas");
                int nuevaCantidad = cocinas.get(cocinaOpcion - 1).getCantidadDisponible() - 1;
                cocinas.get(cocinaOpcion - 1).setCantidadDisponible(nuevaCantidad);
                System.out.println("Nueva cantidad disponible: " + cocinas.get(cocinaOpcion - 1).getCantidadDisponible());
            } else {
                System.out.println("Opción no válida");
            }
        } else if (opcionCompra.equals("n") || opcionCompra.equals("N")) {
            System.out.println("Gracias por ver nuestros productos");
        } else {
            System.out.println("Opción no válida");
        }
    }

    public void comprarRefrigerador() {

        int index = 0;
        System.out.println("Seleccione el modelo que desea adquirir");
        for (Refrigerador r : refrigeradores) {
            index++;
            System.out.println(index + ".- " + r.getNombre());
        }
        System.out.println("¿Seleccione el refrigerador que desea comprar?");
        Scanner sc6 = new Scanner(System.in);
        int refrigeradorOpcion = sc6.nextInt();
        if (refrigeradorOpcion > index) {
            System.out.println("Opción no válida");
        }
        System.out.println("El valor es de $" + refrigeradores.get(refrigeradorOpcion - 1).getPrecio());
        System.out.println("Tiene un consumo electrico tipo " + refrigeradores.get(refrigeradorOpcion - 1).getConsumoElectrico());
        System.out.println("Tiene " + refrigeradores.get(refrigeradorOpcion - 1).getNumeroPuertas() + " puertas");
        System.out.println("Cantidad disponible: " + refrigeradores.get(refrigeradorOpcion - 1).getCantidadDisponible() + " unidades");
        System.out.println("Presione Y para comprar o N para cancelar");
        Scanner sc7 = new Scanner(System.in);
        String opcionCompra = sc7.nextLine();
        if (opcionCompra.equals("y") || opcionCompra.equals("Y")) {
            System.out.println("¿Desea agregar un 5kg de hielo por $ 5000?");
            System.out.println("Presione Y para comprar o N para cancelar");
            Scanner sc8 = new Scanner(System.in);
            String opcionHielo = sc8.nextLine();
            if (opcionHielo.equals("y") || opcionHielo.equals("Y")) {
                System.out.println("Felcidades! Ha comprado su refrigerador incluyendo 5kg de hielo");
                int nuevaCantidad = refrigeradores.get(refrigeradorOpcion - 1).getCantidadDisponible() - 1;
                refrigeradores.get(refrigeradorOpcion - 1).setCantidadDisponible(nuevaCantidad);
                System.out.println("Nueva cantidad disponible: " + refrigeradores.get(refrigeradorOpcion - 1).getCantidadDisponible());
            } else if (opcionHielo.equals("n") || opcionHielo.equals("N")) {
                System.out.println("Felcidades! Ha comprado su refrigerador sin hielo");
                int nuevaCantidad = refrigeradores.get(refrigeradorOpcion - 1).getCantidadDisponible() - 1;
                refrigeradores.get(refrigeradorOpcion - 1).setCantidadDisponible(nuevaCantidad);
                System.out.println("Nueva cantidad disponible: " + refrigeradores.get(refrigeradorOpcion - 1).getCantidadDisponible());
            } else {
                System.out.println("Opción no válida");
            }
        } else if (opcionCompra.equals("n") || opcionCompra.equals("N")) {
            System.out.println("Gracias por ver nuestros productos");
        } else {
            System.out.println("Opción no válida");
        }
    }
}
