package M4_Sesion6;

public class Mensaje {
    private String mensaje;
    private static int contador = 0;

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
        contador++;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Mensaje.contador = contador;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "mensaje='" + mensaje + '\'' +
                '}';
    }
}
