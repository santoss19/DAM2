package ej3;

public class Main {
    public static void main(String[] args) {
        Hilo h1 = new Hilo("SI");
        Hilo h2 = new Hilo("NO");

        h1.start();
        h2.start();
    }
}