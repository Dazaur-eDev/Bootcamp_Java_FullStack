package M4_Sesion8.Modulos_R;

public class Profesor implements Actividades {
    private String nombre;
    private int id;
    private String especialidad;

    public Profesor(String nombre, int id, String especialidad) {
        this.nombre = nombre;
        this.id = id;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void leer() {
        System.out.println("El profesor " + nombre + " está leyendo.");
    }

    public void realizarEjercicio() {
        System.out.println("El profesor " + nombre + " está realizando los ejercicios.");
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
