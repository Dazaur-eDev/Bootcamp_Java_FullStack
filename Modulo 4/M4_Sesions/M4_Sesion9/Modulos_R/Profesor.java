package M4_Sesion9.Modulos_R;

public class Profesor<T> extends Curso {

    // Atributos
    private T especialidad;

    //Constructor
    public Profesor(String nombre, T fechaNacimiento, T especialidad) {
        super(nombre, fechaNacimiento);
        this.especialidad = especialidad;
    }

    //Getters
    public T getEspecialidad() {
        return especialidad;
    }

    //Setters
    public void setEspecialidad(T especialidad) {
        this.especialidad = especialidad;
    }

    //ToString
    @Override
    public String toString() {
        return "Profesor: [ Nombre= " + getNombre() + " - Fecha Nacimiento= " + getFechaNacimiento() + " - Especialidad= " + especialidad + "]";
    }


}
