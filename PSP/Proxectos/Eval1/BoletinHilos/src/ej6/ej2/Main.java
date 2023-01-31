package ej6.ej2;

public class Main {
    public static void main(String[] args) {
        HiloEJ2_A hr = new HiloEJ2_A();
        HiloEJ2_B hs = new HiloEJ2_B();
        
        System.out.println("Ejecucion en Hilo A");
        hr.run();
        System.out.println();
        System.out.println("Ejecucion en Hilo B");
        hs.run();
        System.out.println();
        System.out.println("Ejecucion en Hilo Main");
    }
}
