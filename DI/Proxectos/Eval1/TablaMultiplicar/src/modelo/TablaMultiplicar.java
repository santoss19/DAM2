package modelo;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import vista.Layout;

public class TablaMultiplicar {

    public void Layout_Exec() {

        Layout layout = new Layout();

        layout.getJcb().addActionListener(listener -> {
            Component[] textos = layout.getTextos();
            if(textos != null) {
                for(int i = 0; i < textos.length; i++) {
                    if(textos[i].getName().equals("mult_" + i)) {
                        JTextField text = (JTextField)textos[i];
                        text.setText(Integer.parseInt((String)layout.getJcb().getSelectedItem()) * i + "");
                    }
                }
            }
        });

        layout.getBtn().addActionListener(listener -> {
            layout.getNumR().setText((Integer.parseInt(layout.getNum1().getText()) + Integer.parseInt(layout.getNum2().getText())) + "");
        });

        layout.getNum2().addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == e.VK_ENTER) {
                    layout.getNumR().setText((Integer.parseInt(layout.getNum1().getText()) + Integer.parseInt(layout.getNum2().getText())) + "");
                }
            }
            public void keyReleased(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
    }

    public static void main(String[] args) {
        TablaMultiplicar tm = new TablaMultiplicar();
        tm.Layout_Exec();
    }

}
