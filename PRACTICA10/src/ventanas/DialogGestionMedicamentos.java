/**
 * @author GUSTAVO DOMINGUEZ
 * 
 */

package ventanas;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogGestionMedicamentos extends JDialog {
	private JTextField txtCodigoMedicamentos;
	private JTextField txtNombreMedicamento;
	private JTextField txtTipoMedicamento;
	private JTable tbListaMedicamentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogGestionMedicamentos dialog = new DialogGestionMedicamentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogGestionMedicamentos() {
            setTitle("GESTION DE MEDICAMENTOS");
		setBounds(100, 100, 633, 313);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos de Medicamentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 55, 239, 214);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtCodigoMedicamentos = new JTextField();
		txtCodigoMedicamentos.setBounds(132, 24, 86, 20);
		panel.add(txtCodigoMedicamentos);
		txtCodigoMedicamentos.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Codigo");
		lblNewLabel_3.setBounds(10, 27, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre Medicamento");
		lblNewLabel_4.setBounds(10, 68, 112, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo Medicamento");
		lblNewLabel_5.setBounds(10, 106, 112, 14);
		panel.add(lblNewLabel_5);
		
		txtNombreMedicamento = new JTextField();
		txtNombreMedicamento.setBounds(132, 65, 86, 20);
		panel.add(txtNombreMedicamento);
		txtNombreMedicamento.setColumns(10);
		
		txtTipoMedicamento = new JTextField();
		txtTipoMedicamento.setBounds(132, 103, 86, 20);
		panel.add(txtTipoMedicamento);
		txtTipoMedicamento.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Medicamentos objetoMedicamentos = new clases.Medicamentos();
				objetoMedicamentos.setCodigoMedicamento(txtCodigoMedicamentos.getText());
				objetoMedicamentos.setNombreMedicamento(txtNombreMedicamento.getText());
				objetoMedicamentos.setTipoMedicamento(txtTipoMedicamento.getText());
				objetoMedicamentos.agregarRegistrosMedicamentos();
			}
		});
		btnGuardar.setBounds(10, 140, 99, 23);
		panel.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Medicamentos objetoMedicamentos = new clases.Medicamentos();
				objetoMedicamentos.EditarMedicamentos(tbListaMedicamentos);
			}
		});
		btnEditar.setBounds(109, 140, 112, 23);
		panel.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Medicamentos objetoMedicamentos = new clases.Medicamentos();
				objetoMedicamentos.EliminarMedicamentos(tbListaMedicamentos, txtCodigoMedicamentos);
			}
		});
		btnEliminar.setBounds(10, 168, 208, 29);
		panel.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lista de Medicamentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(275, 54, 338, 177);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 318, 136);
		panel_1.add(scrollPane);
		
		tbListaMedicamentos = new JTable();
		scrollPane.setViewportView(tbListaMedicamentos);
		
		JButton btnCrearArchivoMedicamentos = new JButton("Crear Archivo de Medicamentos");
		btnCrearArchivoMedicamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Medicamentos objetoMedicamentos= new clases.Medicamentos();
				objetoMedicamentos.crearArchivoMedicamentos();
			}
		});
		btnCrearArchivoMedicamentos.setBounds(10, 21, 239, 23);
		getContentPane().add(btnCrearArchivoMedicamentos);
		
		JButton btnMostrarMedicamentos = new JButton("Mostrar Medicamentos");
		btnMostrarMedicamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Medicamentos objetoMedicamentos = new clases.Medicamentos();
				objetoMedicamentos.MostrarTotalMedicamentos(tbListaMedicamentos);
			}
		});
		btnMostrarMedicamentos.setBounds(275, 21, 158, 23);
		getContentPane().add(btnMostrarMedicamentos);
		
		JButton btnSeleccionar = new JButton("Seleccionar Medicamento");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Medicamentos objetoMedicamentos = new clases.Medicamentos();
				
				objetoMedicamentos.seleccionarMedicamentos(tbListaMedicamentos);
				txtCodigoMedicamentos.setText(objetoMedicamentos.getCodigoMedicamento());
				txtNombreMedicamento.setText(objetoMedicamentos.getNombreMedicamento());
				txtTipoMedicamento.setText(objetoMedicamentos.getTipoMedicamento());
			}
		});
		btnSeleccionar.setBounds(443, 20, 164, 23);
		getContentPane().add(btnSeleccionar);
	}
}
