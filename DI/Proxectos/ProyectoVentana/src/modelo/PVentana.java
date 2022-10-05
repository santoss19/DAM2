package modelo;
import controlador.AccionBoton1;
import controlador.AccionBoton2;
import controlador.AccionBoton2_BL;

public class PVentana {

    public PVentana() {}

    public void FLVentana() {
        FLVentana fl = new FLVentana();
        fl.bot1.addActionListener(new AccionBoton1(fl));
        fl.bot2.addActionListener(new AccionBoton2(fl.panel));
    }

    public void BLVentana() {
        BLVentana bl = new BLVentana();
        bl.bot1.addActionListener(new AccionBoton1(bl));
        bl.bot2.addActionListener(new AccionBoton2_BL(bl.panelN, bl.panelS, bl.panelC));
    }

    public static void main(String[] args) {
        PVentana pv = new PVentana();
        pv.FLVentana();
    }
}
