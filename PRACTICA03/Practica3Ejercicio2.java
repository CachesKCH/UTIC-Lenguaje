import java.util.Scanner;

public class Practica3Ejercicio2 {
    public static void main(String[] args) {
        
        // Variables
        Scanner scanner = new Scanner(System.in);
        int tabla, resultado;

        // Entrada
        System.out.println("Que tabla desea mostrar?");
        tabla = scanner.nextInt();

        // Blucle
        for (int i = 1; i < 11;) {
            resultado = (tabla * i);
            System.out.println(tabla + " x " + i + " = " + resultado);
            i++;
        }
        scanner.close();
    }
}
