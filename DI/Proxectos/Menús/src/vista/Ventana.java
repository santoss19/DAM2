package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class Ventana extends JFrame {
    
    JLabel text = new JLabel("Texto de Ejemplo");
    JMenuBar menuBar = new JMenuBar();
    JMenu menuArchivo = new JMenu();
    JMenu menuFormato = new JMenu();
    JMenuItem itemNuevo = new JMenuItem("Nuevo");
    JMenuItem itemGuardar = new JMenuItem("Guardar");
    JMenuItem itemSalir = new JMenuItem("Salir");
    JMenu itemColor = new JMenu("Color");
    JMenu itemLetra = new JMenu("Tipo de letra");
    JRadioButtonMenuItem neg = new JRadioButtonMenuItem("Negro");
    JRadioButtonMenuItem azu = new JRadioButtonMenuItem("Azul");
    JRadioButtonMenuItem roj = new JRadioButtonMenuItem("Rojo");
    JRadioButtonMenuItem ver = new JRadioButtonMenuItem("Verde");
    JRadioButtonMenuItem ser = new JRadioButtonMenuItem("Serif");
    JRadioButtonMenuItem mon = new JRadioButtonMenuItem("Monospaced");
    JRadioButtonMenuItem ssf = new JRadioButtonMenuItem("SansSerif");
    JCheckBoxMenuItem bold = new JCheckBoxMenuItem("Negrita");
    JCheckBoxMenuItem italic = new JCheckBoxMenuItem("Cursiva");
    Container panel = null;


    public Ventana() {
        super("Menús_Práctica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550,150);
        JPanel pan = new JPanel();
        setContentPane(pan);
        panel = getContentPane();

        text.setFont(new Font("Sans", Font.BOLD, 50));
        text.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        text.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        setJMenuBar(menuBar);
        menuArchivo.setText("Archivo");
        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemGuardar);
        menuArchivo.addSeparator();
        menuArchivo.add(itemSalir);
        menuFormato.setText("Formato");
        menuFormato.add(itemColor);
        menuFormato.addSeparator();
        menuFormato.add(itemLetra);

        /*COLORES*/ 

        ButtonGroup bgColor = new ButtonGroup();
        
        bgColor.add(neg);
        bgColor.add(azu);
        bgColor.add(roj);
        bgColor.add(ver);

        itemColor.add(neg);
        itemColor.add(azu);
        itemColor.add(roj);
        itemColor.add(ver);

        /*FORMATO*/

        ButtonGroup bgFormato1 = new ButtonGroup();

        bgFormato1.add(ser);
        bgFormato1.add(ssf);
        bgFormato1.add(mon);

        itemLetra.add(ser);
        itemLetra.add(ssf);
        itemLetra.add(mon);

        itemLetra.addSeparator();

        ButtonGroup bgFormato2 = new ButtonGroup();

        bgFormato2.add(bold);
        bgFormato2.add(italic);

        itemLetra.add(bold);
        itemLetra.add(italic);

        menuBar.add(menuArchivo);
        menuBar.add(menuFormato);

        panel.add(text);
        setVisible(true);
    }

    public Container getPanel() {
        return panel;
    }

    public JLabel getText() {
        return text;
    }

    public JMenuItem getItemNuevo() {
        return itemNuevo;
    }


    public JMenuItem getItemGuardar() {
        return itemGuardar;
    }


    public JMenuItem getItemSalir() {
        return itemSalir;
    }

    public JRadioButtonMenuItem getNeg() {
        return neg;
    }


    public JRadioButtonMenuItem getAzu() {
        return azu;
    }


    public JRadioButtonMenuItem getRoj() {
        return roj;
    }


    public JRadioButtonMenuItem getVer() {
        return ver;
    }


    public JRadioButtonMenuItem getSer() {
        return ser;
    }


    public JRadioButtonMenuItem getMon() {
        return mon;
    }


    public JRadioButtonMenuItem getSsf() {
        return ssf;
    }


    public JCheckBoxMenuItem getBold() {
        return bold;
    }


    public JCheckBoxMenuItem getItalic() {
        return italic;
    }

    
}


