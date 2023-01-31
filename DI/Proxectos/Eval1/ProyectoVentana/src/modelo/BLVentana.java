package modelo;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

import controlador.*;

public class BLVentana extends JFrame {

    public JPanel panelN = null;
    public JPanel panelC = null;
    public JPanel panelS = null;
    public JButton bot1 = null;
    public JButton bot2 = null;

    public BLVentana() {
        super();
        panelN = new JPanel();
        panelC = new JPanel();
        panelS = new JPanel();
        Container cp = getContentPane();
        JTextField text1 = new JTextField(4);
        JTextField text2 = new JTextField(4);
        JTextField text3 = new JTextField(4);
        JTextField text4 = new JTextField(4);
        JLabel label = new JLabel();
        bot1 = new JButton("Salir");
        bot2 = new JButton("Comprobar");
        boolean bol = true;

        setSize(400, 130);
        setTitle("ProyectoFLVentana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(bol);
        setContentPane(cp);

        panelS.add(label);
        panelC.add(text1);
        panelC.add(text2);
        panelC.add(text3);
        panelC.add(text4);
        panelS.add(bot1);
        panelS.add(bot2);
        cp.add(panelN, BorderLayout.NORTH);
        cp.add(panelC, BorderLayout.CENTER);
        cp.add(panelS, BorderLayout.SOUTH);

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
        bot2.setVisible(bol);
        bot1.addActionListener(new AccionBoton1(this));
        bot2.addActionListener(new AccionBoton2_BL(panelN, panelS, panelC));
    }
}
