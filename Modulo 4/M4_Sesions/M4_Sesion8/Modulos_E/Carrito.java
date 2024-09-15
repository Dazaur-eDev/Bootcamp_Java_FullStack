package M4_Sesion8.Modulos_E;

import java.util.ArrayList;

public class Carrito implements CarritoCompras {
    private ArrayList<Producto> productos = new ArrayList<>();
    private static final int MAX_PRODUCTOS = 10;

    public Carrito() {}

    @Override
    public void listadoProductos() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    @Override
    public void agregarProductosCarrito(Producto producto) {
        if (productos.size() < MAX_PRODUCTOS) {
            productos.add(producto);
            System.out.println(producto.getNombre() + " ha sido agregado al carrito con un precio de " + producto.getPrecio());
        } else {
            System.out.println("El carrito está lleno. No se pueden agregar más productos.");
        }
    }

    @Override
    public int calcularTotal() {
        int total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
    @Override
    public int getCantidadProductos() {
        return productos.size();
    }
    @Override
    public void vaciarCarrito() {
        productos.clear();
    }

    @Override
    public void pagarCarrito() {

    }
}
