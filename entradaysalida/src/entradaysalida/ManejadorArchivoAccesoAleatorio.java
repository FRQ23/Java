package entradaysalida;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ManejadorArchivoAccesoAleatorio extends JPanel {
    private static final String NOMBRE_ARCHIVO = "archivoAccesoAleatorio.dat";
    private JTextArea textArea;

    public ManejadorArchivoAccesoAleatorio(PanelPrincipal panelPrincipal) {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(1, 3));
        JButton btnEscribir = new JButton("Escribir Acceso Aleatorio");
        btnEscribir.addActionListener(e -> escribirAccesoAleatorio());
        JButton btnLeer = new JButton("Leer Acceso Aleatorio");
        btnLeer.addActionListener(e -> leerAccesoAleatorio());
        JButton btnRegresar = new JButton("Regresar al Menú");
        btnRegresar.addActionListener(e -> panelPrincipal.mostrarMenuPrincipal());

        panelBotones.add(btnEscribir);
        panelBotones.add(btnLeer);
        panelBotones.add(btnRegresar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void escribirAccesoAleatorio() {
        try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_ARCHIVO, "rw")) {
            raf.writeUTF("Hola");
            raf.writeInt(12345);
            textArea.setText("Datos escritos en acceso aleatorio exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("Error al escribir datos en acceso aleatorio: " + e.getMessage());
        }
    }

    private void leerAccesoAleatorio() {
        try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_ARCHIVO, "r")) {
            String texto = raf.readUTF();
            int numero = raf.readInt();
            textArea.setText("Lectura de acceso aleatorio: " + texto + " - " + numero);
        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("Error al leer datos en acceso aleatorio: " + e.getMessage());
        }
    }
}




