package ej4;

import java.util.Random;

public class ThreadBasico implements Runnable {

    private String frase;
    private Random rnd;

    public ThreadBasico(String newFrase) {
        frase = newFrase;
        rnd = new Random();
    }

    public void run() {
        int i = 0;
        while (i < (long)(Math.abs(rnd.nextInt())%1000)) {
            System.out.println(frase);
            i++;
        }
    }

}
