/**
 * @author GUSTAVO DOMINGUEZ
 * 
 */

package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {
    
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MenuPrincipal() {
        setTitle("MENU PRINCIPAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 548, 255);
        contentPane = new JPanel();
        contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnNewButton = new JButton("Medicamentos");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogGestionMedicamentos objetoDialog = new DialogGestionMedicamentos();
                objetoDialog.setVisible(rootPaneCheckingEnabled);
            }
        });
        btnNewButton.setBounds(10, 30, 155, 55);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Recursos Humanos");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogGestionRecursosHumanos objetoDialog = new DialogGestionRecursosHumanos();
                objetoDialog.setVisible(rootPaneCheckingEnabled);
            }
        });
        btnNewButton_1.setBounds(175, 30, 155, 55);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_3 = new JButton("Compras");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogGestionCompras objetoDialog = new DialogGestionCompras();
                objetoDialog.setVisible(rootPaneCheckingEnabled);
            }
        });
        btnNewButton_3.setBounds(342, 30, 155, 55);
        contentPane.add(btnNewButton_3);
        
        JButton btnNewButton_6 = new JButton("Cerrar");
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_6.setBounds(175, 120, 155, 55);
        contentPane.add(btnNewButton_6);
    }
    
}
