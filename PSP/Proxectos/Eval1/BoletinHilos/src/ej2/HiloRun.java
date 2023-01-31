package ej2;

public class HiloRun extends Thread {
    @Override
    public void run() {
        for(int i = 0;  i < 30; i++) {
            System.out.print("NO");
        }
    }
}
