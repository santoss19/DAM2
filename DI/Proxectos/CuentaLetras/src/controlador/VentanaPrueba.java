package controlador;

import java.util.Scanner;

import javax.swing.JOptionPane;

import modelo.Frase;
import modelo.Grados;
import vista.VentanaGrados;
import vista.VentanaLetras;

public class VentanaPrueba {

    String txtFar;
    String txtCent;

    public void letrasVentExec() {
        VentanaLetras vent = new VentanaLetras();
        Frase frase = new Frase();
        vent.bot.addActionListener(actionListener -> {
            frase.setFrase(vent.wText.getText());
            vent.text1.setText(frase.contarCaracteres() + "");
            vent.text2.setText(frase.contaPalabras() + "");
        });
    }

    public void gradosVentExec() {
        VentanaGrados vent = new VentanaGrados();
        Grados gr = new Grados();

        vent.tFar.setText("32.0");
        vent.tCent.setText("0.0");

        txtFar = vent.tFar.getText();
        txtCent = vent.tCent.getText();

        vent.bot.addActionListener(actionListener -> {

            if(txtFar.equals(vent.tFar.getText())) {
                gr.setgCent(Double.parseDouble(vent.tCent.getText()));
                gr.setgFar(Double.parseDouble(vent.tFar.getText()));
                vent.tFar.setText(gr.pasaCentToFar() + "");
            } else if(txtCent.equals(vent.tCent.getText())) {
                gr.setgFar(Double.parseDouble(vent.tFar.getText()));
                gr.setgCent(Double.parseDouble(vent.tCent.getText()));
                vent.tCent.setText(gr.pasaFarToCent() + "");
            } else {
                JOptionPane.showConfirmDialog(vent, "No cambies las dos, solo funciono cambiando uno de los valores", "ERROR", JOptionPane.DEFAULT_OPTION);
            }

            txtFar = vent.tFar.getText();
            txtCent = vent.tCent.getText();
        });

    }

    public static void main(String[] args) {
        VentanaPrueba vent = new VentanaPrueba();
        Scanner teclado = new Scanner(System.in);
        boolean bol = false;

        while(bol != true) {
            System.out.print("Elige ventana a ejecutar (A = CuentaLetras; B = Grados): ");
            String letra = teclado.next();
            if(letra.equals("A")) {
                bol = true;
                vent.letrasVentExec();
                teclado.close();
            } else if(letra.equals("B")) {
                bol = true;
                vent.gradosVentExec();
                teclado.close();
            } else {
                System.err.println("Letra introducida incorrecta");
            }
        }
    }
}
