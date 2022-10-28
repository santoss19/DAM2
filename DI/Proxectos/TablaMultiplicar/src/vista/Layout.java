package vista;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Layout extends JFrame {

    protected Container frame = getContentPane();
    protected Container glc = new Container();
    protected Container gbl = new Container();

    protected GridLayout gl = new GridLayout();

    protected JComboBox jcb = new JComboBox<String>(new String[]{"0","1","2","3","4","5","6","7","8","9","10"});
    protected JTextField text = null;
    protected Component[] textos = new Component[11];
    protected JLabel lbl = new JLabel("Tabla de multiplicar");
    protected JButton btn = new JButton("Sumar");
    protected JLabel lbl1 = new JLabel("Numero 1: ");
    protected JLabel lbl2 = new JLabel("Numero 2: ");
    protected JLabel lbl3 = new JLabel("Resultado: ");
    protected JTextField num1 = new JTextField(5);
    protected JTextField num2 = new JTextField(5);
    protected JLabel numR = new JLabel();


    public Layout() {

        super("TablaMultiplicar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 600);;

        frame.setLayout(new GridBagLayout());
        gbl.setLayout(new GridBagLayout());

        gl.setColumns(3);
        gl.setRows(11);
        glc.setLayout(gl);

        //Bucle para añadir los elementos a la tabla

        for(int i = 0; i < 11; i++) { 
            JLabel lbl1 = new JLabel(i + "");
            lbl1.setAlignmentX(CENTER_ALIGNMENT);
            glc.add(lbl1);
            JLabel lbl2 = new JLabel("=");
            lbl1.setAlignmentX(CENTER_ALIGNMENT);
            glc.add(lbl2);
            text = new JTextField(3);
            text.setEditable(false);
            glc.add(text);
            text.setName("mult_" + i);
            textos[i] = text;
        }

        //

        //Listener combobox

        jcb.addItemListener(itemListener -> {
            
        });

        //

        // GridBagLayout (frame)

        GridBagConstraints gbc = new GridBagConstraints();

        lbl.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,20,0);

        frame.add(lbl, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = gbc.BOTH;

        frame.add(jcb, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        frame.add(glc, gbc);

        //

        // GridBagLayout (suma)

        GridBagConstraints gbcSuma = new GridBagConstraints();
        
        gbcSuma.gridx = 0;
        gbcSuma.gridy = 0;
        gbcSuma.insets = new Insets(10, 0, 10, 10);

        gbl.add(lbl1, gbcSuma);

        gbcSuma.gridx = 0;
        gbcSuma.gridy = 1;
        gbcSuma.insets = new Insets(10, 0, 10, 10);

        gbl.add(lbl2, gbcSuma);

        gbcSuma.gridx = 0;
        gbcSuma.gridy = 2;
        gbcSuma.insets = new Insets(10, 0, 10, 10);

        gbl.add(lbl3, gbcSuma);

        gbcSuma.gridx = 1;
        gbcSuma.gridy = 0;
        gbcSuma.insets = new Insets(10, 10, 10, 0);

        gbl.add(num1, gbcSuma);

        gbcSuma.gridx = 1;
        gbcSuma.gridy = 1;
        gbcSuma.insets = new Insets(10, 10, 10, 0);

        gbl.add(num2, gbcSuma);

        gbcSuma.gridx = 1;
        gbcSuma.gridy = 2;
        gbcSuma.insets = new Insets(10, 10, 10, 0);

        gbl.add(numR, gbcSuma);

        gbcSuma.gridx = 2;
        gbcSuma.gridy = 0;
        gbcSuma.gridheight = 3;
        gbcSuma.gridwidth = 3;
        gbcSuma.fill = gbc.BOTH;
        gbcSuma.insets = new Insets(10, 10, 10, 0);

        gbl.add(btn, gbcSuma);

        //

        gbc.gridx = 0;
        gbc.gridy = 3;

        frame.add(gbl, gbc);

        setVisible(true);
    }


    public Container getFrame() {
        return frame;
    }


    public Container getGlc() {
        return glc;
    }


    public Container getGbl() {
        return gbl;
    }


    public GridLayout getGl() {
        return gl;
    }


    public JComboBox getJcb() {
        return jcb;
    }


    public JTextField getText() {
        return text;
    }


    public Component[] getTextos() {
        return textos;
    }


    public JLabel getLbl() {
        return lbl;
    }


    public JButton getBtn() {
        return btn;
    }


    public JLabel getLbl1() {
        return lbl1;
    }


    public JLabel getLbl2() {
        return lbl2;
    }


    public JLabel getLbl3() {
        return lbl3;
    }


    public JTextField getNum1() {
        return num1;
    }


    public JTextField getNum2() {
        return num2;
    }


    public JLabel getNumR() {
        return numR;
    }

    
}
