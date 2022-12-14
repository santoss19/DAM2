package vista;

import javax.swing.*;

import java.awt.*;

public class PanelPunto extends JPanel{

    @Override
    public void paint(Graphics g) {

        double width = (getSize().getWidth()) / 2;
        double height = (getSize().getHeight()) / 2;

        Punto p1 = new Punto(width - 40, height);
        Punto p2 = new Punto(width + 40, height);

        //Creacion Circulos

        g.setColor(Color.RED);
        g.fillOval((int) p1.obtenerX(), (int) p1.obtenerY(), 40, 40);
        g.fillOval((int) p2.obtenerX(), (int) p2.obtenerY(), 40, 40);
        
        //Creación cuadrado

        g.setColor(Color.RED);
        g.fillRect((int) width, (int) height, 40, 40);
    }
}