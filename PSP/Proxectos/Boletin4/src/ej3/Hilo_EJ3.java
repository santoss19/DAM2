package ej3;

public class Hilo_EJ3 implements Runnable {
    
    @Override
    public void run() {
        System.out.println("Hilo en ejecución ...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            System.err.println("ERROR: " + e);
        }
    }
}
