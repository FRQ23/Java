package entradaysalida;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ManejadorPersistenciaObjetos extends JPanel {
    private static final String NOMBRE_ARCHIVO = "archivoObjetos.ser";
    private JTextArea textArea;

    public ManejadorPersistenciaObjetos(PanelPrincipal panelPrincipal) {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(1, 3));
        JButton btnEscribir = new JButton("Escribir Objeto");
        btnEscribir.addActionListener(e -> escribirObjeto());
        JButton btnLeer = new JButton("Leer Objeto");
        btnLeer.addActionListener(e -> leerObjeto());
        JButton btnRegresar = new JButton("Regresar al Menú");
        btnRegresar.addActionListener(e -> panelPrincipal.mostrarMenuPrincipal());

        panelBotones.add(btnEscribir);
        panelBotones.add(btnLeer);
        panelBotones.add(btnRegresar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void escribirObjeto() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            Persona persona = new Persona("Juan", 30);
            oos.writeObject(persona);
            textArea.setText("Objeto escrito exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("Error al escribir objeto: " + e.getMessage());
        }
    }

    private void leerObjeto() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
            Persona persona = (Persona) ois.readObject();
            textArea.setText("Lectura del objeto: " + persona);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            textArea.setText("Error al leer objeto: " + e.getMessage());
        }
    }

    static class Persona implements Serializable {
        private String nombre;
        private int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public String toString() {
            return "Persona{nombre='" + nombre + "', edad=" + edad + "}";
        }
    }
}



