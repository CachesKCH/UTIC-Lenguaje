/**
 * @author GUSTAVO DOMINGUEZ
 * 
 */

package clases;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.List;
import java.util.StringJoiner;

public class RecursosHumanos {

    private String codigo;
    private String nombreApellido;
    private String cargo;
    private String especialidad;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void crearArchivoRecursosHumanos() {
        try {
            File objetoArchivo = new File("RecursosHumanos.txt");
            if (objetoArchivo.createNewFile()) {
                JOptionPane.showMessageDialog(null, "Se ha creado correctamente el archivo: " + objetoArchivo.getName());
            } else {
                JOptionPane.showMessageDialog(null, "El archivo ya existe");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al crear el archivo");
        }
    }

    public void agregarRegistrosRecursosHumanos() {
        try {
            FileWriter fw = new FileWriter("RecursosHumanos.txt", true);

            fw.write(getCodigo());
            fw.write(",");
            fw.write(getNombreApellido());
            fw.write(",");
            fw.write(getCargo());
            fw.write(",");
            fw.write(getEspecialidad());
            fw.write("\n");
            fw.close();

            JOptionPane.showMessageDialog(null, "Se registró correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar" + e.toString());
        }
    }

    public void mostrarTotalRecursosHumanos(JTable tablaTotalRecursosHumanos) {
        String nombreArchivo = "RecursosHumanos.txt";
        File file = new File(nombreArchivo);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String primeraLinea = br.readLine().trim();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Codigo");
            model.addColumn("NombreApellido");
            model.addColumn("Cargo");
            model.addColumn("Especialidad");

            tablaTotalRecursosHumanos.setModel(model);

            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] datarow = line.split(",");
                model.addRow(datarow);
                tablaTotalRecursosHumanos.setModel(model);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error" + e.toString());
        }
    }

    public void seleccionarRecursosHumanos(JTable tablaRecursosHumanos) {
        try {
            int fila = tablaRecursosHumanos.getSelectedRow();

            if (fila >= 0) {
                setCodigo(tablaRecursosHumanos.getValueAt(fila, 0).toString());
                setNombreApellido(tablaRecursosHumanos.getValueAt(fila, 1).toString());
                setCargo(tablaRecursosHumanos.getValueAt(fila, 2).toString());
                setEspecialidad(tablaRecursosHumanos.getValueAt(fila, 3).toString());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error" + e.toString());
        }
    }

public void EliminarRecursosHumanos (JTable tablaRecursosHumanos, JTextField codigo) {
	
	//Eliminacion visual de la tabla
	DefaultTableModel model = (DefaultTableModel)tablaRecursosHumanos.getModel();
	
	for (int i = 0; i < model.getRowCount(); i++) {
		
		if(((String)model.getValueAt(i, 0)).equals(codigo.getText())) {	
			model.removeRow(i);
			break;
			
		}
	}

	//Limpieza del archivo .txt
	
	try {
		PrintWriter writer = new PrintWriter("Recursos Humanos.txt");
		writer.print("");
		writer.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
	}
	
	//Creaci�n de los nuevos registros luego de la eliminaci�n
	
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("RecursosHumanos.txt")))) {
		StringJoiner joiner = new StringJoiner(",");
		
		for (int col = 0; col < tablaRecursosHumanos.getColumnCount(); col++) {
			joiner.add(tablaRecursosHumanos.getColumnName(col));
		}
		
		System.out.println(joiner.toString());
		bw.write(joiner.toString());
		bw.newLine();
		
		for (int row = 0; row < tablaRecursosHumanos.getRowCount(); row++) {
			 joiner = new StringJoiner(",");		
			for (int col = 0; col < tablaRecursosHumanos.getColumnCount(); col++) {
				
				Object obj = tablaRecursosHumanos.getValueAt(row, col);
				String value = obj == null ? "null" :obj.toString();
				joiner.add(value);
				
			}
			
			
			bw.write(joiner.toString());
			bw.newLine();
			JOptionPane.showMessageDialog(null, "Se elimino correctamente");
		}

		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Ocurrio un error");
	}
	
	
	
}

public void EditarRecursosHumanos(JTable tablaRecursosHumanos) {
	
	//Limpieza del archivo .txt
	
		try {
			PrintWriter writer = new PrintWriter("RecursosHumanos.txt");
			writer.print("");
			writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ocurrio un problema"+ e.toString());
		}
		
		//Creaci�n de los nuevos registros luego de la eliminaci�n
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("RecursosHumanos.txt")))) {
			StringJoiner joiner = new StringJoiner(",");
			for (int col = 0; col < tablaRecursosHumanos.getColumnCount(); col++) {
				joiner.add(tablaRecursosHumanos.getColumnName(col));
			}			
			System.out.println(joiner.toString());
			bw.write(joiner.toString());
			bw.newLine();			
			for (int row = 0; row < tablaRecursosHumanos.getRowCount(); row++) {
				joiner = new StringJoiner(",");
				for (int col = 0; col < tablaRecursosHumanos.getColumnCount(); col++) {					
					Object obj = tablaRecursosHumanos.getValueAt(row, col);
					String value = obj == null ? "null" :obj.toString();
					joiner.add(value);					
				}			
				System.out.println(joiner.toString());
				bw.write(joiner.toString());
				bw.newLine();
				JOptionPane.showMessageDialog(null, "Se modifico correctamente");
			}		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error");
		}		
}
}