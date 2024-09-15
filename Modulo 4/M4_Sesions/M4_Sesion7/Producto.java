package M4_Sesion7;

public abstract class Producto implements FuncionesProducto {
    private int precio;
    private int cantidadDisponible;

    public Producto(int precio, int cantidadDisponible) {
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public void cambiarPrecio() {
    }

    public void cantidadDisponible() {
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precio=" + precio +
                ", cantidadDisponible=" + cantidadDisponible +
                '}';
    }
}
