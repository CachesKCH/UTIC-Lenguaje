import java.util.Scanner;


public class Practica2Ejercicio3 {

    public static void main(String[] args) {
        // Varaibles
        Scanner scanner = new Scanner(System.in);
        String caracter;

        // Entrada
        System.out.println("Prgrama Java Condicional String");
        System.out.println("Tipee un caracter: ");
        caracter = scanner.nextLine();

        // Condicional
        if (caracter.length() != 1) {
            System.out.println("El Caracter no existe!");
        } else if ((caracter.compareTo("A") >= 0) && (caracter.compareTo("Z") <= 0)) {
            System.out.println("El caracter es una mayuscula!");
        } else {
            System.out.println("El caracter es una minuscula!");
        }

        scanner.close();
    }
}