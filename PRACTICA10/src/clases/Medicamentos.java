/**
 * @author GUSTAVO DOMINGUEZ
 * 
 */



package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringJoiner;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Medicamentos {
	
String codigoMedicamento;
String nombreMedicamento;
String tipoMedicamento;

public String getCodigoMedicamento() {
	return codigoMedicamento;
}
public void setCodigoMedicamento(String codigoMedicamento) {
	this.codigoMedicamento = codigoMedicamento;
}
public String getNombreMedicamento() {
	return nombreMedicamento;
}
public void setNombreMedicamento(String nombreMedicamento) {
	this.nombreMedicamento = nombreMedicamento;
}
public String getTipoMedicamento() {
	return tipoMedicamento;
}
public void setTipoMedicamento(String tipoMedicamento) {
	this.tipoMedicamento = tipoMedicamento;
}

// creación del fichero que guarda los datos 

public void crearArchivoMedicamentos() {
	try {
		File objetoArchivo = new File("Medicamentos.txt");
		if(objetoArchivo.createNewFile()) {
			JOptionPane.showMessageDialog(null,"Se ha creado correctamente el archivo: "+  objetoArchivo.getName());
		}
		else {
			JOptionPane.showMessageDialog(null, "El archivo ya existe");
		}
		
	} catch (Exception e) {
		System.out.println("Ocurrió un error al crear el archivo");
		
	}
}


public void agregarRegistrosMedicamentos() {
	try {
		FileWriter fw = new FileWriter("Medicamentos.txt",true);
		
		
		fw.write(getCodigoMedicamento());
		fw.write(",");
		fw.write(getNombreMedicamento());
		fw.write(",");
		fw.write(getTipoMedicamento());
		fw.write("\n");
		fw.close();
		
		JOptionPane.showMessageDialog(null,"Se registr� correctamente");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrió un error al registrar" + e.toString());
	}
}

public void MostrarTotalMedicamentos(JTable tablaTotalMedicamentos) {
	
	String nombreArchivo = "Medicamentos.txt";
	
	File file = new File(nombreArchivo);
	
	try {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String primeraLinea = br.readLine().trim();
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Codigo");
		model.addColumn("NombreMedicamento");
		model.addColumn("TipoMedicamento");
		
		tablaTotalMedicamentos.setModel(model);
		
		Object[] tableLines = br.lines().toArray();
		
		for (int i = 0; i < tableLines.length; i++) {
			
			String line = tableLines[i].toString().trim();
			String[] datarow= line.split(",");
			model.addRow(datarow);
			tablaTotalMedicamentos.setModel(model);
		}
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
		
	}
}

public void seleccionarMedicamentos(JTable tablaMedicamentos) {
	
	try {
		
		int  fila = tablaMedicamentos.getSelectedRow();
		
		if (fila>=0) {
			
			setCodigoMedicamento(tablaMedicamentos.getValueAt(fila, 0).toString());
			setNombreMedicamento(tablaMedicamentos.getValueAt(fila, 1).toString());
			setTipoMedicamento(tablaMedicamentos.getValueAt(fila, 2).toString());
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
	}
	
}

public void EliminarMedicamentos (JTable tablaMedicamentos, JTextField codigoMedicamento) {
	
	//Eliminaci�n visual de la tabla
	DefaultTableModel model = (DefaultTableModel)tablaMedicamentos.getModel();
	
	for (int i = 0; i < model.getRowCount(); i++) {
		
		if(((String)model.getValueAt(i, 0)).equals(codigoMedicamento.getText())) {	
			model.removeRow(i);
			break;
			
		}
	}
	//Limpieza del archivo .txt
	
	try {
		PrintWriter writer = new PrintWriter("Medicamentos.txt");
		writer.print("");
		writer.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
	}
	
	//Creaci�n de los nuevos registros luego de la eliminaci�n
	
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Medicamentos.txt")))) {
		StringJoiner joiner = new StringJoiner(",");
		
		for (int col = 0; col < tablaMedicamentos.getColumnCount(); col++) {
			joiner.add(tablaMedicamentos.getColumnName(col));
		}
		
		System.out.println(joiner.toString());
		bw.write(joiner.toString());
		bw.newLine();
		
		for (int row = 0; row < tablaMedicamentos.getRowCount(); row++) {
			 joiner = new StringJoiner(",");		
			for (int col = 0; col < tablaMedicamentos.getColumnCount(); col++) {
				
				Object obj = tablaMedicamentos.getValueAt(row, col);
				String value = obj == null ? "null" :obj.toString();
				joiner.add(value);
				
			}
			
			
			bw.write(joiner.toString());
			bw.newLine();
			JOptionPane.showMessageDialog(null, "Se elimin� correctamente");
		}

		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Ocurrio un error");
	}
	
	
	
}

public void EditarMedicamentos(JTable tablaMedicamentos) {
	
	//Limpieza del archivo .txt
	
		try {
			PrintWriter writer = new PrintWriter("Medicamentos.txt");
			writer.print("");
			writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
		}
		
		//Creaci�n de los nuevos registros luego de la eliminaci�n
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Medicamentos.txt")))) {
			StringJoiner joiner = new StringJoiner(",");
			for (int col = 0; col < tablaMedicamentos.getColumnCount(); col++) {
				joiner.add(tablaMedicamentos.getColumnName(col));
			}
			
			System.out.println(joiner.toString());
			bw.write(joiner.toString());
			bw.newLine();
			
			for (int row = 0; row < tablaMedicamentos.getRowCount(); row++) {
				joiner = new StringJoiner(",");
				for (int col = 0; col < tablaMedicamentos.getColumnCount(); col++) {
					
					Object obj = tablaMedicamentos.getValueAt(row, col);
					String value = obj == null ? "null" :obj.toString();
					joiner.add(value);
					
				}
				
				System.out.println(joiner.toString());
				bw.write(joiner.toString());
				bw.newLine();
				JOptionPane.showMessageDialog(null, "Se modific� correctamente");
			}

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error");
		}
		
}


}
