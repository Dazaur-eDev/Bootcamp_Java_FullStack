package M4_Sesion7;

public class Bicicleta extends Vehiculo {
    private String tipoBicicleta;
    private String color;
    private String marca;
    private String modelo;

    public Bicicleta(int numeroRuedas, int numeroVentanas, String tipoBicicleta, String color, String marca, String modelo) {
        super(numeroRuedas, numeroVentanas);
        this.tipoBicicleta = tipoBicicleta;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getTipoBicicleta() {
        return tipoBicicleta;
    }

    public void setTipoBicicleta(String tipoBicicleta) {
        this.tipoBicicleta = tipoBicicleta;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void encender() {
        System.out.println("Bicicleta no aplica este método porque no es Eléctrica");
    }

    public void apagar() {
        System.out.println("Bicicleta no aplica este método porque no es Eléctrica");
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "numeroRuedas=" + getNumeroRuedas() +
                ",numeroVentanas=" + getNumeroVentanas() +
                "tipoBicicleta='" + tipoBicicleta + '\'' +
                ", color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
