package modelo;

import javax.swing.JFrame;

import controlador.AccionBoton2;

import java.awt.event.*;
import javax.swing.*;

public class FLVentana extends JFrame {
    public static void main(String[] args) {
        FLVentana frame = new FLVentana();
        JPanel panel = new JPanel();
        JTextField text1 = new JTextField(4);
        JTextField text2 = new JTextField(4);
        JTextField text3 = new JTextField(4);
        JTextField text4 = new JTextField(4);
        JLabel label = new JLabel();
        JButton bot1 = new JButton("Comprobar");
        JButton bot2 = new JButton("Salir");
        boolean bol = true;

        frame.setSize(350, 150);
        frame.setTitle("ProyectoFLVentana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(bol);
        frame.setContentPane(panel);

        panel.add(text1);
        panel.add(text2);
        panel.add(text3);
        panel.add(text4);
        panel.add(label);
        panel.add(bot1);
        panel.add(bot2);

        text1.setSize(70, 70);
        text1.setVisible(bol);

        text2.setSize(70, 70);
        text2.setVisible(bol);
        
        text3.setSize(70, 70);
        text3.setVisible(bol);
        

        text4.setSize(70, 70);
        text4.setVisible(bol);
        

        label.setVisible(bol);
        label.setText("LABEL DE PRUEBA");

        bot1.setVisible(bol);
        bot1.setText("Comprobar");
        bot1.addActionListener(new AccionBoton2());

        bot2.setVisible(bol);
        bot2.setText("Salir");
        bot2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        
    }

}
