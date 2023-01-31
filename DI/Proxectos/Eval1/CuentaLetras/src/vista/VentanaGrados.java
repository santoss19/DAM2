package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;

public class VentanaGrados extends JFrame {

    public JTextField tFar = new JTextField(10);
    public JTextField tCent = new JTextField(10);
    public JLabel label1 = new JLabel("Grados Centígrados:");
    public JLabel label2 = new JLabel("Grados Farenheit:");
    public JButton bot = new JButton("Aceptar");

    public VentanaGrados() {
        setSize(350, 200);
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = gbc.WEST;
        gbc.insets = new Insets(0,10,10,5);

        getContentPane().add(label1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = gbc.WEST;
        gbc.insets = new Insets(0, 10, 10, 5);

        getContentPane().add(label2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = gbc.SOUTHEAST;
        gbc.gridwidth = 2;
        
        getContentPane().add(bot, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,5,10,0);
        gbc.anchor = gbc.EAST;
        gbc.fill = gbc.BOTH;

        getContentPane().add(tCent, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 5, 10, 0);
        gbc.anchor = gbc.EAST;
        gbc.fill = gbc.BOTH;

        getContentPane().add(tFar, gbc);        
        
        setVisible(true);
    }

    
}
