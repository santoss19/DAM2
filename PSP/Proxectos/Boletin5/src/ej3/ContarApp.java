package ej3;

public class ContarApp {

    public static void main(String[] args) {
        ContarThread hilo1 = new ContarThread(10);
        ContarThread hilo2 = new ContarThread(10);

        hilo1.start();
        try {
            hilo1.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            System.err.println("ERROR: " + e);
        }
        hilo2.start();
        
        while (hilo1.isAlive() && hilo2.isAlive()) {
            System.out.println("Sigo contando...");
            try {
                hilo1.sleep(1000);
                hilo2.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                System.err.println("ERROR: " + e);
            }
        }
    }

}
