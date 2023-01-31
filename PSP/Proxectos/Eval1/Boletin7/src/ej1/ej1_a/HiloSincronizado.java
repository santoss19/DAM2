package ej1.ej1_a;

public class HiloSincronizado extends Thread {

    public HiloSincronizado(String nombreHillo) {
        setName(nombreHillo);
    }
    
    @Override
    public void run() {
        Cola queue = new Cola();

        System.out.println("¡En marcha! ... " + getName());
        synchronized(queue) {
            queue.dibujar(getName());
        }
    }
}
