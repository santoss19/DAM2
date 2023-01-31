package ej2;

public class HiloMain {
    public static void main(String[] args) {
        HiloRun hr = new HiloRun();
        HiloStart hs = new HiloStart();
        
        System.out.println("Ejecucion en Hilo A");
        hr.start();
        System.out.println("Ejecucion en Hilo B");
        hs.start();
        System.out.println("Ejecucion en Hilo Main");
    }
}
