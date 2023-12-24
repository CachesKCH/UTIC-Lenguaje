import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author GUSTAVO DOMINGUEZ
 * 
 */

class calculadora implements ActionListener {

    double numero, respuesta;
    int calculo;

    JFrame marco;
    JLabel etiqueta = new JLabel();
    JTextField campoTexto = new JTextField();
    JRadioButton buttonON = new JRadioButton("ON");
    JRadioButton buttonOFF = new JRadioButton("OFF");
    JButton buttonCero = new JButton("0");
    JButton buttonUno = new JButton("1");
    JButton buttonDos = new JButton("2");
    JButton buttonTres = new JButton("3");
    JButton buttonCuatro = new JButton("4");
    JButton buttonCinco = new JButton("5");
    JButton buttonSeis = new JButton("6");
    JButton buttonSiete = new JButton("7");
    JButton buttonOcho = new JButton("8");
    JButton buttonNueve = new JButton("9");
    JButton buttonPunto = new JButton(".");
    JButton buttonLimpiar = new JButton("C");
    JButton buttonBorrar = new JButton("DEL");
    JButton buttonIgual = new JButton("=");
    JButton buttonMulti = new JButton("x");
    JButton buttonDiv = new JButton("+");
    JButton buttonSuma = new JButton("+");
    JButton buttonResta = new JButton("-");
    JButton buttonCuadrado = new JButton("x\u00B2");
    JButton buttonReciprocal = new JButton("1/x");
    JButton buttonRaiz = new JButton("\u221A");

    // Colores para la interfaz de usuario

    Color rosa = new Color(255, 0, 149);
    Color amarillo = new Color(212, 255, 0);
    Color verde = new Color(6, 214, 160);
    Color pastel = new Color(7, 59, 76);

    calculadora() {
        prepararGUI();
        addComponentes();
        addActionEvent();
    }

    // Método para preparar la GUI
    public void prepararGUI() {
        marco = new JFrame();
        marco.setTitle("Calculadora LP1-23");
        marco.setSize(300, 490);
        marco.getContentPane().setLayout(null);
        marco.getContentPane().setBackground(amarillo);
        marco.setResizable(false);
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Método para agregar todos los componentes como los números y símbolos de
    // todos los operaciones a la GUI
    public void addComponentes() {
        etiqueta.setBounds(250, 0, 50, 50);
        etiqueta.setForeground(Color.black);
        marco.add(etiqueta);

        campoTexto.setBounds(18, 49, 270, 48);
        campoTexto.setFont(new Font("Arial", Font.BOLD, 29));
        campoTexto.setEditable(false);
        campoTexto.setHorizontalAlignment(SwingConstants.RIGHT);
        marco.add(campoTexto);

        buttonON.setBounds(10, 95, 60, 40);
        buttonON.setSelected(true);
        buttonON.setFont(new Font("Arial", Font.BOLD, 14));
        buttonON.setBackground(amarillo);
        buttonON.setForeground(Color.black);
        marco.add(buttonON);

        buttonOFF.setBounds(10, 120, 60, 48);
        buttonOFF.setSelected(false);
        buttonOFF.setFont(new Font("Arial", Font.BOLD, 14));
        buttonOFF.setBackground(amarillo);
        buttonOFF.setForeground(Color.black);
        marco.add(buttonOFF);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(buttonON);
        buttonGroup.add(buttonOFF);

        buttonSiete.setBounds(10, 230, 60, 40);
        buttonSiete.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSiete.setBackground(pastel);
        buttonSiete.setForeground(Color.white);
        marco.add(buttonSiete);

        buttonOcho.setBounds(80, 230, 60, 40);
        buttonOcho.setFont(new Font("Arial", Font.BOLD, 20));
        buttonOcho.setBackground(pastel);
        buttonOcho.setForeground(Color.white);
        marco.add(buttonOcho);

        buttonNueve.setBounds(150, 230, 60, 40);
        buttonNueve.setFont(new Font("Arial", Font.BOLD, 20));
        buttonNueve.setBackground(pastel);
        buttonNueve.setForeground(Color.white);
        marco.add(buttonNueve);

        buttonCuatro.setBounds(10, 290, 60, 40);
        buttonCuatro.setFont(new Font("Arial", Font.BOLD, 20));
        buttonCuatro.setBackground(pastel);
        buttonCuatro.setForeground(Color.white);
        marco.add(buttonCuatro);

        buttonCinco.setBounds(80, 290, 60, 40);
        buttonCinco.setFont(new Font("Arial", Font.BOLD, 20));
        buttonCinco.setBackground(pastel);
        buttonCinco.setForeground(Color.white);
        marco.add(buttonCinco);

        buttonSeis.setBounds(150, 290, 60, 40);
        buttonSeis.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSeis.setBackground(pastel);
        buttonSeis.setForeground(Color.white);
        marco.add(buttonSeis);

        buttonUno.setBounds(10, 350, 60, 40);
        buttonUno.setFont(new Font("Arial", Font.BOLD, 20));
        buttonUno.setBackground(pastel);
        buttonUno.setForeground(Color.white);
        marco.add(buttonUno);

        buttonDos.setBounds(80, 350, 60, 40);
        buttonDos.setFont(new Font("Arial", Font.BOLD, 20));
        buttonDos.setBackground(pastel);
        buttonDos.setForeground(Color.white);
        marco.add(buttonDos);

        buttonTres.setBounds(150, 350, 60, 40);
        buttonTres.setFont(new Font("Arial", Font.BOLD, 20));
        buttonTres.setBackground(pastel);
        buttonTres.setForeground(Color.white);
        marco.add(buttonTres);

        buttonPunto.setBounds(150, 410, 60, 40);
        buttonPunto.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPunto.setBackground(pastel);
        buttonPunto.setForeground(Color.white);
        marco.add(buttonPunto);

        buttonCero.setBounds(10, 410, 130, 40);
        buttonCero.setFont(new Font("Arial", Font.BOLD, 20));
        buttonCero.setBackground(pastel);
        buttonCero.setForeground(Color.white);
        marco.add(buttonCero);

        buttonIgual.setBounds(220, 350, 60, 100);
        buttonIgual.setFont(new Font("Arial", Font.BOLD, 20));
        buttonIgual.setBackground(verde);
        marco.add(buttonIgual);

        buttonDiv.setBounds(220, 110, 60, 40);
        buttonDiv.setFont(new Font("Arial", Font.BOLD, 20));
        buttonDiv.setBackground(verde);
        marco.add(buttonDiv);

        buttonRaiz.setBounds(10, 170, 60, 40);
        buttonRaiz.setFont(new Font("Arial", Font.BOLD, 18));
        buttonRaiz.setBackground(verde);
        marco.add(buttonRaiz);

        buttonMulti.setBounds(220, 230, 60, 40);
        buttonMulti.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMulti.setBackground(verde);
        marco.add(buttonMulti);

        buttonResta.setBounds(220, 170, 60, 40);
        buttonResta.setFont(new Font("Arial", Font.BOLD, 20));
        buttonResta.setBackground(verde);
        marco.add(buttonResta);

        buttonSuma.setBounds(220, 290, 60, 40);
        buttonSuma.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSuma.setBackground(verde);
        marco.add(buttonSuma);

        buttonCuadrado.setBounds(80, 170, 60, 40);
        buttonCuadrado.setFont(new Font("Arial", Font.BOLD, 20));
        buttonCuadrado.setBackground(verde);
        marco.add(buttonCuadrado);

        buttonReciprocal.setBounds(150, 170, 60, 40);
        buttonReciprocal.setFont(new Font("Arial", Font.BOLD, 15));
        buttonReciprocal.setBackground(verde);
        marco.add(buttonReciprocal);

        buttonBorrar.setBounds(150, 110, 60, 40);
        buttonBorrar.setFont(new Font("Arial", Font.BOLD, 12));
        buttonBorrar.setBackground(rosa);
        buttonBorrar.setForeground(Color.white);
        marco.add(buttonBorrar);

        buttonLimpiar.setBounds(80, 110, 60, 40);
        buttonLimpiar.setFont(new Font("Arial", Font.BOLD, 12));
        buttonLimpiar.setBackground(rosa);
        buttonLimpiar.setForeground(Color.white);
        marco.add(buttonLimpiar);
    }

    // Método para agregar todos los oyentes de acción a los botones.
    public void addActionEvent() {
        buttonON.addActionListener(this);
        buttonOFF.addActionListener(this);
        buttonLimpiar.addActionListener(this);
        buttonBorrar.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonRaiz.addActionListener(this);
        buttonCuadrado.addActionListener(this);
        buttonReciprocal.addActionListener(this);
        buttonResta.addActionListener(this);
        buttonSiete.addActionListener(this);
        buttonOcho.addActionListener(this);
        buttonNueve.addActionListener(this);
        buttonMulti.addActionListener(this);
        buttonCuatro.addActionListener(this);
        buttonCinco.addActionListener(this);
        buttonSeis.addActionListener(this);
        buttonSuma.addActionListener(this);
        buttonUno.addActionListener(this);
        buttonDos.addActionListener(this);
        buttonTres.addActionListener(this);
        buttonIgual.addActionListener(this);
        buttonCero.addActionListener(this);
        buttonPunto.addActionListener(this);
    }

    // Método para agregar todos los metodos escucha a los botones y al marco.
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // Si se selecciona el botón de opción ON, la calculadora está habilitada.
        if (source == buttonON) {
            enable();
        }
        // Si se selecciona el botón de radio OFF, la calculadora se desactiva
        else if (source == buttonOFF) {
            disable();
        }
        // Si se presiona el botón borrar, el campo de texto se borra
        else if (source == buttonLimpiar) {
            etiqueta.setText("");
            campoTexto.setText("");
        }
        // Si se presiona el botón Eliminar, se elimina el último carácter.
        else if (source == buttonBorrar) {
            int length = campoTexto.getText().length(); // Obtener la longitud del campo de texto
            int numero = length - 1; // Obtener el número de caracteres a eliminar
            if (length > 0) { // Si la longitud es mayor que 0, elimine el último carácter.
                StringBuilder back = new StringBuilder(campoTexto.getText());
                back.deleteCharAt(numero);
                campoTexto.setText(back.toString());
            }
            if (campoTexto.getText().endsWith("")) { // Si el campo de texto está vacío, establezca la etiqueta en e
                etiqueta.setText("");
            }
        } else if (source == buttonCero) { // Si se presiona el botón cero, agregue un cero al campo de texto
            if (campoTexto.getText().equals("0")) { // Si el campo de texto es e, no hagas nada.
                return;
            } else { // Si el campo de texto no está vacío, agregue un cero al campo de texto
                campoTexto.setText(campoTexto.getText() + "0");
            }
        }

        // Si se presiona un botón, agrega uno al campo de texto y así sucesivamente
        // para todos los otros botones
        else if (source == buttonUno) {
            campoTexto.setText(campoTexto.getText() + "1");
        } else if (source == buttonDos) {
            campoTexto.setText(campoTexto.getText() + "2");
        } else if (source == buttonTres) {
            campoTexto.setText(campoTexto.getText() + "3");
        } else if (source == buttonCuatro) {
            campoTexto.setText(campoTexto.getText() + "4");
        } else if (source == buttonCinco) {
            campoTexto.setText(campoTexto.getText() + "5");
        } else if (source == buttonSeis) {
            campoTexto.setText(campoTexto.getText() + "6");
        } else if (source == buttonSiete) {
            campoTexto.setText(campoTexto.getText() + "7");
        } else if (source == buttonOcho) {
            campoTexto.setText(campoTexto.getText() + "8");
        } else if (source == buttonNueve) {
            campoTexto.setText(campoTexto.getText() + "9");
        } else if (source == buttonPunto) {
            if (campoTexto.getText().contains(".")) { // If the text field contains a dot, do nothing
                return;
            } else {
                campoTexto.setText(campoTexto.getText() + "."); // If the text field does not contain a dot, add a dot
            }
        }
        // Si se presiona el botón más, agrega uno más al campo de texto y así
        // sucesivamente para todos los botones
        else if (source == buttonSuma) {
            String str = campoTexto.getText();
            numero = Double.parseDouble(campoTexto.getText());
            campoTexto.setText("");
            etiqueta.setText(str + "+");
            calculo = 1;
        } else if (source == buttonResta) {
            String str = campoTexto.getText();
            numero = Double.parseDouble(campoTexto.getText());
            campoTexto.setText("");
            etiqueta.setText(str + "-");
            calculo = 2;
        } else if (source == buttonMulti) {
            String str = campoTexto.getText();
            numero = Double.parseDouble(campoTexto.getText());
            campoTexto.setText("");
            etiqueta.setText(str + "x");
            calculo = 3;
        } else if (source == buttonDiv) {
            String str = campoTexto.getText();
            numero = Double.parseDouble(campoTexto.getText());
            campoTexto.setText("");
            etiqueta.setText(str + "+");
            calculo = 4;
            Double.parseDouble(campoTexto.getText());
        } else if (source == buttonRaiz) {
            numero = Double.parseDouble(campoTexto.getText());
            Double sqrt = Math.sqrt(numero);
            campoTexto.setText(Double.toString(sqrt));
        } else if (source == buttonCuadrado) {
            String str = campoTexto.getText();
            numero = Double.parseDouble(campoTexto.getText());
            double square = Math.pow(numero, 2);
            String string = Double.toString(square);
            if (string.endsWith(".0")) {
                campoTexto.setText(string.replace(".0", ""));
            } else {
            }
            campoTexto.setText(string);
            etiqueta.setText("(raiz)" + str);
        } else if (source == buttonReciprocal) {
            numero = Double.parseDouble(campoTexto.getText());
            double reciprocal = 1 / numero;
            String string = Double.toString(reciprocal);
            if (string.endsWith(".0")) {
                campoTexto.setText(string.replace(".0", ""));
            } else {
                campoTexto.setText(string);
            }
        } else if (source == buttonIgual) {
            switch (calculo) {
                case 1:
                    respuesta = numero + Double.parseDouble(campoTexto.getText());
                    if (Double.toString(respuesta).endsWith(".0")) {
                        campoTexto.setText(Double.toString(respuesta).replace(".0", ""));
                        campoTexto.setText(Double.toString(respuesta));
                    } else {
                    }
                    etiqueta.setText("");
                    break;
                case 2:
                    respuesta = numero - Double.parseDouble(campoTexto.getText());
                    if (Double.toString(respuesta).endsWith(".0")) {
                        campoTexto.setText(Double.toString(respuesta).replace(".0", ""));
                    } else {
                        campoTexto.setText(Double.toString(respuesta));
                    }
                    etiqueta.setText("");
                    break;
                case 3:
                    respuesta = numero * Double.parseDouble(campoTexto.getText());
                    if (Double.toString(respuesta).endsWith(".0")) {
                        campoTexto.setText(Double.toString(respuesta).replace(".0", ""));
                    } else {
                        campoTexto.setText(Double.toString(respuesta));
                    }
                    etiqueta.setText("");
                    break;

                case 4:
                    respuesta = numero / Double.parseDouble(campoTexto.getText());
                    if (Double.toString(respuesta).endsWith(".0")) {
                        campoTexto.setText(Double.toString(respuesta).replace(".0", ""));
                    } else {
                        campoTexto.setText(Double.toString(respuesta));
                    }
                    etiqueta.setText("");
                    break;
            }
        }
    }

    // método para habilitar la calculadora
    public void enable() {
        buttonON.setEnabled(false);
        buttonOFF.setEnabled(true);
        campoTexto.setEnabled(true);
        etiqueta.setEnabled(true);
        buttonLimpiar.setEnabled(true);
        buttonBorrar.setEnabled(true);
        buttonDiv.setEnabled(true);
        buttonRaiz.setEnabled(true);
        buttonCuadrado.setEnabled(true);
        buttonReciprocal.setEnabled(true);
        buttonResta.setEnabled(true);
        buttonSiete.setEnabled(true);
        buttonOcho.setEnabled(true);
        buttonNueve.setEnabled(true);
        buttonMulti.setEnabled(true);
        buttonCuatro.setEnabled(true);
        buttonCinco.setEnabled(true);
        buttonSeis.setEnabled(true);
        buttonSuma.setEnabled(true);
        buttonUno.setEnabled(true);
        buttonDos.setEnabled(true);
        buttonTres.setEnabled(true);
        buttonIgual.setEnabled(true);
        buttonCero.setEnabled(true);
        buttonPunto.setEnabled(true);
    }

    // método para desactivar la calculadora
    public void disable() {
        buttonON.setEnabled(true);
        buttonOFF.setEnabled(false);
        campoTexto.setText("");
        etiqueta.setText(" ");
        buttonLimpiar.setEnabled(false);
        buttonBorrar.setEnabled(false);
        buttonDiv.setEnabled(false);
        buttonRaiz.setEnabled(false);
        buttonCuadrado.setEnabled(false);
        buttonReciprocal.setEnabled(false);
        buttonResta.setEnabled(false);
        buttonSiete.setEnabled(false);
        buttonOcho.setEnabled(false);
        buttonNueve.setEnabled(false);
        buttonMulti.setEnabled(false);
        buttonCuatro.setEnabled(false);
        buttonCinco.setEnabled(false);
        buttonSeis.setEnabled(false);
        buttonSuma.setEnabled(false);
        buttonUno.setEnabled(false);
        buttonDos.setEnabled(false);
        buttonTres.setEnabled(false);
        buttonIgual.setEnabled(false);
        buttonCero.setEnabled(false);
        buttonPunto.setEnabled(false);
    }

    public static void main(String[] args) {
        new calculadora(); // create a new Calculator object
    }
}