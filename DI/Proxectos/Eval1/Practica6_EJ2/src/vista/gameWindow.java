package vista;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Collections;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;

import controlador.gameEngine;

public class gameWindow extends JFrame {

    JButton[] buttons = new JButton[8];
    
    JButton boton1 = null;
    JButton boton2 = null;
    int cartasSeleccionadas = 0;
    Color[] colores = {Color.RED, Color.RED, Color.GREEN, Color.GREEN, Color.YELLOW, Color.YELLOW, Color.BLUE, Color.BLUE};

    public gameWindow() {
        super("Cartas-Hugo");
        setSize(1000,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2,4));

        // Se crean los botonos que actuan como cartas y se randomizan

        for(int i = 0; i < 8; i++) {
            JButton button = new JButton();
            button.setName("" + i);
            button.setText("Carta " + (i + 1));
            buttons[i] = button;
            cp.add(button);
        }

        Collections.shuffle(Arrays.asList(colores));

        for(JButton b : buttons) {
            b.addActionListener(new gameEngine(this));
        }

    }

    public JButton[] getButtons() {
        return buttons;
    }

    public void setButtons(JButton[] buttons) {
        this.buttons = buttons;
    }

    public JButton getBoton1() {
        return boton1;
    }

    public void setBoton1(JButton boton1) {
        this.boton1 = boton1;
    }

    public JButton getBoton2() {
        return boton2;
    }

    public void setBoton2(JButton boton2) {
        this.boton2 = boton2;
    }

    public int getCartasSeleccionadas() {
        return cartasSeleccionadas;
    }

    public void sumCartasSeleccionadas() {
        this.cartasSeleccionadas += 1;
    }

    public Color[] getColores() {
        return colores;
    }

    public void setCartasSeleccionadas(int cartasSeleccionadas) {
        this.cartasSeleccionadas = cartasSeleccionadas;
    }

}
