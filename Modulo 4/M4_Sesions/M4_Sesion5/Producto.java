package M4_Sesion5;

public class Producto {
    private String nombre;
    private int valor;
    private String descripcion;

    public Producto(String nombre, int cantidad, String descripcion) {
        this.nombre = nombre;
        this.valor = cantidad;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int cantidad) {
        this.valor = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", valor=" + valor +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
