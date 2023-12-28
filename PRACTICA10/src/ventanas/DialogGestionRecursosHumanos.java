/**
 * @author GUSTAVO DOMINGUEZ
 * 
 */

package ventanas;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogGestionRecursosHumanos extends JDialog {
    private JTextField txtCodigoRecursosHumanos;
    private JTextField txtNombreApellido;
    private JTextField txtCargo;
    private JTextField txtEspecialidad;
    private JTable tbListaRecursosHumanos;

    public static void main(String[] args) {
        try {
            DialogGestionRecursosHumanos dialog = new DialogGestionRecursosHumanos();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DialogGestionRecursosHumanos() {
setTitle("GESTION DE RECURSOS HUMANOS");
setBounds(100, 100, 750, 330);
getContentPane().setLayout(null);

JPanel panel = new JPanel();
panel.setBorder(new TitledBorder(null, "Datos de Recursos Humanos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
panel.setBounds(10, 55, 239, 260);
getContentPane().add(panel);
panel.setLayout(null);

txtCodigoRecursosHumanos = new JTextField();
txtCodigoRecursosHumanos.setBounds(132, 24, 86, 20);
panel.add(txtCodigoRecursosHumanos);
txtCodigoRecursosHumanos.setColumns(10);

JLabel lblNewLabel_3 = new JLabel("Codigo");
lblNewLabel_3.setBounds(10, 27, 46, 14);
panel.add(lblNewLabel_3);

JLabel lblNewLabel_4 = new JLabel("Nombre Apellido");
lblNewLabel_4.setBounds(10, 68, 112, 14);
panel.add(lblNewLabel_4);

JLabel lblNewLabel_5 = new JLabel("Cargo");
lblNewLabel_5.setBounds(10, 106, 112, 14);
panel.add(lblNewLabel_5);

txtNombreApellido = new JTextField();
txtNombreApellido.setBounds(132, 65, 86, 20);
panel.add(txtNombreApellido);
txtNombreApellido.setColumns(10);

txtCargo = new JTextField();
txtCargo.setBounds(132, 103, 86, 20);
panel.add(txtCargo);
txtCargo.setColumns(10);

JLabel lblNewLabel_6 = new JLabel("Especialidad");
lblNewLabel_6.setBounds(10, 143, 112, 14);
panel.add(lblNewLabel_6);

txtEspecialidad = new JTextField();
txtEspecialidad.setBounds(132, 140, 86, 20);
panel.add(txtEspecialidad);
txtEspecialidad.setColumns(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                objetoRecursosHumanos.setCodigo(txtCodigoRecursosHumanos.getText());
                objetoRecursosHumanos.setNombreApellido(txtNombreApellido.getText());
                objetoRecursosHumanos.setCargo(txtCargo.getText());
                objetoRecursosHumanos.setEspecialidad(txtEspecialidad.getText());
                objetoRecursosHumanos.agregarRegistrosRecursosHumanos();
                txtCodigoRecursosHumanos.setText("");
                txtNombreApellido.setText("");
                txtCargo.setText("");
                txtEspecialidad.setText("");
                objetoRecursosHumanos.mostrarTotalRecursosHumanos(tbListaRecursosHumanos);
            }
        });
        btnGuardar.setBounds(10, 168, 208, 29);
        panel.add(btnGuardar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                if (tbListaRecursosHumanos.getSelectedRow() >= 0) {
                    objetoRecursosHumanos.EditarRecursosHumanos(tbListaRecursosHumanos);
                    objetoRecursosHumanos.mostrarTotalRecursosHumanos(tbListaRecursosHumanos);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila para editar.");
                }
            }
        });
        btnEditar.setBounds(10, 200, 99, 23);
        panel.add(btnEditar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
				objetoRecursosHumanos.EliminarRecursosHumanos(tbListaRecursosHumanos, txtCodigoRecursosHumanos);
			}
		
        });
        btnEliminar.setBounds(119, 200, 99, 23);
        panel.add(btnEliminar);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Lista de Recursos Humanos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(275, 54, 430, 215);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 30, 410, 175);
        panel_1.add(scrollPane);

        tbListaRecursosHumanos = new JTable();
        scrollPane.setViewportView(tbListaRecursosHumanos);

        JButton btnCrearArchivoRecursosHumanos = new JButton("Crear Archivo de Recursos Humanos");
        btnCrearArchivoRecursosHumanos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                objetoRecursosHumanos.crearArchivoRecursosHumanos();
            }
        });
        btnCrearArchivoRecursosHumanos.setBounds(10, 21, 255, 23);
        getContentPane().add(btnCrearArchivoRecursosHumanos);

        JButton btnMostrarRecursosHumanos = new JButton("Mostrar Recursos Humanos");
        btnMostrarRecursosHumanos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                objetoRecursosHumanos.mostrarTotalRecursosHumanos(tbListaRecursosHumanos);
            }
        });
        btnMostrarRecursosHumanos.setBounds(275, 21, 200, 23);
        getContentPane().add(btnMostrarRecursosHumanos);

        JButton btnSeleccionar = new JButton("Seleccionar Recurso Humano");
        btnSeleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                objetoRecursosHumanos.seleccionarRecursosHumanos(tbListaRecursosHumanos);
                txtCodigoRecursosHumanos.setText(objetoRecursosHumanos.getCodigo());
                txtNombreApellido.setText(objetoRecursosHumanos.getNombreApellido());
                txtCargo.setText(objetoRecursosHumanos.getCargo());
                txtEspecialidad.setText(objetoRecursosHumanos.getEspecialidad());
            }
        });
        btnSeleccionar.setBounds(480, 20, 220, 23);
        getContentPane().add(btnSeleccionar);
    }
}


