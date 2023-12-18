/**
 * AppEstudiantePersona
 * 
 * @author GUSTAVO DOMINGUEZ
 */
public class AppEstudiantePersona {

    public static void main(String[] args) {
        Estudiante e = new Estudiante("Luis Garcia", 20);
        Persona p = new Persona("Marta Gomez", 20);

        e.mostrarDatos();
        p.mostrarDatos();
    }
}