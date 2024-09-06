package M4_Sesion8;

public interface CarritoCompras {
    void listadoProductos();

    void agregarProductosCarrito(Producto producto);

    void vaciarCarrito();

    public int getCantidadProductos();

    public int calcularTotal();

    void pagarCarrito();
}
