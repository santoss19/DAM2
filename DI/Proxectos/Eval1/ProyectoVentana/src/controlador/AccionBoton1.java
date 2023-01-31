package controlador;

import java.awt.event.*;

import javax.swing.JFrame;

public class AccionBoton1 implements ActionListener {

    JFrame cp = null;

    public AccionBoton1(JFrame f) {
        this.cp = f;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource()); //Obtén de que botón ven a orde
        cp.setVisible(false);
    }
}
