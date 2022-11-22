package ej4;

public class Main {
    public static void main(String[] args) {
        Hilo_EJ4 hilo = new Hilo_EJ4();
        Thread hilo1 = new Thread(hilo);

        System.out.println("Aún no se ha iniciado el hilo");
        try {
            hilo1.run();
            hilo1.join();
        } catch(InterruptedException e) {
            System.err.println(e);
        }
        System.out.println(" Hilo1 terminado");
        System.out.println("Fin del programa");

    }
}
