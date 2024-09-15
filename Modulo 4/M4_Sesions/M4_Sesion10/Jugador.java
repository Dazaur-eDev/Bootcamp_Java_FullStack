package M4_Sesion10;

public class Jugador extends Persona implements AccionesPersona {
    private int numeroCamiseta;
    private String posicion;
    private boolean amonestado;

    public Jugador(String nombre, String apellido, int edad, int numeroCamiseta, String posicion, boolean amonestado) {
        super(nombre, apellido, edad);
        this.numeroCamiseta = numeroCamiseta;
        this.posicion = posicion;
        this.amonestado = amonestado;
    }

    public boolean isAmonestado() {
        return amonestado;
    }

    public void setAmonestado(boolean amonestado) {
        this.amonestado = amonestado;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void correr() {

    }

    public void saltar() {

    }

    public void robarBalon() {

    }

    @Override
    public void celebrar() {
        System.out.println(getApellido() + " grita: Gol!");
    }

    @Override
    public void hablar() {
        System.out.println(getNombre() + " dice: Toca el pase");
    }

    @Override
    public void recibirTarjetaAmarilla() {
        System.out.println("Jugador " + getNombre() + " " + getApellido() + " ha sido amonestado con tarjeta amarilla");
    }

    @Override
    public void recibirTarjetaRoja() {
        System.out.println("Jugador " + getNombre() + " " + getApellido() + " ha sido amonestado con tarjeta roja");
    }

    @Override
    public String toString() {
        return "Jugador[" +
                " nombre=" + getNombre() +
                ", apellido=" + getApellido() +
                ", edad=" + getEdad() +
                ", numeroCamiseta=" + numeroCamiseta +
                ", posicion='" + posicion + '\'' +
                ", amonestado=" + amonestado +
                " ]";
    }
}
