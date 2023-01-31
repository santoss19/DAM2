package vista;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

public class Ventana extends JFrame {
    
    JButton limpiar = new JButton("Limpiar");
    JButton dibujar = new JButton("Dibujar");
    JButton calcular = new JButton("Calcular");
    JTextField resultado = new JTextField();

    JLabel p1XLabel = new JLabel("Cordenadas X :");
    JTextField p1X = new JTextField();
    JLabel p1YLabel = new JLabel("Cordenadas Y :");
    JTextField p1Y = new JTextField();
    JLabel p2XLabel = new JLabel("Cordenadas X :");
    JTextField p2X = new JTextField();
    JLabel p2YLabel = new JLabel("Cordenadas Y :");
    JTextField p2Y = new JTextField();

    PanelPunto panelPunto = new PanelPunto();

    Color[] colores = {};

    public Ventana() {

        super("Punto Interface");
        Container cp = getContentPane();
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp.setLayout(new BorderLayout());

        // Panel Norte

        JPanel panelN = new JPanel();
        GridLayout gl = new GridLayout(2,2);

        panelN.setLayout(gl);

        panelN.add(p1XLabel);
        panelN.add(p1X);
        panelN.add(p1YLabel);
        panelN.add(p1Y);
        panelN.add(p2XLabel);
        panelN.add(p2X);
        panelN.add(p2YLabel);
        panelN.add(p2Y);

        // Panel Sur

        JPanel panelS = new JPanel();
        GridLayout gl2 = new GridLayout(2, 1);
        panelS.setLayout(gl2);

        JPanel panel1 = new JPanel();
        GridLayout glArriba = new GridLayout(1, 1);
        panel1.setLayout(glArriba);

        resultado.setEnabled(false);
        resultado.setAlignmentX(CENTER_ALIGNMENT);
        panel1.add(resultado);

        JPanel panel2 = new JPanel();
        GridLayout glAbajo = new GridLayout(1, 3);
        panel2.setLayout(glAbajo);

        panel2.add(dibujar);
        panel2.add(limpiar);
        panel2.add(calcular);

        panelS.add(panel1);
        panelS.add(panel2);


        cp.add(panelS, BorderLayout.SOUTH);
        cp.add(panelN, BorderLayout.NORTH);
        cp.add(panelPunto, BorderLayout.CENTER);

        setVisible(true);

        panelPunto.paint(getGraphics());

    }

    public static void main(String[] args) {
        Ventana vent = new Ventana();
    }

}
