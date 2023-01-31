package ej2;

public class Hilo2_EJ2 extends Thread{
    
    int tiempoDormido;
    
    public Hilo2_EJ2() {
        tiempoDormido = (int) (Math.random() * 10000);
    }

    @Override
    public void run() {
        try {
            System.out.println(getClass().getSimpleName() + " se va a dormir (" + tiempoDormido + " ms) ...." );
            sleep(tiempoDormido);
            System.out.println(getClass().getSimpleName() + " se ha despertado");
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

}
