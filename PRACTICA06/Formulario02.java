
/**
 * 
 * @author GUSTAVO DOMINGUEZ
 */

import javax.swing.*;

public class Formulario02 extends JFrame {
    public Formulario02() {
        setLayout(null);
    }

    public static void main(String[] ar) {
        Formulario02 formulario1 = new Formulario02();
        formulario1.setBounds(10, 20, 400, 300);
        formulario1.setVisible(true);
        formulario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}