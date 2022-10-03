package controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccionBoton2 implements ActionListener {

    JPanel jp = null;
    List<String> textos = new ArrayList<>();

    public AccionBoton2(JPanel jPanel) {
        this.jp = jPanel;
    }

    public void actionPerformed(ActionEvent e) {
        
        Component[] componentes = jp.getComponents();
        List<JTextField> componentesText = new ArrayList<>();
        int cuenta = 0;
        int ronda = 1;

        for(int i = 0; i < componentes.length ; i++) {
            if(componentes[i].getClass().getName().equals("javax.swing.JTextField")) {
                componentesText.add((JTextField)componentes[i]);
            }
        }
 
        for(JTextField texto : componentesText) {
            for(JTextField texto2 : componentesText) {
                cuenta++;
                texto.getText().equals(texto2.getText());
            }
            if(cuenta > 2 && ronda == 1) {
                textos.add("A tiene " + cuenta + " iguales a el.");
            } else if(cuenta > 2 && ronda == 2) {
                textos.add("B tiene " + cuenta + " iguales a el.");
            } else if(cuenta > 2 && ronda == 3) {
                textos.add("C tiene " + cuenta + " iguales a el.");
            } else if(cuenta > 2 && ronda == 4) {
                textos.add("D tiene " + cuenta + " iguales a el.");
            }
            ronda ++;
            cuenta = 0;
        }

        for(String text : textos) {
            System.out.println(text);
        }
    }
}
