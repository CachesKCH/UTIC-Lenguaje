import java.util.Scanner;

public class SumaProducto {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int num1, num2, suma, producto;
        System.out.println("Ingrese primer numero: ");
        num1 = leer.nextInt();
        System.out.println("Ingrese segundo numero: ");
        num2 = leer.nextInt();
        suma = num1 + num2;
        producto = num1 * num2;
        System.out.println("Resultado de la suma es " + suma);
        System.out.println("Resultado de la multiplicacion es " + producto);
        leer.close();
    }
}