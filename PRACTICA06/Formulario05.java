
/**
 * 
 * @author GUSTAVO DOMINGUEZ
 */

import javax.swing.*;
import java.awt.event.*;

public class Formulario05 extends JFrame implements ActionListener {
    private JTextField textfield1;
    private JLabel label1;
    private JButton boton1;

    public Formulario05() {
        setLayout(null);
        label1 = new JLabel("Usuario:");
        label1.setBounds(10, 10, 100, 30);
        add(label1);
        textfield1 = new JTextField();
        textfield1.setBounds(120, 10, 150, 20);
        add(textfield1);
        boton1 = new JButton("Aceptar");
        boton1.setBounds(10, 80, 100, 30);
        add(boton1);
        boton1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            String cad = textfield1.getText();
            setTitle(cad);
        }
    }

    public static void main(String[] ar) {
        Formulario05 formulario1 = new Formulario05();
        formulario1.setBounds(0, 0, 350, 170);
        formulario1.setVisible(true);
        formulario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}