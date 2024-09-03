package M4_Sesion7;

public abstract class Vehiculo {
    private int numeroRuedas;
    private int numeroVentanas;

    public Vehiculo(int numeroRuedas, int numeroVentanas) {
        this.numeroRuedas = numeroRuedas;
        this.numeroVentanas = numeroVentanas;
    }

    public int getNumeroRuedas() {
        return numeroRuedas;
    }

    public void setNumeroRuedas(int numeroRuedas) {
        this.numeroRuedas = numeroRuedas;
    }

    public int getNumeroVentanas() {
        return numeroVentanas;
    }

    public void setNumeroVentanas(int numeroVentanas) {
        this.numeroVentanas = numeroVentanas;
    }

    public abstract void encender();

    public abstract void apagar();

    @Override
    public String toString() {
        return "Vehiculo{" +
                "numeroRuedas=" + numeroRuedas +
                ", numeroVentanas=" + numeroVentanas +
                '}';
    }
}
