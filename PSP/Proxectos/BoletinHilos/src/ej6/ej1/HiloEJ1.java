package ej6.ej1;

public class HiloEJ1 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 30; i++) {
            System.out.println("NO");
        }
    }
}
