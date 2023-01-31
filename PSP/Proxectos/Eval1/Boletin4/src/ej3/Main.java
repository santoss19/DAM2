package ej3;

public class Main {
    public static void main(String[] args) {
        Hilo_EJ3 h1 = new Hilo_EJ3();
        Thread hilo1 = new Thread(h1);

        hilo1.setName("Hiliño");
        hilo1.run();
        System.out.println("Terminó: " + hilo1.getName());
        System.out.println("Prioridad: " + hilo1.getPriority());
    }
}
