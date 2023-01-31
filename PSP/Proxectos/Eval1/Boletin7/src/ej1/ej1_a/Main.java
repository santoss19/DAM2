package ej1.ej1_a;

public class Main {
    public static void main(String[] args) {
        
        HiloSincronizado h1 = new HiloSincronizado("Luhish");
        HiloSincronizado h2 = new HiloSincronizado("Oscar");
        HiloSincronizado h3 = new HiloSincronizado("Alvaro");
        HiloSincronizado h4 = new HiloSincronizado("Alberto");

        h1.run();
        h2.run();
        h3.run();
        h4.run();

        System.out.println("Hemos terminado amiguitos ...");
    }
}
