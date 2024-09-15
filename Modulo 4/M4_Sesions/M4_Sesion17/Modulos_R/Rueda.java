package M4_Sesion17.Modulos_R;

public class Rueda {
    private boolean infladas;
    private boolean buenEstado;

    public Rueda(boolean infladas, boolean buenEstado) {
        this.infladas = infladas;
        this.buenEstado = buenEstado;
    }

    public boolean isInfladas() {
        return infladas;
    }

    public void setInfladas(boolean infladas) {
        this.infladas = infladas;
    }

    public boolean isBuenEstado() {
        return buenEstado;
    }

    public void setBuenEstado(boolean buenEstado) {
        this.buenEstado = buenEstado;
    }

    public void inflar() {
        if (!isInfladas()) {
            setInfladas(true);
            System.out.println("Inflando Ruedas a presión adecuada");
        } else {
            System.out.println("Ruedas se encuentras ok");
        }

    }

    @Override
    public String toString() {
        return "Rueda[" +
                "infladas=" + infladas +
                ", buenEstado=" + buenEstado +
                "]";
    }
}
