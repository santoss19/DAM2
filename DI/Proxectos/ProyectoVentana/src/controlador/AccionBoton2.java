package controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JPanel;

public class AccionBoton2 implements ActionListener {

    JPanel jp = null;

    public AccionBoton2(JPanel jPanel) {
        this.jp = jPanel;
    }

    public void actionPerformed(ActionEvent e) {
        
        Component[] componentes = jp.getComponents();
        List<Component> componentesText = new ArrayList<>();

        for(int i = 0; componentes[i].getClass().getName() == "java.swing.JTextField"; i++) {
            componentesText.add(componentes[i]);
        }

        for(int i = 0; i < componentesText.size(); i++) {
            JPanel next = componentesText.iterator().next();
            for(int j = 0; j < componentesText.size(); i++) {
                next.get
            }
        }
    }
}
