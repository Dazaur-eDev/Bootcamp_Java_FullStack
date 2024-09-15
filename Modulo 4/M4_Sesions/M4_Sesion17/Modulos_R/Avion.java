package M4_Sesion17.Modulos_R;

public class Avion {
    private String marca;
    private String modelo;
    private boolean listoParaDespegar;
    private Alas alas;
    private Motor motor;
    private Cabina cabina;
    private Rueda rueda;

    public Avion(String marca, String modelo, boolean listoParaDespegar, Alas alas, Motor motor, Cabina cabina, Rueda rueda) {
        this.marca = marca;
        this.modelo = modelo;
        this.listoParaDespegar = listoParaDespegar;
        this.alas = alas;
        this.motor = motor;
        this.cabina = cabina;
        this.rueda = rueda;
    }

    public void recibirPasajeros() {
        System.out.println("Recibiendo Pasajeros en el avión");
        System.out.println("Se procedera al cierre de puertas");
    }

    public void despegar() {
        if (alas.isBuenEstado() && motor.isBuenEstado() && motor.isTieneCombustible() && rueda.isBuenEstado() && rueda.isInfladas() && cabina.isBuenEstado() && cabina.isPuertasCerradas()) {
            listoParaDespegar = true;
            System.out.println("El avión está listo para despegar.");
        } else {
            System.out.println("El avión no está listo para despegar.");
        }
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

    public boolean isListoParaDespegar() {
        return listoParaDespegar;
    }

    public void setListoParaDespegar(boolean listoParaDespegar) {
        this.listoParaDespegar = listoParaDespegar;
    }

    public Alas getAlas() {
        return alas;
    }

    public void setAlas(Alas alas) {
        this.alas = alas;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Cabina getCabina() {
        return cabina;
    }

    public void setCabina(Cabina cabina) {
        this.cabina = cabina;
    }

    public Rueda getRueda() {
        return rueda;
    }

    public void setRueda(Rueda rueda) {
        this.rueda = rueda;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", listoParaDespegar=" + listoParaDespegar +
                ", alas=" + alas +
                ", motor=" + motor +
                ", cabina=" + cabina +
                ", rueda=" + rueda +
                '}';
    }
}
