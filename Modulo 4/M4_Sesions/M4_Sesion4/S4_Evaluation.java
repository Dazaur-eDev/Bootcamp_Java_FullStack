package M4_Sesion4;

import java.util.Scanner;

public class S4_Evaluation {
    Auto auto = new Auto("Mazda", "Rx-8", "Verde", 180, false);
    boolean estadoAuto = false;
    public void mainAuto() {
        boolean flag = false;
        System.out.println("Bienvenido al asistente de su nuevo vehículo");
        System.out.println(auto);
        while (flag != true) {
            menu();
            Scanner sc = new Scanner(System.in);
            int menuAuto = sc.nextInt();
            switch (menuAuto) {
                case 1:
                    encenderAuto();
                    break;
                case 2:
                    apagarAuto();
                    break;
                case 3:
                    acelerarAuto();
                    break;
                case 4:
                    System.out.println("Hasta pronto");
                    flag = true;
                    break;
            }
        }
    }

    private void menu() {
        System.out.println("Seleccione que desea realizar:");
        System.out.println("1.- Encender auto");
        System.out.println("2.- Apagar auto");
        System.out.println("3.- Acelerar auto");
        System.out.println("4.- Salir");
    }

    private void encenderAuto(){
        estadoAuto = auto.isEncendido();
        if (estadoAuto != true) {
            System.out.println("Se ha encendido el auto");
            auto.setEncendido(true);
        } else {
            System.out.println("No se puede realizar la acción solicitada debido a que el auto ya se encuentra encendido");
        }
    }
    private void apagarAuto(){
        estadoAuto = auto.isEncendido();
        if (estadoAuto != false) {
            System.out.println("Se ha apagado el auto");
            auto.setEncendido(false);
        } else {
            System.out.println("No se puede realizar la acción solicitada debido a que el auto ya se encuentra apagado");
        }
    }
    private void acelerarAuto(){
        estadoAuto = auto.isEncendido();
        int velocidad = auto.getVelocidadMaxima();
        if (estadoAuto != false) {
            System.out.println("Acelerando el auto a velocidad maxima de " + velocidad + " km/hr");
        } else {
            System.out.println("El auto se encuentra apagado, por tanto, no es posible acelerar");
        }
    }
}
