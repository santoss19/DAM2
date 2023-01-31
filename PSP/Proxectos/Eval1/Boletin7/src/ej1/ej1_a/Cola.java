package ej1.ej1_a;

public class Cola {
    
    boolean disponible = true;

    public void dibujar(String nombreHilo) {
        while(!disponible) {
            try{
                wait();
            } catch(InterruptedException ex) {}
        }

        try {
            disponible = false;
            Thread.sleep(2000);
            System.out.println("¡He terminado! ... " + nombreHilo);
        } catch(InterruptedException ex) {
            System.err.println("ERROR: Interrupción");
        }
    } 
}
