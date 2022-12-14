package ej1;

public class Main {
    public static void main(String[] args) {
        
        FactorialRun frun = new FactorialRun(5);
        FactorialThread fthread = new FactorialThread(5);
        FibonacciRun fibRun = new FibonacciRun(8);
        FibonacciThread fibThread = new FibonacciThread(8);

        System.out.println("=== SALIDA RUNNABLE ===");
        frun.run();
        fibRun.run();
        System.out.println("==== SALIDA THREAD ====");
        fthread.start();
        fibThread.start();

    }
}
