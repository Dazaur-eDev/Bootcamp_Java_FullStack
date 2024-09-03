package M4_Sesion6;

public class Usuario {
    private String nombreUsuario;
    private String contrasena;
    private String NombreCompleto;
    private String fechaNacimiento;
    private static int contador = 0;

    public Usuario(String nombreUsuario, String contrasena, String nombreCompleto, String fechaNacimiento) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        NombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        contador++;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Usuario.contador = contador;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", NombreCompleto='" + NombreCompleto + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }
}
