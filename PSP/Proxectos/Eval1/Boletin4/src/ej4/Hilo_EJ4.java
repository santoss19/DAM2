package ej4;

public class Hilo_EJ4 implements Runnable {
    public void run() {
        for(int i = 1; i <= 10; i++) {
            System.out.print(i);
        }
    }
}
