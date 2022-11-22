import java.awt.Color;
import java.awt.Font;
import java.net.http.WebSocket.Listener;

import vista.Ventana;

public class VentExec {

    public void exec() {
        Ventana vent = new Ventana();
        
        vent.getNeg().addItemListener(listener -> {
            vent.getText().setForeground(Color.WHITE);
            vent.getPanel().setBackground(Color.BLACK);
            vent.getText().setBackground(Color.BLACK);
        });

        vent.getAzu().addItemListener(listener -> {
            vent.getText().setForeground(Color.BLACK);
            vent.getPanel().setBackground(Color.BLUE);
            vent.getText().setBackground(Color.BLUE);
        });

        vent.getRoj().addItemListener(listener -> {
            vent.getText().setForeground(Color.BLACK);
            vent.getPanel().setBackground(Color.RED);
            vent.getText().setBackground(Color.RED);
        });

        vent.getVer().addItemListener(listener -> {
            vent.getText().setForeground(Color.BLACK);
            vent.getPanel().setBackground(Color.GREEN);
            vent.getText().setBackground(Color.GREEN);
        });

        vent.getBold().addItemListener(listener -> {
            vent.getText().setFont(new Font(vent.getText().getFont().getName(), Font.BOLD, vent.getText().getFont().getSize()));
        });

        vent.getItalic().addItemListener(listener -> {
            vent.getText().setFont(new Font(vent.getText().getFont().getName(), Font.ITALIC, vent.getText().getFont().getSize()));
        });

        vent.getSer().addItemListener(listener -> {
            vent.getText().setFont(new Font(Font.SERIF, vent.getText().getFont().getStyle(), vent.getText().getFont().getSize()));
        });

        vent.getSsf().addItemListener(listener -> {
            vent.getText().setFont(new Font(Font.SANS_SERIF, vent.getText().getFont().getStyle(), vent.getText().getFont().getSize()));
        });

        vent.getMon().addItemListener(listener -> {
            vent.getText().setFont(new Font(Font.MONOSPACED, vent.getText().getFont().getStyle(), vent.getText().getFont().getSize()));
        });

    }

    public static void main(String[] args) throws Exception {
        VentExec ex = new VentExec();
        ex.exec();
    }
}
