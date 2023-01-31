package ej2;

public class Main {
    
    public static void main(String[] args) {

        Listado list = new Listado();

        Hilo h1 = new Hilo(list);
        Hilo h2 = new Hilo(list);

        h1.start();
        h2.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            System.out.println("Interrumpido");
        }

        System.out.println("\n He terminado");
    }

}
