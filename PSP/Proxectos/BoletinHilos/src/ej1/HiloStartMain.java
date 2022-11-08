package ej1;

public class HiloStartMain extends Thread {
    public static void main(String[] args) {
        HiloRun hr = new HiloRun();
        hr.start();
        System.out.println();
        for(int i = 0; i < 30; i++) {
            System.out.println("YES");
        }
    }
}