package M4_Sesion9.Modulos_E;

public class Polera {
    private String color;

    public Polera(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Polera [ Color: " + color + "]";
    }
}
