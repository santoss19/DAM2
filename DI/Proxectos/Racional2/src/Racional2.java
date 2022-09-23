import controlador.Racional2_H;
import modelo.Racional;

public class Racional2 {
    public static void main(String[] args) {

        Racional r1 = new Racional();
        Racional r2 = new Racional();

        r1.asignarDatos(5, 4);
        r2.asignarDatos(3, 2);

        Racional2_H r = new Racional2_H(r1, r2);

        System.out.println(r.sumarRacionales().toString());
        System.out.println(r.restarRacionales().toString());
        System.out.println(r.multiplicarRacionales().toString());
        System.out.println(r.dividirRacionales().toString());

    }
}
