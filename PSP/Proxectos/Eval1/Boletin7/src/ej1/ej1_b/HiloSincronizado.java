package ej1.ej1_b;

public class HiloSincronizado extends Thread{

    public HiloSincronizado(String nombreHilo) {
        setName(nombreHilo);
    }
    
    @Override
    public void run() {
        Cola queue = new Cola();
        System.out.println("¡En marcha! ... " + getName());
        queue.dibujar(getName());
    }

}
