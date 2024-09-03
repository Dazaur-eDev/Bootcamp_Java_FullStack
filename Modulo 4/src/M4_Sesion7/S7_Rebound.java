package M4_Sesion7;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class S7_Rebound {

    public void vehiculo() {

        ArrayList<Auto> autos = new ArrayList<>();
        autos.add(new Auto(4, 6, "Verde", "Tercel"));
        autos.add(new Auto(2, 4, "Negro", "Rx-4"));
        autos.add(new Auto(6, 6, "Azul", "MG-6"));

        ArrayList<Bicicleta> bicicletas = new ArrayList<>();
        bicicletas.add(new Bicicleta(2, 0, "Mountainbike", "Rojo", "Specialized", "Vado"));
        bicicletas.add(new Bicicleta(2, 0, "Pistera", "Blanca", "Oxford", "of400"));
        bicicletas.add(new Bicicleta(2, 0, "Ciudad", "Rojo", "Specialized", "VadoM"));
        bicicletas.add(new Bicicleta(2, 0, "4x4", "Rojo", "Specialized", "VadoL"));
        bicicletas.add(new Bicicleta(2, 0, "Mountainbike", "Rojo", "Specialized", "VadoXL"));


        System.out.println("Bienvenido al asistente virtual: ");
        boolean tokenSalida = false;

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int contador = 0;

        while (!tokenSalida) {
            System.out.println("1.- Listado de Vehiculos");
            System.out.println("2.- Encender Vehiculo");
            System.out.println("3.- Apagar Vehiculo");
            System.out.println("4.- Cargar bencina");
            System.out.println("5.- Salir");
            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Debe ingresar un número");
            }

            switch (opcion) {
                case 1:
                    //Usando for each para recorrer las instancias
                    System.out.println("Listado de vehiculos (Autos y Bicicletas):");
                    for (Auto a : autos) {
                        System.out.println(a.getModelo());
                    }
                    for (Bicicleta b : bicicletas) {
                        System.out.println(b.getModelo());
                    }
                    break;
                case 2:
                    //Usando el for clasico para recorrer las instancias
                    //Mostramos los autos y bicicletas disponibles para encender
                    System.out.println("Seleccione el auto a encender:");
                    for (int i = 0; i < autos.size(); i++) {
                        System.out.println(i + 1 + ". " + autos.get(i).getModelo());
                        contador++;
                    }
                    for (int i = 0; i < (bicicletas.size()); i++) {
                        contador++;
                        System.out.println(contador + ". " + bicicletas.get(i).getModelo());
                    }
                    //Ejecutar metodo de acuerdo a selección escogida de la lista anterior
                    int seleccion = sc.nextInt();
                    if (seleccion > 0 && seleccion <= autos.size()) {
                        autos.get(seleccion - 1).encender();
                    } else if (seleccion > autos.size() && seleccion <= contador) {
                        bicicletas.get(1).encender();
                    } else {
                        System.out.println("Selección no válida");
                    }
                    contador = 0;
                    break;
                case 3:
                    //Mostramos los autos y bicicletas disponibles para apagar
                    System.out.println("Seleccione el auto a apagar");
                    for (int i = 0; i < autos.size(); i++) {
                        System.out.println(i + 1 + ". " + autos.get(i).getModelo());
                        contador++;
                    }
                    for (int i = 0; i < (bicicletas.size()); i++) {
                        contador++;
                        System.out.println(contador + ". " + bicicletas.get(i).getModelo());
                    }
                    //Ejecutar metodo de acuerdo a selección escogida de la lista anterior
                    int seleccion2 = sc.nextInt();
                    if (seleccion2 > 0 && seleccion2 <= autos.size()) {
                        autos.get(seleccion2 - 1).apagar();
                    } else if (seleccion2 > autos.size() && seleccion2 <= contador) {
                        bicicletas.get(1).encender();
                    } else {
                        System.out.println("Selección no válida");
                    }
                    contador = 0;
                    break;
                case 4:
                    System.out.println("Seleccione el auto a cargar combustible");
                    for (int i = 0; i < autos.size(); i++) {
                        System.out.println(i + 1 + ". " + autos.get(i).getModelo());
                    }
                    int seleccion3 = sc.nextInt();
                    if (seleccion3 > 0 && seleccion3 <= autos.size()) {
                        autos.get(seleccion3 - 1).tipoBencina();
                    }
                    break;
                case 5:
                    tokenSalida = true;
                    break;
                default:
                    System.out.println("Alternativa no válida, reintente.");
            }
        }
    }
}
