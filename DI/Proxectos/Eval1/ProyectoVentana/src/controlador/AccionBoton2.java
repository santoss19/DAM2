package controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccionBoton2 implements ActionListener {

    String mensaje;
    JPanel jp = null;
    List<String> textos = new ArrayList<>();
    

    public AccionBoton2(JPanel jPanel) {
        this.jp = jPanel;
    }

    public void actionPerformed(ActionEvent e) {
        
        Component[] componentes = jp.getComponents();
        JLabel label = null;
        List<JTextField> componentesText = new ArrayList<>();

        int cuenta = 0;
        int ronda = 1;

        for(int i = 0; i < componentes.length ; i++) {
            if(componentes[i].getClass().getName().equals("javax.swing.JTextField")) {
                componentesText.add((JTextField)componentes[i]);
            } else if(componentes[i].getClass().getName().equals("javax.swing.JLabel")) {
                label = (JLabel)componentes[i];
            }
        }
 
        for(JTextField texto : componentesText) {
            for(JTextField texto2 : componentesText) {
                if(texto.getText().equals(texto2.getText())) {
                    cuenta++;
                }                
            }
            
            if(cuenta >= 2 && ronda == 1) {
                textos.add("A");
            } else if(cuenta >= 2 && ronda == 2) {
                textos.add("B");
            } else if(cuenta >= 2 && ronda == 3) {
                textos.add("C");
            } else if(cuenta >= 2 && ronda == 4) {
                textos.add("D");
            }
            ronda ++;
            cuenta = 0;
            
        }

        if(textos.size() > 0) {
            mensaje = "Teñen más de 2 repetidos : ";
            for(String text : textos) {
                mensaje += text + ",";
            }
        } else {
            mensaje = "Non hay ningún texto repetido";
        }

        label.setText(mensaje);
        textos.removeAll(textos);
    }
}
