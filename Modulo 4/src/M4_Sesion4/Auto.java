package M4_Sesion4;

public class Auto {
    private String marca;
    private String modelo;
    private String color;
    private int velocidadMaxima;
    private boolean encendido;

    public Auto(String marca, String modelo, String color, int velocidadMaxima, boolean encendido) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.velocidadMaxima = velocidadMaxima;
        this.encendido = encendido;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", velocidadMaxima=" + velocidadMaxima +
                ", encendido=" + encendido +
                '}';
    }
}
