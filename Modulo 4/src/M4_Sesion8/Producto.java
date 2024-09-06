package M4_Sesion8;

public abstract class Producto{
    private String nombre;
    private String codigo;
    private int precio;

    //Constructor
    public Producto(String nombre, String codigo, int precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getPrecio() {
        return precio;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    //toString
    @Override
    public String toString() {
        return "Producto [" +
                " nombre= " + nombre +
                ", codigo= " + codigo +
                ", precio= " + precio + "]";
    }
}
