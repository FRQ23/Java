package entradaysalida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelPrincipal extends JPanel {
    CardLayout cardLayout;
    JPanel cards;

    public PanelPrincipal() {
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        // Crear los paneles para cada manejador de archivos
        JPanel panelMenu = crearPanelMenu();
        JPanel panelBytes = new ManejadorArchivoBytes(this);
        JPanel panelCaracteres = new ManejadorArchivoCaracteres(this);
        JPanel panelAccesoAleatorio = new ManejadorArchivoAccesoAleatorio(this);
        JPanel panelPersistenciaObjetos = new ManejadorPersistenciaObjetos(this);

        // Añadir los paneles al CardLayout
        cards.add(panelMenu, "Menu");
        cards.add(panelBytes, "Bytes");
        cards.add(panelCaracteres, "Caracteres");
        cards.add(panelAccesoAleatorio, "Acceso Aleatorio");
        cards.add(panelPersistenciaObjetos, "Persistencia Objetos");

        setLayout(new BorderLayout());
        add(cards, BorderLayout.CENTER);

        // Mostrar el menú principal al iniciar
        cardLayout.show(cards, "Menu");
    }

    private JPanel crearPanelMenu() {
        JPanel panelMenu = new JPanel(new GridLayout(5, 1));

        JButton btnBytes = new JButton("Archivos de Bytes");
        btnBytes.addActionListener((ActionEvent e) -> cardLayout.show(cards, "Bytes"));

        JButton btnCaracteres = new JButton("Archivos de Caracteres");
        btnCaracteres.addActionListener((ActionEvent e) -> cardLayout.show(cards, "Caracteres"));

        JButton btnAccesoAleatorio = new JButton("Acceso Aleatorio a Archivos");
        btnAccesoAleatorio.addActionListener((ActionEvent e) -> cardLayout.show(cards, "Acceso Aleatorio"));

        JButton btnPersistenciaObjetos = new JButton("Persistencia de Objetos");
        btnPersistenciaObjetos.addActionListener((ActionEvent e) -> cardLayout.show(cards, "Persistencia Objetos"));

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener((ActionEvent e) -> System.exit(0));

        panelMenu.add(btnBytes);
        panelMenu.add(btnCaracteres);
        panelMenu.add(btnAccesoAleatorio);
        panelMenu.add(btnPersistenciaObjetos);
        panelMenu.add(btnSalir);

        return panelMenu;
    }

    public void mostrarMenuPrincipal() {
        cardLayout.show(cards, "Menu");
    }
}


