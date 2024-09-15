package M4_Sesion10;

public class Director extends Persona implements AccionesPersona {
    private int anioExperiencia;
    private boolean amonestado;

    public Director(String nombre, String apellido, int edad, int anioExperiencia, boolean amonestado) {
        super(nombre, apellido, edad);
        this.anioExperiencia = anioExperiencia;
        this.amonestado = amonestado;
    }

    public int getAnioExperiencia() {
        return anioExperiencia;
    }

    public void setAnioExperiencia(int anioExperiencia) {
        this.anioExperiencia = anioExperiencia;
    }

    public boolean isAmonestado() {
        return amonestado;
    }

    public void setAmonestado(boolean amonestado) {
        this.amonestado = amonestado;
    }

    @Override
    public void celebrar() {
        System.out.println(getApellido() + ": Adelante equipo, ustedes pueden");
    }

    @Override
    public void hablar() {
        System.out.println(getNombre() + " " + getApellido() + ": Adelante equipo, jueguen según lo planificado");
    }

    @Override
    public void recibirTarjetaAmarilla() {
        System.out.println("Director técnico " + getNombre() + " " + getApellido() + " ha sido amonestado con tarjeta amarilla");
    }

    @Override
    public void recibirTarjetaRoja() {
        System.out.println("Director técnico " + getNombre() + " " + getApellido() + " ha sido amonestado con tarjeta roja");
    }

    @Override
    public String toString() {
        return "Director[" +
                " nombre=" + getNombre() +
                ", apellido=" + getApellido() +
                ", edad=" + getEdad() +
                ", añoExperiencia=" + anioExperiencia +
                ", amonestado=" + amonestado +
                " ]";
    }
}
