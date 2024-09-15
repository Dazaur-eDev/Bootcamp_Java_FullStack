package M4_Sesion9.Modulos_E;

public class Zapato {
    private String marca;

    public Zapato(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marcar) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Zapato [ Marca: " + marca + "]";
    }
}
