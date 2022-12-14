package vista;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class fraVentana extends JFrame {

    JButton boton1;
    JButton boton2;
    JButton boton3;
    JButton boton4;
    JToggleButton botonCentro;

    public fraVentana(boolean visible) {
        
        setTitle("Centro");
        setSize(300,300);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.getLayout().minimumLayoutSize(cp);

        boton1 = new JButton("Arriba Izquierda");
        boton2 = new JButton("Arriba Derecha");
        boton3 = new JButton("Abajo Izquierda");
        boton4 = new JButton("Abajo Derecha");
        botonCentro = new JToggleButton("Aumentar Tamaño");

        Container norte = new Container();
        norte.setLayout(new GridLayout(1,2));

        norte.add(boton1);
        norte.add(boton2);

        Container sur = new Container();
        sur.setLayout(new GridLayout(1,2));

        sur.add(boton3);
        sur.add(boton4);

        cp.add(botonCentro, BorderLayout.CENTER);
        cp.add(norte, BorderLayout.NORTH);
        cp.add(sur, BorderLayout.SOUTH);

        setLocation(400, 200);
        setVisible(visible);
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

    public JButton getBoton3() {
        return boton3;
    }

    public void setBoton3(JButton boton3) {
        this.boton3 = boton3;
    }

    public JButton getBoton4() {
        return boton4;
    }

    public void setBoton4(JButton boton4) {
        this.boton4 = boton4;
    }

    public JToggleButton getBotonCentro() {
        return botonCentro;
    }

    public void setBotonCentro(JToggleButton botonCentro) {
        this.botonCentro = botonCentro;
    }

}