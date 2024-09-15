package M4_Sesion7;

public class Cocina extends Producto implements FuncionesCocina {
    private int cantidadQuemadores;
    private String nombre;

    public Cocina(String nombre, int precio, int cantidadDisponible, int cantidadQuemadores) {
        super(precio, cantidadDisponible);
        this.cantidadQuemadores = cantidadQuemadores;
        this.nombre = nombre;
    }

    public int getCantidadQuemadores() {
        return cantidadQuemadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadQuemadores(int cantidadQuemadores) {
        this.cantidadQuemadores = cantidadQuemadores;
    }

    public void incluyeGas() {
        System.out.println("Felcidades! Ha comprado su cocina incluyendo Gas");
    }

    @Override
    public String toString() {
        return "Cocina{" +
                "precio=" + getPrecio() +
                ", cantidadDisponible=" + getCantidadDisponible() +
                "cantidadQuemadores=" + cantidadQuemadores +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
