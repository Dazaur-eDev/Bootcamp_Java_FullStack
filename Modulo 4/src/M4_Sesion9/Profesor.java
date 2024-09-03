package M4_Sesion9;

public class Profesor<T> {

    // Atributos
    private String nombre;
    private T fechaNacimiento;
    private String especialidad;

    //Constructor
    public Profesor (String nombre, T fechaNacimiento, String especialidad) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.especialidad = especialidad;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public T getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(T fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEspecialidad (String especialidad) {
        this.especialidad = especialidad;
    }

    //ToString
    @Override
    public String toString() {
        return "Profesor: [ Nombre= " + nombre + " - Fecha Nacimiento= " + fechaNacimiento + " - Especialidad= " + especialidad + "]";
    }


}
