package vista;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ventana extends JFrame {
    
    JButton dibujar = new JButton("Dibujar");
    JMenuBar menuBar = new JMenuBar();
    JMenu menuColores = new JMenu("Colores");
    PanelPunto panelPunto = new PanelPunto();

    Color[] colores = {};

    public Ventana() {

        super("Punto Interface");
        Container cp = getContentPane();
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp.setLayout(new BorderLayout());

        for(int i = 0; i < colores.length; i++) {
            JMenuItem menuItem = new JMenuItem();
            menuItem.setName(colores[i].toString());
            //menuItem.addItemListener(new ItemListener(this));
            menuColores.add(menuItem);
        }

        cp.add(panelPunto, BorderLayout.CENTER);

        setVisible(true);

        panelPunto.paint(getGraphics());

    }

    public static void main(String[] args) {
        Ventana vent = new Ventana();
    }

}
