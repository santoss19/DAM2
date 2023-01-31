package ej1;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Hilo_EJ1 h1 = new Hilo_EJ1();    
        System.out.println("Estado del hilo: " + h1.isAlive());
        h1.start();
        System.out.println("Estado del hilo: " + h1.isAlive());
        h1.join();
        System.out.println("Estado del hilo: " + h1.isAlive());
        
    }
}
