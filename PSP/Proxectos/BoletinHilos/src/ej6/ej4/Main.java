package ej6.ej4;

public class Main {
    public static void main(String[] args) {
        HiloEJ4 h1 = new HiloEJ4(1, 10, "HiloA");
        HiloEJ4 h2 = new HiloEJ4(20, 30, "HiloB");

        System.out.println("Iniciando hilos ...");
        System.out.println("Hilos iniciados");
        System.out.println("Programa terminado");
        h1.run();
        h2.run();
    }
}
