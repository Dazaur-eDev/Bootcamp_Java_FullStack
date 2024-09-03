package M4_Sesion9;

public class Alumno <T> {

    //Atributos
    private String nombre;
    private T fechaNacimiento;
    private T tareasPendientes;

    //Constructor
    public Alumno(String nombre, T fechaNacimiento, T tareasPendientes) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.tareasPendientes = tareasPendientes;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public T getFechaNacimiento() {
        return fechaNacimiento;
    }

    public T getTareasPendientes() {
        return tareasPendientes;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechanacimiento(T fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTareasPendientes(T tareasPendientes) {
        this.tareasPendientes = tareasPendientes;
    }

    //toString
    @Override
    public String toString() {
        return "Alumno: [Nombre= " + nombre + " - Fecha Nacimiento= " + fechaNacimiento + " - TareasPendientes= " + tareasPendientes + "]";
    }
}
