package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.gameWindow;

public class gameEngine implements ActionListener {

    gameWindow gW = null;
    JButton[] buttons = null;

    public gameEngine(gameWindow gw) {
        gW = gw;
        buttons = gw.getButtons();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < buttons.length; i++) {
            if(e.getSource().equals(buttons[i])) {
                if(gW.getCartasSeleccionadas() == 0) {
                    gW.setBoton1((JButton) e.getSource());
                    int n = Integer.parseInt(gW.getBoton1().getName());
                    gW.getBoton1().setBackground(gW.getColores()[n]);
                    gW.getBoton1().setEnabled(false);
                    gW.sumCartasSeleccionadas();
                } else if(gW.getCartasSeleccionadas() == 1) {
                    gW.setBoton2((JButton) e.getSource());
                    int n2 = Integer.parseInt(gW.getBoton2().getName());
                    gW.getBoton2().setBackground(gW.getColores()[n2]);

                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            JButton boton1 = gW.getBoton1();
                            JButton boton2 = gW.getBoton2();
                            try {
                                Thread.sleep(1000);
                                if(boton1.getBackground().equals(boton2.getBackground())) {
                                    boton1.setEnabled(false);
                                    boton2.setEnabled(false);
                                    gW.setCartasSeleccionadas(0);
                                } else {
                                    boton1.setEnabled(true);
                                    boton2.setEnabled(true);
                                    boton1.setBackground(new Color(238, 238, 238));
                                    boton2.setBackground(new Color(238, 238, 238));
                                    gW.setCartasSeleccionadas(0);
                                }
                            } catch(InterruptedException ex) {
                                System.out.println("ERROR: " + ex);
                            }
                        }
                    });
                }
            }
        }
        
    }
}
