package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Container;

public class WindDesign extends JFrame{

    private BorderLayout bl = new BorderLayout();
    private GridLayout gl = new GridLayout(13, 1);
    private GridLayout gl2 = new GridLayout(1,3);
    private GridLayout gl3 = new GridLayout(1, 6);
    private String[] colores = {"Negro", "Gris Oscuro", "Gris", "Gris Claro", "Blanco", "Magenta", "Azul", "Cian", "Verde", "Amarillo", "Naranja", "Rojo", "Rosa"};
    private Color[] colors = {Color.BLACK, Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.WHITE, Color.MAGENTA, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED, Color.PINK};
    private JButton[] botones = new JButton[13];
    private JScrollBar[] scrollBars = new JScrollBar[3];
    private JTextField[] texts = new JTextField[3];
    private Container panel = getContentPane();
    private Container panelC = new JPanel();
    private Container panelE = new JPanel();
    private Container panelW = new JPanel();
    private Container panelS = new JPanel();

    public WindDesign() {

        super("Colores");
        setSize(600, 600);
        setDefaultCloseOperation(super.EXIT_ON_CLOSE);

        //South//

        JLabel label = new JLabel("Rojo");
        label.setBackground(colors[11]);
        label.setName("Label Red");
        label.setOpaque(true);
        panelS.add(label);

        JTextField text1 = new JTextField("0");
        text1.setName("Texto Red");
        panelS.add(text1);
        texts[0] = text1;

        JLabel label2 = new JLabel("Verde");
        label2.setBackground(colors[8]);
        label2.setOpaque(true);
        label2.setName("Label Green");
        panelS.add(label2);

        JTextField text2 = new JTextField("0");
        text2.setName("Texto Verde");
        panelS.add(text2);
        texts[1] = text2;

        JLabel label3 = new JLabel("Azul");
        label3.setBackground(colors[6]);
        label3.setOpaque(true);
        label3.setForeground(Color.WHITE);
        label3.setName("Label Blue");
        panelS.add(label3);

        JTextField text3 = new JTextField("0");
        text3.setName("Texto Azul");
        panelS.add(text3);
        texts[2] = text3;

        //West//

        for(int j = 0; j < scrollBars.length; j++) {
            JScrollBar scrll = new JScrollBar();
            scrll.setName("Barra " + j);
            scrll.setOrientation(scrll.VERTICAL);
            scrll.setMinimum(0);
            scrll.setMaximum(255);
            scrll.setBackground(colors[4]);
            panelW.add(scrll);
            scrollBars[j] = scrll;
        }

        //East//

        for(int i = 0; i < colores.length; i++) {
            JButton but = new JButton(colores[i]);
            but.setName("Boton " + i);
            but.setBackground(colors[i]);
            if(i == 0 || i == 1 || i == 2) {
                but.setForeground(Color.WHITE);
            }
            panelE.add(but);
            botones[i] = but;
        }
        
        setLayout(bl);
        panelE.setLayout(gl);
        panelW.setLayout(gl2);
        panelS.setLayout(gl3);
        panel.add(panelC, bl.CENTER);
        panel.add(panelE, bl.EAST);
        panel.add(panelW, bl.WEST);
        panel.add(panelS, bl.SOUTH);
        setVisible(true);
        
    }

    public JButton[] getBotones() {
        return botones;
    }

    public JScrollBar[] getScrollBars() {
        return scrollBars;
    }

    public JTextField[] getTexts() {
        return texts;
    }

    public Container getPanelC() {
        return panelC;
    }
  
}
