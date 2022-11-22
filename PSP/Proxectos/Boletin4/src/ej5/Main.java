package ej5;

public class Main {
    public static void main(String[] args) {
        Hilo_EJ5 h1 = new Hilo_EJ5("Hilo1");
        Hilo_EJ5 h2 = new Hilo_EJ5("Hilo2");

        System.out.println("Aún no se han iniciado los hilos");

        try {
            h1.start();
            h1.join();
        } catch(InterruptedException e) {
            System.err.println(e);
        }  

        System.out.println(h1.getName() + " ha terminado");

        try {
            h2.start();
            h2.join();
        } catch(InterruptedException e) {
            System.err.println(e);
        }  

        System.out.println(h2.getName() + " ha terminado");
        System.out.println("Programa terminado");
        
    }
}
