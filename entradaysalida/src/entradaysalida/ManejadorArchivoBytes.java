package entradaysalida;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ManejadorArchivoBytes extends JPanel {
    private static final String NOMBRE_ARCHIVO = "archivoBytes.dat";
    private JTextArea textArea;

    public ManejadorArchivoBytes(PanelPrincipal panelPrincipal) {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(1, 3));
        JButton btnEscribir = new JButton("Escribir Bytes");
        btnEscribir.addActionListener(e -> escribirBytes());
        JButton btnLeer = new JButton("Leer Bytes");
        btnLeer.addActionListener(e -> leerBytes());
        JButton btnRegresar = new JButton("Regresar al Menú");
        btnRegresar.addActionListener(e -> panelPrincipal.mostrarMenuPrincipal());

        panelBotones.add(btnEscribir);
        panelBotones.add(btnLeer);
        panelBotones.add(btnRegresar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void escribirBytes() {
        try (FileOutputStream fos = new FileOutputStream(NOMBRE_ARCHIVO)) {
            fos.write(new byte[]{1, 2, 3, 4, 5});
            textArea.setText("Bytes escritos exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("Error al escribir bytes: " + e.getMessage());
        }
    }

    private void leerBytes() {
        try (FileInputStream fis = new FileInputStream(NOMBRE_ARCHIVO)) {
            int byteData;
            StringBuilder contenido = new StringBuilder("Contenido del archivo de bytes: ");
            while ((byteData = fis.read()) != -1) {
                contenido.append(byteData).append(" ");
            }
            textArea.setText(contenido.toString());
        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("Error al leer bytes: " + e.getMessage());
        }
    }
}



