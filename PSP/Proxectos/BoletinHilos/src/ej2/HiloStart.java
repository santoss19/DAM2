package ej2;

public class HiloStart extends Thread{
    @Override
    public void run() {
        System.out.println();
        for(int i = 0; i < 30; i++) {
            System.out.print("YES");
        }
    }
}
