package ej1;


public class Hilo_EJ1 extends Thread {
    
    @Override
    public void run() {
        try{
            sleep(2000);
        } catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
