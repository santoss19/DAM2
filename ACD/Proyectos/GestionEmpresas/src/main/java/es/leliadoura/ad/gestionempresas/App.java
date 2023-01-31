/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package es.leliadoura.ad.gestionempresas;

import es.leliadoura.ad.gestionempresas.vista.AppFrame;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author marco
 */
public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
    
    public static void createAndShowGUI() {
        JFrame f = new AppFrame("Gestión contratos");
        f.setVisible(true);
    }

    
}
