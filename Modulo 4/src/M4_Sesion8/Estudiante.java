package M4_Sesion8;

public class Estudiante implements Actividades {
    private String nombre;
    private int id;
    private Profesor profesor;
    private String hobbie;

    public Estudiante(String nombre, int id, Profesor profesor, String hobbie) {
        this.nombre = nombre;
        this.id = id;
        this.profesor = profesor;
        this.hobbie = hobbie;
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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getHobbie() {
        return hobbie;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

    @Override
    public void leer() {
        System.out.println("El estudiante " + nombre + " está leyendo.");
    }

    @Override
    public void realizarEjercicio() {
        System.out.println("El estudiante " + nombre + " está realizando los ejercicios.");
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", profesor=" + profesor +
                ", hobbie='" + hobbie + '\'' +
                '}';
    }
}
