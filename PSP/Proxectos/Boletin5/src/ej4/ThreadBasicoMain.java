package ej4;

public class ThreadBasicoMain {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(new ThreadBasico("Buenos días"));
        Thread hilo2 = new Thread(new ThreadBasico("Buenas noches"));

        hilo1.start();
        hilo2.start();
    }
}
