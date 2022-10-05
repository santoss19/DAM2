package modelo;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;
import controlador.*;

public class BLVentana extends JFrame {
    public static void main(String[] args) {
        BLVentana frame = new BLVentana();
        JPanel panel = new JPanel();
        Container cp = frame.getContentPane();
        JTextField text1 = new JTextField(4);
        JTextField text2 = new JTextField(4);
        JTextField text3 = new JTextField(4);
        JTextField text4 = new JTextField(4);
        JLabel label = new JLabel();
        JButton bot1 = new JButton("Comprobar");
        JButton bot2 = new JButton("Salir");
        boolean bol = true;

        frame.setSize(250, 130);
        frame.setTitle("ProyectoFLVentana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(bol);
        frame.setContentPane(cp);

        cp.add(text1, BorderLayout.NORTH);
        cp.add(text2, BorderLayout.NORTH);
        cp.add(text3, BorderLayout.NORTH);
        cp.add(text4, BorderLayout.NORTH);
        cp.add(label, BorderLayout.CENTER);
        cp.add(bot1, BorderLayout.SOUTH);
        cp.add(bot2, BorderLayout.SOUTH);

        text1.setSize(70, 80);
        text1.getText().length();
        text1.setVisible(bol);

        text2.setSize(70, 80);
        text2.setVisible(bol);
        
        text3.setSize(70, 80);
        text3.setVisible(bol);
        

        text4.setSize(70, 80);
        text4.setVisible(bol);
        

        label.setVisible(bol);
        label.setSize(70, 150);
        label.setName("Etiqueta1");
        label.setText("PROGRAMA COMPROBA");

        bot1.setVisible(bol);
        bot1.setText("Comprobar");
        bot1.addActionListener(new AccionBoton2(panel));

        bot2.setVisible(bol);
        bot2.setText("Salir");
        bot2.addActionListener(new AccionBoton1(frame));
        
    }    
}
