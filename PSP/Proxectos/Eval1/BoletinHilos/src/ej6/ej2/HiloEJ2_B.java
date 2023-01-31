package ej6.ej2;

public class HiloEJ2_B implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 30; i++) {
            System.out.print("YES");
        }
    }
}
