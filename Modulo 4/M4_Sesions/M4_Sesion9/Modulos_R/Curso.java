package M4_Sesion9.Modulos_R;

public class Curso<T> {
    //Atributos
    private String nombre;
    private T fechaNacimiento;

    //Constructor
    public Curso(String nombre, T fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public T getFechaNacimiento() {
        return fechaNacimiento;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(T fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Curso: [Nombre: " + nombre + ", Fecha: " + fechaNacimiento + "]";
    }
}
