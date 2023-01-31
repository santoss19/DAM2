package ej4;

public class Hilo extends Thread {
    
    private int principio;
    private int fin;
    private String nH;

    public Hilo(int p, int f, String nombreHilo) {
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
