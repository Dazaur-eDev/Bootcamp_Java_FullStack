package M4_Sesion7;

public class Auto extends Vehiculo implements FuncionesVehiculo {
    private String color;
    private String modelo;

    public Auto(int numeroRuedas, int numeroVentanas, String color, String modelo) {
        super(numeroRuedas, numeroVentanas);
        this.color = color;
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void encender() {
        System.out.println("Auto " + modelo + " se ha encendido");
    }

    public void apagar() {
        System.out.println("Auto " + modelo + " se ha apagado");
    }

    public void tipoBencina() {
        System.out.println("Utilize combustible de acuerdo al modelo: puede ser bencina, petroleo o gas licuado");
    }

    @Override
    public String toString() {
        return "Auto{" +
                "numeroRuedas=" + getNumeroRuedas() +
                ",numeroVentanas=" + getNumeroVentanas() +
                ",color='" + color + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
