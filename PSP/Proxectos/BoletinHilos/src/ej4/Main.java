package ej4;

public class Main {
    public static void main(String[] args) {
        Hilo h1 = new Hilo(1, 10, "HiloA");
        Hilo h2 = new Hilo(20, 30, "HiloB");

        System.out.println("Iniciando hilos ...");
        System.out.println("Hilos iniciados");
        System.out.println("Programa terminado");
        h1.start();
        h2.start();
    }
}
