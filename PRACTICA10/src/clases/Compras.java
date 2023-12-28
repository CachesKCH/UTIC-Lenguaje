/**
 * @author GUSTAVO DOMINGUEZ
 * 
 */

package clases;

import java.io.*;
import java.util.StringJoiner;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Compras {

    private String codigoCompra;
    private String nombreArticulo;
    private String descripcionCompra;
    private String precioCompra;
    
    public String getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(String codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getDescripcionCompra() {
        return descripcionCompra;
    }

    public void setDescripcionCompra(String descripcionCompra) {
        this.descripcionCompra = descripcionCompra;
    }

    public String getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void crearArchivoCompras() {
        try {
            File objetoArchivo = new File("Compras.txt");
            if (objetoArchivo.createNewFile()) {
                JOptionPane.showMessageDialog(null, "Se ha creado correctamente el archivo: " + objetoArchivo.getName());
            } else {
                JOptionPane.showMessageDialog(null, "El archivo ya existe");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al crear el archivo");
        }
    }

    public void agregarRegistrosCompras() {
        try (FileWriter fw = new FileWriter("Compras.txt", true)) {
            fw.write(getCodigoCompra());
            fw.write(",");
            fw.write(getNombreArticulo());
            fw.write(",");
            fw.write(getDescripcionCompra());
            fw.write(",");
            fw.write(getPrecioCompra());
            fw.write("\n");
            JOptionPane.showMessageDialog(null, "Se registró correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar" + e.toString());
        }
    }

    public void mostrarTotalCompras(JTable tablaTotalCompras) {
        String nombreArchivo = "Compras.txt";
        File file = new File(nombreArchivo);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String primeraLinea = br.readLine().trim();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Codigo");
            model.addColumn("NombreArticulo");
            model.addColumn("DescripcionCompra");
            model.addColumn("PrecioCompra");
            tablaTotalCompras.setModel(model);

            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);
                tablaTotalCompras.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error" + e.toString());
        }
    }

    public void seleccionarCompra(JTable tablaCompras) {
        try {
            int fila = tablaCompras.getSelectedRow();
            if (fila >= 0) {
                setCodigoCompra(tablaCompras.getValueAt(fila, 0).toString());
                setNombreArticulo(tablaCompras.getValueAt(fila, 1).toString());
                setDescripcionCompra(tablaCompras.getValueAt(fila, 2).toString());
                setPrecioCompra(tablaCompras.getValueAt(fila, 3).toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error" + e.toString());
        }
    }

    public void eliminarCompra(JTable tablaCompras, JTextField codigoCompra) {
	
	//Eliminacion visual de la tabla
	DefaultTableModel model = (DefaultTableModel)tablaCompras.getModel();
	
	for (int i = 0; i < model.getRowCount(); i++) {
		
		if(((String)model.getValueAt(i, 0)).equals(codigoCompra.getText())) {	
			model.removeRow(i);
			break;
			
		}
	}

	//Limpieza del archivo .txt
	
	try {
		PrintWriter writer = new PrintWriter("Compras.txt");
		writer.print("");
		writer.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
	}
	
	//Creaci�n de los nuevos registros luego de la eliminaci�n
	
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Compras.txt")))) {
		StringJoiner joiner = new StringJoiner(",");
		
		for (int col = 0; col < tablaCompras.getColumnCount(); col++) {
			joiner.add(tablaCompras.getColumnName(col));
		}
		
		System.out.println(joiner.toString());
		bw.write(joiner.toString());
		bw.newLine();
		
		for (int row = 0; row < tablaCompras.getRowCount(); row++) {
			 joiner = new StringJoiner(",");		
			for (int col = 0; col < tablaCompras.getColumnCount(); col++) {
				
				Object obj = tablaCompras.getValueAt(row, col);
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

    public void editarCompra(JTable tablaCompras) {
	
	//Limpieza del archivo .txt
	
		try {
			PrintWriter writer = new PrintWriter("Compras.txt");
			writer.print("");
			writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ocurrio un problema"+ e.toString());
		}
		
		//Creaci�n de los nuevos registros luego de la eliminaci�n
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Compras.txt")))) {
			StringJoiner joiner = new StringJoiner(",");
			for (int col = 0; col < tablaCompras.getColumnCount(); col++) {
				joiner.add(tablaCompras.getColumnName(col));
			}
			
			System.out.println(joiner.toString());
			bw.write(joiner.toString());
			bw.newLine();
			
			for (int row = 0; row < tablaCompras.getRowCount(); row++) {
				joiner = new StringJoiner(",");
				for (int col = 0; col < tablaCompras.getColumnCount(); col++) {
					
					Object obj = tablaCompras.getValueAt(row, col);
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