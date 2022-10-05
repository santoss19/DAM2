package controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccionBoton2_BL implements ActionListener {

    String mensaje;
    JPanel panelN = null;
    JPanel panelS = null;
    JPanel panelC = null;
    List<String> textos = new ArrayList<>();
    

    public AccionBoton2_BL(JPanel panelN, JPanel panelS, JPanel panelC) {
        this.panelN = panelN;
        this.panelC = panelC;
        this.panelS = panelS;
    }

    public void actionPerformed(ActionEvent e) {
        
        Component[] componentesN = panelN.getComponents();
        Component[] componentesS = panelS.getComponents();
        Component[] componentesC = panelC.getComponents();
        JLabel label = null;
        List<JTextField> componentesText = new ArrayList<>();

        int cuenta = 0;
        int ronda = 1;

        // Recolle os objetos de todos os paneis 

        for(int i = 0; i < componentesN.length ; i++) {
            if(componentesN[i].getClass().getName().equals("javax.swing.JTextField")) {
                componentesText.add((JTextField)componentesN[i]);
            } else if(componentesN[i].getClass().getName().equals("javax.swing.JLabel")) {
                label = (JLabel)componentesN[i];
            }
        }

        for(int i = 0; i < componentesS.length ; i++) {
            if(componentesS[i].getClass().getName().equals("javax.swing.JTextField")) {
                componentesText.add((JTextField)componentesS[i]);
            } else if(componentesS[i].getClass().getName().equals("javax.swing.JLabel")) {
                label = (JLabel)componentesS[i];
            }
        }

        for(int i = 0; i < componentesC.length ; i++) {
            if(componentesC[i].getClass().getName().equals("javax.swing.JTextField")) {
                componentesText.add((JTextField)componentesC[i]);
            } else if(componentesC[i].getClass().getName().equals("javax.swing.JLabel")) {
                label = (JLabel)componentesC[i];
            }
        }
        
        //

        // Traballo cos datos obtidos dos componentes dos paneis 

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
