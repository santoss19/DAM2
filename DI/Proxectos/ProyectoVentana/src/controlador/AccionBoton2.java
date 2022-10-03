package controlador;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

public class AccionBoton2 implements ActionListener {

    JPanel jp = null;

    public AccionBoton2(JPanel jPanel) {
        this.jp = jPanel;
    }

    public void actionPerformed(ActionEvent e) {
        Component[] componentes = jp.getComponents();
        componentes[1].toString();
    }
}
