
/**
 * 
 * @author GUSTAVO DOMINGUEZ
 */

import javax.swing.*;

public class Formulario03 extends JFrame {
    private JLabel label1, label2;

    public Formulario03() {
        setLayout(null);
        label1 = new JLabel("Sistema de Facturación.");
        label1.setBounds(10, 20, 300, 30);
        add(label1);
        label2 = new JLabel("Vesion 1.0");
        label2.setBounds(10, 100, 100, 30);
        add(label2);
    }

    public static void main(String[] ar) {
        Formulario03 formulario1 = new Formulario03();
        formulario1.setBounds(0, 0, 300, 200);
        formulario1.setResizable(false);
        formulario1.setVisible(true);
        formulario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}