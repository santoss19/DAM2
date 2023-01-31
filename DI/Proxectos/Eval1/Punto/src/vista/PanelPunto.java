package vista;

import javax.swing.*;

import java.awt.*;

public class PanelPunto extends JPanel{

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        double pY = (double) (getSize().getWidth() / 2) - 45;
        double pX = (double) getSize().getHeight() / 2;

        Punto p1 = new Punto(pX - 40, pY);
        Punto p2 = new Punto(pX + 40, pY);

        g.setColor(Color.RED);

        /*g.fillOval((int) p1.obtenerX(), (int) p1.obtenerY(), 30, 30);
        g.fillOval((int) p2.obtenerX(), (int) p2.obtenerY(), 30, 30);*/

        g.fillRect((int) p1.obtenerX() + 15, (int) p1.obtenerY() + 15, (int) p1.calcularDistancia(p2), (int) p1.calcularDistancia(p2));
    } 
}