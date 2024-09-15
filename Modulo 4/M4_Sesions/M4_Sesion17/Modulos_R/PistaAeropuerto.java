package M4_Sesion17.Modulos_R;

public class PistaAeropuerto {
    private boolean disponible;

    public void actualizarDisponibilidad(boolean estado){
        if(estado){
            System.out.println("Pista disponible");
        } else {
            System.out.println("Pista no disponible");
        }

    }

    public PistaAeropuerto(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "PistaAeropuerto{" +
                "disponible=" + disponible +
                '}';
    }
}
