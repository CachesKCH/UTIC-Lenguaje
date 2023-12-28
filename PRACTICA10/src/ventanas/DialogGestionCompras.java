/**
 * @author GUSTAVO DOMINGUEZ
 * 
 */

package ventanas;

import clases.Compras;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogGestionCompras extends JDialog {
    private JTextField txtCodigoCompra;
    private JTextField txtNombreArticulo;
    private JTextField txtDescripcionCompra;
    private JTextField txtPrecioCompra;
    private JTable tbListaCompras;
    private Compras compras;

    public static void main(String[] args) {
        try {
            DialogGestionCompras dialog = new DialogGestionCompras();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DialogGestionCompras() {
        setTitle("GESTION DE COMPRAS");
        setBounds(100, 100, 750, 330);
        getContentPane().setLayout(null);

        compras = new Compras();
        compras.crearArchivoCompras(); // Asegura la creación del archivo

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Datos de Compra", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(10, 55, 239, 260);
        getContentPane().add(panel);
        panel.setLayout(null);

        txtCodigoCompra = new JTextField();
        txtCodigoCompra.setBounds(132, 24, 86, 20);
        panel.add(txtCodigoCompra);
        txtCodigoCompra.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Codigo");
        lblNewLabel_3.setBounds(10, 27, 46, 14);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Nombre Articulo");
        lblNewLabel_4.setBounds(10, 68, 112, 14);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Descripción");
        lblNewLabel_5.setBounds(10, 106, 112, 14);
        panel.add(lblNewLabel_5);

        txtNombreArticulo = new JTextField();
        txtNombreArticulo.setBounds(132, 65, 86, 20);
        panel.add(txtNombreArticulo);
        txtNombreArticulo.setColumns(10);

        txtDescripcionCompra = new JTextField();
        txtDescripcionCompra.setBounds(132, 103, 86, 20);
        panel.add(txtDescripcionCompra);
        txtDescripcionCompra.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Precio");
        lblNewLabel_6.setBounds(10, 143, 112, 14);
        panel.add(lblNewLabel_6);

        txtPrecioCompra = new JTextField();
        txtPrecioCompra.setBounds(132, 140, 86, 20);
        panel.add(txtPrecioCompra);
        txtPrecioCompra.setColumns(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.Compras objetoCompras = new clases.Compras();
                objetoCompras.setCodigoCompra(txtCodigoCompra.getText());
                objetoCompras.setNombreArticulo(txtNombreArticulo.getText());
                objetoCompras.setDescripcionCompra(txtDescripcionCompra.getText());
                objetoCompras.setPrecioCompra(txtPrecioCompra.getText());
                objetoCompras.agregarRegistrosCompras();
                txtCodigoCompra.setText("");
                txtNombreArticulo.setText("");
                txtDescripcionCompra.setText("");
                txtPrecioCompra.setText("");
                objetoCompras.mostrarTotalCompras(tbListaCompras);
            }
        });
        btnGuardar.setBounds(10, 168, 208, 29);
        panel.add(btnGuardar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                if (tbListaCompras.getSelectedRow() >= 0) {
                    objetoRecursosHumanos.EditarRecursosHumanos(tbListaCompras);
                    objetoRecursosHumanos.mostrarTotalRecursosHumanos(tbListaCompras);
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
				objetoRecursosHumanos.EliminarRecursosHumanos(tbListaCompras, txtCodigoCompra);
			}
        });
        btnEliminar.setBounds(119, 200, 99, 23);
        panel.add(btnEliminar);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Lista de Compras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(275, 54, 430, 215);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 30, 410, 175);
        panel_1.add(scrollPane);

        tbListaCompras = new JTable();
        scrollPane.setViewportView(tbListaCompras);

        JButton btnCrearArchivoCompra = new JButton("Crear Archivo de Compras");
        btnCrearArchivoCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.Compras objetoCompras = new clases.Compras();
                objetoCompras.crearArchivoCompras();
            }
        });
        btnCrearArchivoCompra.setBounds(10, 21, 255, 23);
        getContentPane().add(btnCrearArchivoCompra);

        JButton btnMostrarCompras = new JButton("Mostrar Compras");
        btnMostrarCompras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.Compras objetoCompras = new clases.Compras();
                objetoCompras.mostrarTotalCompras(tbListaCompras);
            }
        });
        btnMostrarCompras.setBounds(275, 21, 200, 23);
        getContentPane().add(btnMostrarCompras);

        JButton btnSeleccionar = new JButton("Seleccionar Compra");
        btnSeleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.Compras objetoCompras = new clases.Compras();
                objetoCompras.seleccionarCompra(tbListaCompras);
                txtCodigoCompra.setText(objetoCompras.getCodigoCompra());
                txtNombreArticulo.setText(objetoCompras.getNombreArticulo());
                txtDescripcionCompra.setText(objetoCompras.getDescripcionCompra());
                txtPrecioCompra.setText(objetoCompras.getPrecioCompra());
            }
        });
        btnSeleccionar.setBounds(480, 20, 220, 23);
        getContentPane().add(btnSeleccionar);
    }
}
