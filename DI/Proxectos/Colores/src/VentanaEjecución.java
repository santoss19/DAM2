import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import vista.WindDesign;

public class VentanaEjecución {

    public void ventExec() {
        WindDesign wd = new WindDesign();
        JTextField[] texts = wd.getTexts();
        JButton[] buttons = wd.getBotones();
        JScrollBar[] scrollBars = wd.getScrollBars();

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
                text.addKeyListener(new KeyListener() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyChar() == e.VK_ENTER) {
                            if(Integer.parseInt(text.getText()) > 255) {
                                JDialog dia = new JDialog();
                                JLabel label = new JLabel("No puedes introducir un valor más grande que 255");
                                dia.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                                dia.setSize(310,100);
                                label.setAlignmentX(SwingConstants.CENTER);
                                dia.add(label);
                                dia.setVisible(true);
                                text.setText("0");
                            } else {
                                panel.setBackground(new Color(Integer.parseInt(text.getText()), panel.getBackground().getGreen(), panel.getBackground().getBlue()));
                                scrollBars[0].setValue(Integer.parseInt(text.getText()));
                            }
                        }
                    }
    
                    @Override
                    public void keyReleased(KeyEvent e) {}
                    @Override
                    public void keyTyped(KeyEvent e) {}
                });
            } else if(k == 1) {
                text.addKeyListener(new KeyListener() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyChar() == e.VK_ENTER) {
                            if(Integer.parseInt(text.getText()) > 255) {
                                JDialog dia = new JDialog();
                                JLabel label = new JLabel("No puedes introducir un valor más grande que 255");
                                dia.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                                dia.setSize(310,100);
                                label.setAlignmentX(SwingConstants.CENTER);
                                dia.add(label);
                                dia.setVisible(true);
                                text.setText("0");
                            } else {
                                panel.setBackground(new Color(panel.getBackground().getRed(), Integer.parseInt(text.getText()), panel.getBackground().getBlue()));
                                scrollBars[1].setValue(Integer.parseInt(text.getText()));
                            }
                        }
                    }
    
                    @Override
                    public void keyReleased(KeyEvent e) {}
                    @Override
                    public void keyTyped(KeyEvent e) {}
                });
            } else if(k == 2) {
                text.addKeyListener(new KeyListener() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyChar() == e.VK_ENTER) {
                            if(Integer.parseInt(text.getText()) > 255) {
                                JDialog dia = new JDialog();
                                JLabel label = new JLabel("No puedes introducir un valor más grande que 255");
                                dia.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                                dia.setSize(310,100);
                                label.setAlignmentX(SwingConstants.CENTER);
                                dia.add(label);
                                dia.setVisible(true);
                                text.setText("0");
                            } else {
                                panel.setBackground(new Color(panel.getBackground().getRed(), panel.getBackground().getGreen(), Integer.parseInt(text.getText())));
                                scrollBars[2].setValue(Integer.parseInt(text.getText()));
                            }
                        }
                    }
    
                    @Override
                    public void keyReleased(KeyEvent e) {}
                    @Override
                    public void keyTyped(KeyEvent e) {}
                });
            }
        }
    }
    public static void main(String[] args) throws Exception {
        VentanaEjecución vent = new VentanaEjecución();
        vent.ventExec();
    }
}
