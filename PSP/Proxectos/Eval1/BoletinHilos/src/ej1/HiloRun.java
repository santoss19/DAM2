package ej1;

public class HiloRun extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 30; i++) {
            System.out.println("NO");
        }
    }
}
