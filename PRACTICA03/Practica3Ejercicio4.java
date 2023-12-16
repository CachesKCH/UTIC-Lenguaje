import java.util.Scanner;

/**
 * Practica3Ejercicio4
 * @author GUSTAVO DOMINGUEZ
 */
public class Practica3Ejercicio4 {

    public static void main(String[] args) {

        // Variables
        Scanner scanner = new Scanner(System.in);
        String usuario;
        String usuarioCorrecto = "admin";
        int pin;
        int pinCorrecto = 12345;
        int correcto = 0;

        // Entrada
        while (correcto == 0) {
            System.out.print("Ingrese usuario: ");
            usuario = scanner.nextLine();
            System.out.print("Ingrese pin: ");
            pin = scanner.nextInt();

            // Verificar
            if ((usuario.equals(usuarioCorrecto)) && (pin == pinCorrecto)) {
                correcto = 1;
            }
            scanner.nextLine();
        }
        System.out.println("Bienvenido al sistema!");
        scanner.close();
    }
}