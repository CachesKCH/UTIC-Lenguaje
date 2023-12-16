public class Practica3Ejercicio21 {
    public static void main(String[] args) {
        int tabla, result;
        // Bucle 1
        for (tabla = 1; tabla < 11; tabla++) {
            System.out.println("Imprimiendo la tabla del: " + tabla);
            // Bucle 2
            for (int i = 1; i < 11; i++) {
                result = tabla * i;
                System.out.println(tabla + " x " + i + " = " + result);
            }
        }
    }
}