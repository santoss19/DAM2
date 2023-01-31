package ej1.ej1_b;

public class Cola {
    
    boolean disponible = true;

    synchronized public void dibujar(String nombreHilo) {
        while(!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        try {
            disponible = false;
            Thread.sleep(2000);
            System.out.println("¡He llegado! ... " + nombreHilo);
        } catch (InterruptedException ex) {}
    } 

}
