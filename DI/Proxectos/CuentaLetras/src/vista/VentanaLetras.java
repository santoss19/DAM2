package vista;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaLetras extends JFrame {

    JPanel panel = new JPanel();
    JButton bot = new JButton("Procesar Texto");
    JTextField wText = new JTextField(13);
    JLabel text1 = new JLabel("0");
    JLabel text2 = new JLabel("0");
    JLabel label1 = new JLabel("Introduce una frase:");
    JLabel label2 = new JLabel("Numero de letras:");
    JLabel label3 = new JLabel("Numero de palabras:");
    GridBagLayout gbl = new GridBagLayout();

    public VentanaLetras() {

        super("Proyecto VentanaLetras");
        panel.setLayout(gbl);
        setContentPane(panel);
        setVisible(true);
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /* Introducción elementos en el panel */

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.anchor = gbc.CENTER;
        gbc.fill = gbc.BOTH;
        gbc.insets = new Insets(10,0,0,10);
       

        GridBagConstraints gbc2 = new GridBagConstraints();

        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gbc2.gridwidth = 2;
        gbc2.anchor = gbc2.WEST;
        gbc2.insets = new Insets(0,10,10,10);

        GridBagConstraints gbc3 = new GridBagConstraints();

        gbc3.gridx = 0;
        gbc3.gridy = 0;
        gbc3.anchor = gbc3.WEST;
        gbc3.insets = new Insets(0,0,10,10);

        GridBagConstraints gbc4 = new GridBagConstraints();

        gbc4.gridx = 1;
        gbc4.anchor = gbc4.NORTHWEST;
        gbc4.gridy = 1;
        gbc4.insets = new Insets(10,10,10,10);

        GridBagConstraints gbc5 = new GridBagConstraints();

        gbc5.gridx = 1;
        gbc5.anchor = gbc5.SOUTHWEST;
        gbc5.gridy = 2;
        gbc5.insets = new Insets(10,10,0,10);

        GridBagConstraints gbc6 = new GridBagConstraints();

        gbc6.gridx = 2;
        gbc6.anchor = gbc6.NORTHEAST;
        gbc6.gridy = 1;
        gbc6.insets = new Insets(10,0,10,10);

        GridBagConstraints gbc7 = new GridBagConstraints();

        gbc7.gridx = 2;
        gbc7.anchor = gbc7.SOUTHEAST;
        gbc7.gridy = 2;
        gbc7.insets = new Insets(0,0,0,10);
       


        panel.add(bot, gbc);
        panel.add(wText, gbc2);
        panel.add(label1, gbc3);
        panel.add(label2, gbc4);
        panel.add(label3, gbc5);
        panel.add(text1, gbc6);
        panel.add(text2, gbc7);

    }

    

    



}
