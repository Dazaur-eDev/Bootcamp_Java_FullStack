package M4_Sesion6;

import java.util.Scanner;

public class S6_Rebound {

    Persona[] usuario = new Persona[2];
    Mensaje[] mensajes = new Mensaje[5];
    boolean tokenGeneral = false;

    public void calculoMatematicos() {
        usuarios();
        validacionUsuario();
        if (!tokenGeneral) {
            menu();
        } else {
            System.out.println("ACCESO DENEGADO");
        }
    }

    private void validacionUsuario() {

        boolean tokenUsuario = false;
        boolean tokenContrasena = false;
        tokenGeneral = false;
        int numeroIntentoUsuario = 0;
        int numeroIntentoContrasena = 0;
        String usuarioValido = "";

        //Proceso validador usuario
        while (!tokenUsuario) {
            if (numeroIntentoUsuario != 3) {
                numeroIntentoUsuario++;
                System.out.println("Ingrese su nombre de usuario: ");
                Scanner sc = new Scanner(System.in);
                String usuarioIngresado = sc.nextLine();
                for (int i = 0; i < usuario.length; i++) {
                    if (usuarioIngresado.equals(usuario[i].getUsuario())) {
                        usuarioValido = usuario[i].getUsuario();
                        tokenUsuario = true;
                    }
                }
                if (tokenUsuario) {
                    System.out.println("Bienvenido " + usuarioValido);
                } else {
                    System.out.println("Usuario " + usuarioIngresado + " no encontrado, reintente nuevamente");
                }
            } else {
                System.out.println("Numero de intentos superados");
                System.out.println();
                tokenGeneral = true;
                break;
            }
        }
        if (tokenUsuario) {
            //Proceso validador contraseña
            while (!tokenContrasena) {
                if (numeroIntentoContrasena != 3) {
                    numeroIntentoContrasena++;
                    System.out.println("Ingrese su contraseña: ");
                    Scanner sc2 = new Scanner(System.in);
                    String contrasenaIngresada = sc2.nextLine();
                    for (int i = 0; i < usuario.length; i++) {
                        if (contrasenaIngresada.equals(usuario[i].getContrasena())) {
                            tokenContrasena = true;
                        }
                    }
                    if (tokenContrasena) {
                        System.out.println("Contraseña correcta");
                    } else {
                        System.out.println("Contraseña incorrecta, reintente nuevamente");
                    }

                } else {
                    System.out.println("Numero de intentos superados");
                    System.out.println();
                    tokenGeneral = true;
                    break;
                }
            }
        }
    }

    private void menu() {
        boolean flag = false;
        while (!flag) {
            System.out.println("¿Qué desea realizar?");
            System.out.println("1.- Calcular la raíz cuadrada de un número");
            System.out.println("2.- Ver el valor de π");
            System.out.println("3.- Calcular la potencia de un número");
            System.out.println("4.- Recibir un mensaje aleatorio");
            System.out.println("5.- Salir");
            Scanner sc = new Scanner(System.in);
            int opcionMenu = sc.nextInt();
            if (opcionMenu > 0 && opcionMenu <= 5) {
                switch (opcionMenu) {
                    case 1:
                        calculoRaiz();
                        break;
                    case 2:
                        valorPi();
                        break;
                    case 3:
                        calculoPotencia();
                        break;
                    case 4:
                        mensajeAleatorio();
                        break;
                    case 5:
                        System.out.println("Hasta pronto Alex15");
                        flag = true;
                        break;
                }
            } else {
                System.out.println("Opcion no valida, seleccione entre 1 y 5");
                System.out.println();
            }
        }
    }

    private void calculoRaiz() {
        System.out.println("Ingrese un número para calcular la raiz cuadrada:");
        Scanner sc = new Scanner(System.in);
        int numeroIngresado = sc.nextInt();
        double raiz = Math.sqrt(numeroIngresado);
        System.out.println("La raiz cuadrada de " + numeroIngresado + " es " + raiz);
        System.out.println();
    }

    private void valorPi() {
        double pi = Math.PI;
        System.out.println("El valor de π corresponde a " + pi);
        System.out.println();
    }

    private void calculoPotencia() {
        System.out.println("Ingrese un número:");
        Scanner sc = new Scanner(System.in);
        int numeroIngresado = sc.nextInt();
        System.out.println("Ingrese la potencia deseada");
        int potenciaIngresada = sc.nextInt();
        double potencia = Math.pow(numeroIngresado, potenciaIngresada);
        System.out.println("El valor de " + numeroIngresado + " elevado a " + potenciaIngresada + " es de " + potencia);
        System.out.println();
    }

    private void mensajeAleatorio() {
        mensajes();
        int max = Mensaje.getContador();
        int min = 0;
        int numeroAleatorio = (int) Math.floor((Math.random() * (max - min) + min));
        String mensajeObtenido = String.valueOf(mensajes[numeroAleatorio].getMensaje());
        System.out.println(mensajeObtenido);
        Mensaje.setContador(0);
        System.out.println();
    }

    private void usuarios() {
        usuario[0] = new Persona("daza", "1234");
        usuario[1] = new Persona("string", "4321");
    }

    private void mensajes() {
        mensajes[0] = new Mensaje("Ánimo, tú puedes");
        mensajes[1] = new Mensaje("La clase String es extremadamente útil");
        mensajes[2] = new Mensaje("Java es divertido");
        mensajes[3] = new Mensaje("Estoy motivado");
        mensajes[4] = new Mensaje("Recuerda el famoso ';' al final de cada sentencia en Java");
    }
}

