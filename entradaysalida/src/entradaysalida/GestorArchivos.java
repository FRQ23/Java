package entradaysalida;

import javax.swing.*;

public class GestorArchivos {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gestor de Archivos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            PanelPrincipal panelPrincipal = new PanelPrincipal();
            frame.setContentPane(panelPrincipal);
            
            frame.setVisible(true);
        });
    }
}


