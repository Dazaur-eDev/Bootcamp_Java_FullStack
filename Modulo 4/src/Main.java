import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        System.out.println("bienvenido a intellij");
        System.out.print("Hola ");
        int añoActual = 2024;
        System.out.printf("Estamos en el año: %d %n", 2024);
        System.out.println("Estamos en el año: " + 2024);
        System.out.println("Estamos en el año: " + añoActual);
        LocalDate FechaActual = LocalDate.now()
        System.out.println(FechaActual);
        System.out.printf("Estamos en el año: %s %n", FechaActual);
    }
}