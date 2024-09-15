package M4_Sesion17.Modulos_R;

public class Motor {
    private boolean tieneCombustible;
    private boolean buenEstado;

    public Motor(boolean tieneCombustible, boolean buenEstado) {
        this.tieneCombustible = tieneCombustible;
        this.buenEstado = buenEstado;
    }

    public boolean isTieneCombustible() {
        return tieneCombustible;
    }

    public void setTieneCombustible(boolean tieneCombustible) {
        this.tieneCombustible = tieneCombustible;
    }

    public boolean isBuenEstado() {
        return buenEstado;
    }

    public void setBuenEstado(boolean buenEstado) {
        this.buenEstado = buenEstado;
    }

    public void cargarCombustible() {
        if (!isTieneCombustible()) {
            setTieneCombustible(true);
            System.out.println("Cargando combustible");
        } else {
            System.out.println("Motor ya se encuentra cargado con combustible");
        }

    }

    @Override
    public String toString() {
        return "Motor[" +
                "tieneCombustible=" + tieneCombustible +
                ", buenEstado=" + buenEstado +
                "]";
    }
}
