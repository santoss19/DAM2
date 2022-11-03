package vista;

import java.awt.*;

import javax.swing.*;

public class WindDesign extends JFrame{
    
    protected GridBagLayout gbl = new GridBagLayout();
    private JLabel titulo = new JLabel("Introduce una frase");
    private JLabel frase = new JLabel("Texto");
    private JTextField texto = new JTextField();
    private JCheckBox check = new JCheckBox("Cursiva");
    private ButtonGroup bg = new ButtonGroup();
    private JRadioButton b12 = new JRadioButton("12");
    private JRadioButton b18 = new JRadioButton("18");
    private JRadioButton b24 = new JRadioButton("24");

    public WindDesign() {

        super("Modificar Fuente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        Container cont = getContentPane();
        cont.setLayout(gbl);

        titulo.setFont(new Font(Font.SERIF, Font.ITALIC, 20));

        // Button Group //

        JPanel bP = new JPanel();
        GridLayout gl = new GridLayout(3,1);
        bP.setLayout(gl);
        bP.setBorder(BorderFactory.createTitledBorder("Tamaño"));
        
        bg.add(b12);
        bg.add(b18);
        bg.add(b24);

        bP.add(b12);
        bP.add(b18);
        bP.add(b24);

        // ChechBox Panel //

        JPanel chkP = new JPanel();
        chkP.setBorder(BorderFactory.createTitledBorder("Estilos"));
        chkP.add(check);

        // Add's y modificacion del GBC//

        GridBagConstraints gbc =  new GridBagConstraints();

        // GBC Título //

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 20, 5, 20);
        gbc.anchor = gbc.CENTER;
        cont.add(titulo, gbc);

        // GBC Texto //

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.anchor = gbc.CENTER;
        gbc.fill = gbc.BOTH;
        cont.add(texto, gbc);
        gbc.fill = gbc.NONE;

        // GBC Frase //

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.anchor = gbc.CENTER;
        cont.add(frase, gbc);

        // GBC Check Panel //

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 20, 0, 10);
        gbc.anchor = gbc.WEST;
        gbc.fill = gbc.BOTH;
        cont.add(chkP, gbc);

        // GBC Buton's Panel //

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 10, 0, 20);
        gbc.anchor = gbc.EAST;
        gbc.fill = gbc.BOTH;
        cont.add(bP, gbc);

        setVisible(true);

    }

    public JLabel getFrase() {
        return frase;
    }

    public JTextField getTexto() {
        return texto;
    }

    public JCheckBox getCheck() {
        return check;
    }

    public JRadioButton getB12() {
        return b12;
    }

    public JRadioButton getB18() {
        return b18;
    }

    public JRadioButton getB24() {
        return b24;
    }

}