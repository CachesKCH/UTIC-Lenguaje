import java.util.Scanner;

/**
 * Sueldo
 * 
 * @author GUSTAVO DOMINGUEZ
 */

public class Sueldo {
    private Scanner scanner;
    private int[] sueldos;

    public Sueldo() {
        scanner = new Scanner(System.in);
        sueldos = new int[5];
    }

    private void capturar() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese sueldo" + (i + 1) + ": ");
            sueldos[i] = scanner.nextInt();
        }
    }

    private void imprimir() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Sueldo ingresado en la posicion " + (i + 1) + ": " + sueldos[i]);
        }
    }

    public static void main(String[] args) {
        Sueldo sueldo = new Sueldo();
        sueldo.capturar();
        sueldo.imprimir();

    }
}