package M4_Sesion4;

import java.util.ArrayList;

public class S4_Rebound {

    Persona[] tablaPersonas = new Persona[5];
    double imc;
    String estadoSalud;
    String validadorMayoriaEdad;


    public void calculo() {
        tablaPersonas[0] = new Persona("Patricio", 33, 70.2, 1.75);
        tablaPersonas[1] = new Persona("Milan", 1, 3.2, 0.45);
        tablaPersonas[2] = new Persona("Daniel", 18, 98.2, 1.75);
        tablaPersonas[3] = new Persona("Ruth", 66, 50.2, 1.54);
        tablaPersonas[4] = new Persona("Alejandro", 39, 87.2, 1.68);

        for (int i = 0; i < 5; i++) {
            String nombrePersona = tablaPersonas[i].getNombre();
            int edadPersona = tablaPersonas[i].getEdad();
            double pesoPersona = tablaPersonas[i].getPeso();
            double alturaPersona = tablaPersonas[i].getAltura();
            System.out.println(nombrePersona);

            imc = pesoPersona / Math.pow(alturaPersona, 2);
            if (imc < 18.5) {
                estadoSalud = "con bajo peso";
            }
            if (imc >= 18.5 && imc < 24.9) {
                estadoSalud = "normal";
            }
            if (imc >= 24.9 && imc < 29.9) {
                estadoSalud = "con sobrepeso";
            }
            if (imc >= 29.9) {
                estadoSalud = "con obesidad";
            }
            if (edadPersona >= 18) {
                validadorMayoriaEdad = "Mayor de Edad";
            } else {
                validadorMayoriaEdad = "Menor de Edad";
            }
            System.out.println("Calculando su IMC ...");
            System.out.printf("Su índice de masa muscular es de %.2f %n", imc);
            System.out.println("Usted se encuentra " + estadoSalud);
            System.out.println("Su edad es de " + edadPersona);
            System.out.println(tablaPersonas[i]);
            System.out.println();
        }
    }


}


