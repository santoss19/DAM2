package ej6.ej4;

public class HiloEJ4 implements Runnable{
    private int principio;
    private int fin;
    private String nH;

    public HiloEJ4(int p, int f, String nombreHilo) {
        super();
        principio = p ;
        fin = f;
        nH = nombreHilo;
    }

    public void run() {
        System.out.println(nH + " empieza....");
        for(int i = principio; i <= fin; i++) {
            System.out.println(nH + " dice: " + i);
        }
    }

}
