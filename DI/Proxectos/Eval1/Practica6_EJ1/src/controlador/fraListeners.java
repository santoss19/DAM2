package controlador;

import vista.fraVentana;

import java.awt.Dimension;

import javax.swing.JToggleButton;

public class fraListeners {
    int mode = 0;

    protected void setMode(int mod)  {
        mode = mod;
    }

    protected int getMode()  {
        return mode;
    }

    public void ventExec() {
        fraVentana fraVent = new fraVentana(true);
        Dimension dPantallaDimension = fraVent.getToolkit().getScreenSize();

        fraVent.getBoton1().addActionListener(listener -> {
            fraVent.setLocation(0,0);
            fraVent.setTitle("Arriba Izquierda");
            setMode(0);
        });

        fraVent.getBoton2().addActionListener(listener -> {
            int pX = (int) dPantallaDimension.getWidth() - fraVent.getWidth();
            int pY = (int) ((int) dPantallaDimension.getHeight() - dPantallaDimension.getHeight());
            fraVent.setLocation(pX, pY);
            fraVent.setTitle("Arriba Derecha");
            setMode(1);
        });

        fraVent.getBoton3().addActionListener(listener -> {
            int pX = (int) (dPantallaDimension.getWidth() - dPantallaDimension.getWidth());
            int pY = (int) dPantallaDimension.getHeight() - fraVent.getHeight();
            fraVent.setLocation(pX, pY);
            fraVent.setTitle("Abajo Izquierda");
            setMode(2);
        });

        fraVent.getBoton4().addActionListener(listener -> {
            int pX = (int) dPantallaDimension.getWidth() - fraVent.getWidth();
            int pY = (int) dPantallaDimension.getHeight() - fraVent.getHeight();
            fraVent.setLocation(pX, pY);
            fraVent.setTitle("Abajo Derecha");
            setMode(3);
        });

        fraVent.getBotonCentro().addChangeListener(listener -> {
            JToggleButton button = fraVent.getBotonCentro();
            int pX = 400;
            int pY = 200;

            if(button.isSelected()) {
                fraVent.setSize(600, 600);
                switch(getMode()) {
                    case 0 :
                        pX = 0;
                        pY = 0;
                        fraVent.setLocation(pX, pY);
                        break;
                    case 1:
                        pX = (int) dPantallaDimension.getWidth() - fraVent.getWidth();
                        pY = (int) ((int) dPantallaDimension.getHeight() - dPantallaDimension.getHeight());
                        fraVent.setLocation(pX, pY);
                        break;
                    case 2:
                        pX = (int) (dPantallaDimension.getWidth() - dPantallaDimension.getWidth());
                        pY = (int) dPantallaDimension.getHeight() - fraVent.getHeight();
                        fraVent.setLocation(pX, pY);
                        break;
                    case 3:
                        pX = (int) dPantallaDimension.getWidth() - fraVent.getWidth();
                        pY = (int) dPantallaDimension.getHeight() - fraVent.getHeight();
                        fraVent.setLocation(pX, pY);
                        break;
                    default:
                        pX = 400;
                        pY = 200;
                        fraVent.setLocation(pX, pY);
                        break;
                }
            } else {
                fraVent.setSize(300, 300);
                switch(getMode()) {
                    case 0 :
                        pX = 0;
                        pY = 0;
                        fraVent.setLocation(pX, pY);
                        break;
                    case 1:
                        pX = (int) dPantallaDimension.getWidth() - fraVent.getWidth();
                        pY = (int) ((int) dPantallaDimension.getHeight() - dPantallaDimension.getHeight());
                        fraVent.setLocation(pX, pY);
                        break;
                    case 2:
                        pX = (int) (dPantallaDimension.getWidth() - dPantallaDimension.getWidth());
                        pY = (int) dPantallaDimension.getHeight() - fraVent.getHeight();
                        fraVent.setLocation(pX, pY);
                        break;
                    case 3:
                        pX = (int) dPantallaDimension.getWidth() - fraVent.getWidth();
                        pY = (int) dPantallaDimension.getHeight() - fraVent.getHeight();
                        fraVent.setLocation(pX, pY);
                        break;
                    default:
                        pX = 400;
                        pY = 200;
                        fraVent.setLocation(pX, pY);
                        break;
                }
            }

        });
    }
    
    public static void main(String[] args) {
        fraListeners fraL = new fraListeners();

        fraL.ventExec();
    }
}
