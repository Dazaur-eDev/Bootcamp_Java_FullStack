package M4_Sesion9.Modulos_R;

public class Alumno<T> extends Curso {

    //Atributos
    private T tareasPendientes;

    //Constructor
    public Alumno(String nombre, T fechaNacimiento, T tareasPendientes) {
        super(nombre, fechaNacimiento);
        this.tareasPendientes = tareasPendientes;
    }

    //Getter
    public T getTareasPendientes() {
        return tareasPendientes;
    }

    //Setter
    public void setTareasPendientes(T tareasPendientes) {
        this.tareasPendientes = tareasPendientes;
    }

    //toString
    @Override
    public String toString() {
        return "Alumno: [Nombre= " + getNombre() + " - Fecha Nacimiento= " + getFechaNacimiento() + " - TareasPendientes= " + tareasPendientes + "]";
    }
}
