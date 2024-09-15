package M4_Sesion9.Modulos_E;

import java.util.ArrayList;

public class Bolsa<T> {
    private ArrayList<T> items;
    private int capacidad;

    public Bolsa(int capacidad) {
        this.capacidad = capacidad;
        this.items = new ArrayList<>(capacidad);
    }

    public void agregarItem(T item) {
        if (items.size() < capacidad) {
            items.add(item);
            System.out.println(item + " agregado a la bolsa.");
        } else {
            System.out.println("La bolsa está llena, no se pueden agregar más items.");
        }
    }

    public void mostrarItems() {
        System.out.println("Items en la bolsa:");
        int index=1;
        for (T item : items) {
            System.out.println(index + ".- " + item);
            index++;
        }
    }
}