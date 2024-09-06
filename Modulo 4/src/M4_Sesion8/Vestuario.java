package M4_Sesion8;

public class Vestuario extends Producto {
    private int talla;
    private String color;

    //Constructor
    public Vestuario(String nombre, String codigo, int precio, int talla, String color) {
        super(nombre, codigo, precio);
        this.talla = talla;
        this.color = color;
    }

    //Getters
    public int getTalla() {
        return talla;
    }

    public String getColor() {
        return color;
    }

    //Setters
    public void setTalla(int talla) {
        this.talla = talla;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //toString
    @Override
    public String toString() {
        return "Vestuario [" +
                " nombre= " + getNombre() +
                ", codigo= " + getCodigo() +
                ", precio= " + getPrecio() +
                ", talla= " + talla +
                ", color= " + color + ']';
    }
}
