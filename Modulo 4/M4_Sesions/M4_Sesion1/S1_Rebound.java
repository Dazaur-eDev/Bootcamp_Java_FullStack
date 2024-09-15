package M4_Sesion1;
import java.util.Scanner;

public class S1_Rebound {
    public void calcularArea() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de la base: ");
        int base = sc.nextInt();

        System.out.println("Ingrese el valor de la altura: ");
        int altura = sc.nextInt();

        int area = base * altura;
        //System.out.println("El área calculada del rectángulo es: " + area);
        System.out.printf("El área calculada del rectángulo es: %d%n", area);
    }

    public void calcularPerimetro(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de la base: ");
        int base = sc.nextInt();

        System.out.println("Ingrese el valor de la altura: ");
        int altura = sc.nextInt();

        int perimetro = (base + base) + (altura + altura);
        System.out.printf("El perímetro calculado del rectangulo es: %d%n", perimetro);
    }
}



