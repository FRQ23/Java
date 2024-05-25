package entradaysalida;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ManejadorArchivoCaracteres extends JPanel {
    private static final String NOMBRE_ARCHIVO = "archivoCaracteres.txt";
    private JTextArea textArea;

    public ManejadorArchivoCaracteres(PanelPrincipal panelPrincipal) {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(1, 3));
        JButton btnEscribir = new JButton("Escribir Caracteres");
        btnEscribir.addActionListener(e -> escribirCaracteres());
        JButton btnLeer = new JButton("Leer Caracteres");
        btnLeer.addActionListener(e -> leerCaracteres());
        JButton btnRegresar = new JButton("Regresar al Menú");
        btnRegresar.addActionListener(e -> panelPrincipal.mostrarMenuPrincipal());

        panelBotones.add(btnEscribir);
        panelBotones.add(btnLeer);
        panelBotones.add(btnRegresar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void escribirCaracteres() {
        try (FileWriter fw = new FileWriter(NOMBRE_ARCHIVO)) {
            fw.write("Hola, mundo!");
            textArea.setText("Caracteres escritos exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("Error al escribir caracteres: " + e.getMessage());
        }
    }

    private void leerCaracteres() {
        try (FileReader fr = new FileReader(NOMBRE_ARCHIVO)) {
            int charData;
            StringBuilder contenido = new StringBuilder("Contenido del archivo de caracteres: ");
            while ((charData = fr.read()) != -1) {
                contenido.append((char) charData);
            }
            textArea.setText(contenido.toString());
        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("Error al leer caracteres: " + e.getMessage());
        }
    }
}



