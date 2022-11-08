import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vista.WindDesign;

public class WindExec {

    public void ventExec() { // Método da ejecución da Vista e da implementación dos Listener
        WindDesign wd = new WindDesign();

        wd.getTexto().addKeyListener(new KeyListener() { // KeyListener para que cando se pulsa a tecla ENTER copie a frase no Label
            @Override 
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == e.VK_ENTER) {
                    wd.getFrase().setText(wd.getTexto().getText());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
            @Override
            public void keyTyped(KeyEvent e) {}
        });

        wd.getB12().addChangeListener(listener -> { // ChangeListener para que cando se selecciona o boton 12 cambie o tamaño de letra
            if(wd.getB12().isSelected()) {
                wd.getFrase().setFont(new Font(wd.getFrase().getFont().getFontName(), wd.getFrase().getFont().getStyle(), 12));
            } 
        });

        wd.getB18().addChangeListener(listener -> { // ChangeListener para que cando se selecciona o boton 18 cambie o tamaño de letra
            if(wd.getB18().isSelected()) {
                wd.getFrase().setFont(new Font(wd.getFrase().getFont().getFontName(), wd.getFrase().getFont().getStyle(), 18));
            }
        });

        wd.getB24().addChangeListener(listener -> { // ChangeListener para que cando se selecciona o boton 24 cambie o tamaño de letra
            if(wd.getB24().isSelected()) {
                wd.getFrase().setFont(new Font(wd.getFrase().getFont().getFontName(), wd.getFrase().getFont().getStyle(), 24));
            }
        });

        wd.getCheck().addChangeListener(listener -> { // ChangeListener para alternar entre Cursiva e Negrita
            if(wd.getCheck().isSelected() == true) {
                wd.getFrase().setFont(new Font(wd.getFrase().getFont().getFontName(), Font.ITALIC, wd.getFrase().getFont().getSize()));
            } else if(wd.getCheck().isSelected() == false) {
                wd.getFrase().setFont(new Font("Dialog", Font.BOLD, wd.getFrase().getFont().getSize())); // Usar nombre da fuente, non a reconoce con "getFontName()"
            }
        });
    }
    public static void main(String[] args) throws Exception {
        WindExec ex = new WindExec();
        ex.ventExec();
    }
}
