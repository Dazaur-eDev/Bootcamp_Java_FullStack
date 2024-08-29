package M4_Sesion6;

import java.util.Scanner;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class S6_Evaluation {

    // Definicion de variables a usar en los métodos
    Usuario listaUsuarios[] = new Usuario[10];
    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate fechaValida;
    boolean tokenSalida = false;
    boolean tokenValidacionUsuario = false;
    boolean tokenValidacionContrasena = false;
    boolean tokenValidacionNombre = false;
    boolean tokenValidacionFecha = false;
    int contadorMayorEdad = 0;
    int contadorMenorEdad = 0;

    //Aplicacion principal
    public void app() {
        System.out.println("Bienvenido a la aplicación de usuarios");
        System.out.println("Seleccione una de las siguientes opciones");
        System.out.println("1.- Ingresar");
        System.out.println("2.- Salir");
        Scanner sc0 = new Scanner(System.in);
        int opcion = sc0.nextInt();
        switch (opcion) {
            case 1:
                usuariosApp();
                break;
            case 2:
                System.out.println("Hasta pronto");
                break;
        }
    }

    private void usuariosApp() {
        while (!tokenSalida) {
            //inicializacion de variables a usar
            String usuarioIngresado = "";
            String contrasenaIngresada = "";
            String nombreIngresado = "";
            String fechaNacimientoIngresada = "";
            LocalDate fechaHoy = LocalDate.now();

            //Reinicio de tokens para siguiente usuario a ingresar
            tokenValidacionUsuario = false;
            tokenValidacionContrasena = false;
            tokenValidacionNombre = false;
            tokenValidacionFecha = false;

            //Ingreso de usuario y validacion (valido si no esta repetido y que no sea vacío)
            while (!tokenValidacionUsuario) {
                System.out.println("Ingrese nuevo nombre de usuario");
                Scanner sc = new Scanner(System.in);
                usuarioIngresado = sc.nextLine();
                validacionUsuario(usuarioIngresado);
            }

            //Ingreso de contraseña y validacion (valida con 10 caracteres, dos letras mayúsculas y no puede ser vacía)
            while (!tokenValidacionContrasena) {
                System.out.println("Ingrese contraseña a registrar (Mínimo 10 caracteres, dos letras mayúsculas y al menos 3 simbolos o digitos)");
                Scanner sc2 = new Scanner(System.in);
                contrasenaIngresada = sc2.nextLine();
                validacionContrasena(contrasenaIngresada);
            }

            //Ingreso de nombre completo y validacion (que no tenga numeros)
            while (!tokenValidacionNombre) {
                System.out.println("Ingrese nombre completo");
                Scanner sc3 = new Scanner(System.in);
                nombreIngresado = sc3.nextLine();
                validacionNombre(nombreIngresado);
            }

            //Ingreso de fecha de nacimiento y validacion (es válida con formato YYYY-MM-DD)
            while (!tokenValidacionFecha) {
                System.out.println("Ingrese su fecha de nacimiento");
                Scanner sc4 = new Scanner(System.in);
                fechaNacimientoIngresada = sc4.nextLine();
                validacionFecha(fechaNacimientoIngresada);
            }

            //Registrar nueva instancia de usuario con sus respectivos atributos dado que se aprobaron todos los tokens o fichas anteriormente
            int indice = Usuario.getContador();
            listaUsuarios[indice] = new Usuario(usuarioIngresado, contrasenaIngresada, nombreIngresado, fechaNacimientoIngresada);
            System.out.println("Bienvenid@ " + listaUsuarios[indice].getNombreUsuario());

            //Contador de mayores y menores de Edad
            String fechaNacimientoUsuario = listaUsuarios[indice].getFechaNacimiento();
            LocalDate fechaEvaluar = LocalDate.parse(fechaNacimientoUsuario, formatoFecha);
            Period calculoMayoriaEdad = Period.between(fechaEvaluar, fechaHoy);
            System.out.printf("Tu edad es: %s años %n", calculoMayoriaEdad.getYears());
            if (calculoMayoriaEdad.getYears() >= 18) {
                System.out.println("Puede pasar a la zona para mayores de 18 años");
                contadorMayorEdad++;
            }
            if (calculoMayoriaEdad.getYears() < 18) {
                System.out.println("Acceso restringido para menores de edad");
                contadorMenorEdad++;
            }
            System.out.println("Cantidad de usuarios mayores de edad: " + contadorMayorEdad);
            System.out.println("Cantidad de usuarios menores de edad: " + contadorMenorEdad);
            System.out.println("Total de usuarios = " + Usuario.getContador());

            //Mostrar listado total de usuarios registrados
            System.out.println("Lista total de usuarios registrados: ");
            for (int i = 0; i < Usuario.getContador(); i++) {
                System.out.println((i + 1) + ".- " + listaUsuarios[i].getNombreUsuario() + " - " + listaUsuarios[i].getFechaNacimiento());
            }

            //Verificación de completado de listaUsuarios = 10 para finalizar programa principal
            if (indice == (listaUsuarios.length - 1)) {
                tokenSalida = true;
                System.out.println("Se ha completado la lista de 10 usuarios");
            }
        }
    }

    private void validacionUsuario(String usuarioIngresado) {
        if (Usuario.getContador() == 0) {
            if (!usuarioIngresado.isEmpty()) {
                tokenValidacionUsuario = true;
            } else {
                System.out.println("Ingrese un nombre de usuario que no sea vacio");
            }
        } else {
            for (int i = 0; i < Usuario.getContador(); i++) {
                if (usuarioIngresado.equals(listaUsuarios[i].getNombreUsuario())) {
                    System.out.println("Nombre ya existente");
                    tokenValidacionUsuario = false;
                    break;
                }
                if (!usuarioIngresado.isEmpty()) {
                    tokenValidacionUsuario = true;
                } else {
                    System.out.println("Ingrese un nombre de usuario que no sea vacio");
                    break;
                }
            }
        }
    }

    private void validacionContrasena(String contrasenaIngresada) {
        try {
            if (contrasenaIngresada.isEmpty()) {
                System.out.println("Clave no puede ser vacia.");
                int e = 1 / 0;
            }
            if (contrasenaIngresada.length() < 10) {
                System.out.println("Clave no puede ser inferior a 10 digitos");
                int e = 1 / 0;
            }
            int contadorMayus = 0;
            int contadorSignos = 0;
            int contadorNumeros = 0;
            for (int i = 0; i < contrasenaIngresada.length(); i++) {
                if (Character.isUpperCase(contrasenaIngresada.charAt(i))) {
                    contadorMayus++;
                }
                if (Character.isDigit(contrasenaIngresada.charAt(i))) {
                    contadorNumeros++;
                }
                if (!Character.isLetterOrDigit(contrasenaIngresada.charAt(i))) {
                    contadorSignos++;
                }
            }
            if (contadorMayus < 2) {
                System.out.println("Clave debe tener mínimo dos letras mayusculas");
                int e = 1 / 0;
            }
            if ((contadorSignos + contadorNumeros) < 3) {
                System.out.println("Clave debe tener mínimo tres números o símbolos");
                int e = 1 / 0;
            }
            tokenValidacionContrasena = true;
        } catch (Exception e) {
            System.out.println("Por favor, intente nuevamente");
            tokenValidacionContrasena = false;
        }
    }

    private void validacionNombre(String nombreIngresado) {
        try {
            if (nombreIngresado.isEmpty()) {
                System.out.println("Nombre no puede ser vacio.");
                int e = 1 / 0;
            }
            for (int i = 0; i < nombreIngresado.length(); i++) {
                if (Character.isDigit(nombreIngresado.charAt(i))) {
                    System.out.println("Nombre no puede contener numeros");
                    int e = 1 / 0;
                }
            }
            tokenValidacionNombre = true;
        } catch (Exception e) {
            System.out.println("Por favor, intente nuevamente");
            tokenValidacionNombre = false;
        }
    }

    private void validacionFecha(String fechaNacimientoIngresada) {
        try {
            fechaValida = LocalDate.parse(fechaNacimientoIngresada, formatoFecha);
            tokenValidacionFecha = true;
        } catch (DateTimeParseException e) {
            System.out.println("Fecha inválida. Por favor, ingrese la fecha en el formato dd/mm/yyyy");
        }
    }
}
