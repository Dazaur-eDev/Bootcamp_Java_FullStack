package M4_Sesion7;

public class Refrigerador extends Producto implements FuncionesProducto {
    private String consumoElectrico;
    private int numeroPuertas;
    private String nombre;

    public Refrigerador(String nombre, int precio, int cantidadDisponible, String consumoElectrico, int numeroPuertas) {
        super(precio, cantidadDisponible);
        this.consumoElectrico = consumoElectrico;
        this.numeroPuertas = numeroPuertas;
        this.nombre = nombre;
    }

    public String getConsumoElectrico() {
        return consumoElectrico;
    }

    public void setConsumoElectrico(String consumoElectrico) {
        this.consumoElectrico = consumoElectrico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public String toString() {
        return "Refrigerador{" +
                "precio=" + getPrecio() +
                ", cantidadDisponible=" + getCantidadDisponible() +
                "consumoElectrico='" + consumoElectrico + '\'' +
                ", numeroPuertas=" + numeroPuertas +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
