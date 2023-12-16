import java.util.Scanner;

public class Practica2Ejercicio2 {

    public static void main(String[] args) {

        // Variables
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        // Entrada
        System.out.print("Digite primer numero: ");
        num1 = scanner.nextInt();
        System.out.print("Digite segundo numero: ");
        num2 = scanner.nextInt();

        // Condicional
        if (num1 > num2) {
            System.out.println("El primer numero es mayor");
        } else if (num2 > num1) {
            System.out.println("El segundo numero es mayor");
        } else {
            System.out.println("Son iguales");
        }
        
        scanner.close();
    }
}