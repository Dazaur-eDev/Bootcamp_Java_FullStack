package M4_Sesion17.Modulos_R;

public class Alas {
    private String largoEnMetros;
    private boolean buenEstado;

    public Alas(String largoEnMetros, boolean buenEstado) {
        this.largoEnMetros = largoEnMetros;
        this.buenEstado = buenEstado;
    }

    public String getLargoEnMetros() {
        return largoEnMetros;
    }

    public void setLargoEnMetros(String largoEnMetros) {
        this.largoEnMetros = largoEnMetros;
    }

    public boolean isBuenEstado() {
        return buenEstado;
    }

    public void setBuenEstado(boolean buenEstado) {
        this.buenEstado = buenEstado;
    }

    public void pruebaAlas() {
        System.out.println("Prueba de alas completada.");
        setBuenEstado(true);
    }

    @Override
    public String toString() {
        return "Alas[" +
                "Largo=" + largoEnMetros +
                ", Estado=" + buenEstado +
                "]";
    }
}
