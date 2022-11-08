import java.awt.Color;
import java.awt.Container;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import vista.WindDesign;

public class VentanaEjecución {

    public boolean comprobaLetras(JTextField texto) { //Comproba se hai letras no String que devolve o TextField
        String cadena = texto.getText();
        for(int j = 0; j < cadena.length(); j++) {
            char letra = cadena.charAt(j);
            if((char)letra > 'A' && (char)letra < 'z') {
                return true;
            }
        }
        return false;
    }

    public void ventExec() {
        WindDesign wd = new WindDesign();
        JTextField[] texts = wd.getTexts();
        JButton[] buttons = wd.getBotones();
        JScrollBar[] scrollBars = wd.getScrollBars();

        //Debug inicio (Setea as barras e os textos cos valores RGB do fondo default)//

        int r = wd.getPanelC().getBackground().getRed();
        int g = wd.getPanelC().getBackground().getGreen();
        int b = wd.getPanelC().getBackground().getBlue();

        for(int p=0; p < texts.length;p++) {
            if(p == 0) {
                texts[p].setText(r + "");
                scrollBars[p].setValue(r);
            } else if(p==1) {
                texts[p].setText(g + "");
                scrollBars[p].setValue(g);
            } else if(p==2) {
                texts[p].setText(g + "");
                scrollBars[p].setValue(g);
            }
        }

        //

        for(int i = 0; i < buttons.length; i++) {
            JButton but = buttons[i];
            but.addActionListener(listener -> {
                wd.getPanelC().setBackground(but.getBackground());
                for(int j = 0; j < scrollBars.length; j++) {
                    if(j == 0) {
                        scrollBars[j].setValue(but.getBackground().getRed());
                        texts[j].setText(but.getBackground().getRed() + "");
                    } else if(j == 1) {
                        scrollBars[j].setValue(but.getBackground().getGreen());
                        texts[j].setText(but.getBackground().getGreen() + "");
                    } else if(j == 2) {
                        scrollBars[j].setValue(but.getBackground().getBlue());
                        texts[j].setText(but.getBackground().getBlue() + "");
                    }
                }
            });
        }

        for(int j = 0; j < scrollBars.length; j++) {
            JScrollBar scrollBar = scrollBars[j];
            Container panel = wd.getPanelC();
            if(j == 0) {
                scrollBar.addAdjustmentListener(listener -> {
                    panel.setBackground(new Color(scrollBar.getValue(), panel.getBackground().getGreen(), panel.getBackground().getBlue()));
                    texts[0].setText(scrollBar.getValue() + "");
                    texts[1].setText(panel.getBackground().getGreen() + "");
                    texts[2].setText(panel.getBackground().getBlue() + "");
                });
            } else if(j == 1) {
                scrollBar.addAdjustmentListener(listener -> {
                    panel.setBackground(new Color(panel.getBackground().getRed(), scrollBar.getValue(), panel.getBackground().getBlue()));
                    texts[0].setText(panel.getBackground().getRed() + "");
                    texts[1].setText(scrollBar.getValue() + "");
                    texts[2].setText(panel.getBackground().getBlue() + "");
                });
            } else if(j == 2) {
                scrollBar.addAdjustmentListener(listener -> {
                    panel.setBackground(new Color(panel.getBackground().getRed(), panel.getBackground().getGreen(), scrollBar.getValue()));
                    texts[0].setText(panel.getBackground().getRed() + "");
                    texts[1].setText(panel.getBackground().getGreen() + "");
                    texts[2].setText(scrollBar.getValue() + "");
                });
            }
        }

        for(int k = 0; k < texts.length; k++) {
            JTextField text = texts[k];
            Container panel = wd.getPanelC();
            if(k == 0) {
                text.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {}
                    
                    @Override
                    public void focusLost(FocusEvent e) {
                        int num = 0;
                        if(comprobaLetras(text) == true) {
                            JDialog dia = new JDialog();
                            JLabel label = new JLabel("No puedes introducir letras");
                            dia.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                            dia.setSize(310,100);
                            label.setAlignmentX(SwingConstants.CENTER);
                            dia.add(label);
                            dia.setVisible(true);
                            text.setText("0");
                        } else {
                            if(text.getText().isEmpty() != true) num = Integer.parseInt(text.getText());
                            if(num > 255) {
                                JDialog dia = new JDialog();
                                JLabel label = new JLabel("No puedes introducir un valor más grande que 255");
                                dia.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                                dia.setSize(310,100);
                                label.setAlignmentX(SwingConstants.CENTER);
                                dia.add(label);
                                dia.setVisible(true);
                                text.setText("0");
                            } else {
                                panel.setBackground(new Color(num, panel.getBackground().getGreen(), panel.getBackground().getBlue()));
                                scrollBars[0].setValue(num);
                                text.setText(num + "");
                            }
                        }
                    }
                });
            } else if(k == 1) {
                text.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {}
                    
                    @Override
                    public void focusLost(FocusEvent e) {
                        int num = 0;
                        if(comprobaLetras(text) == true) {
                            JDialog dia = new JDialog();
                            JLabel label = new JLabel("No puedes introducir letras");
                            dia.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                            dia.setSize(310,100);
                            label.setAlignmentX(SwingConstants.CENTER);
                            dia.add(label);
                            dia.setVisible(true);
                            text.setText("0");
                        } else {
                            if(text.getText().isEmpty() != true) num = Integer.parseInt(text.getText());
                            if(num > 255) {
                                JDialog dia = new JDialog();
                                JLabel label = new JLabel("No puedes introducir un valor más grande que 255");
                                dia.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                                dia.setSize(310,100);
                                label.setAlignmentX(SwingConstants.CENTER);
                                dia.add(label);
                                dia.setVisible(true);
                                text.setText("0");
                            } else {
                                panel.setBackground(new Color(panel.getBackground().getRed(), num, panel.getBackground().getBlue()));
                                scrollBars[1].setValue(num);
                                text.setText(num + "");
                            }
                        }
                    }
                });
            } else if(k == 2) {
                text.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {}
                    
                    @Override
                    public void focusLost(FocusEvent e) {
                        int num = 0;
                        if(comprobaLetras(text) == true) {
                            JDialog dia = new JDialog();
                            JLabel label = new JLabel("No puedes introducir letras");
                            dia.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                            dia.setSize(310,100);
                            label.setAlignmentX(SwingConstants.CENTER);
                            dia.add(label);
                            dia.setVisible(true);
                            text.setText("0");
                        } else {
                            if(text.getText().isEmpty() != true) num = Integer.parseInt(text.getText());
                            if(num > 255) {
                                JDialog dia = new JDialog();
                                JLabel label = new JLabel("No puedes introducir un valor más grande que 255");
                                dia.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                                dia.setSize(310,100);
                                label.setAlignmentX(SwingConstants.CENTER);
                                dia.add(label);
                                dia.setVisible(true);
                                text.setText("0");
                            } else {
                                panel.setBackground(new Color(panel.getBackground().getRed(),panel.getBackground().getGreen(), num));
                                scrollBars[2].setValue(num);
                                text.setText(num + "");
                            }
                        }
                    }
                });
            }
        }
    }
    public static void main(String[] args) throws Exception {
        VentanaEjecución vent = new VentanaEjecución();
        vent.ventExec();
    }
}
