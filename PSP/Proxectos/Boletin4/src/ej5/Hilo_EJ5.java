package ej5;

public class Hilo_EJ5 extends Thread {
    
    public Hilo_EJ5(String nom) {
        super(nom);
    }
    
    public void run() {
        for(int i = 1; i <= 10; i++) {
            System.out.print(i);
        }
    }
}
