package ej3;

public class ContarThread extends Thread{

    private static int maxContar = 0;

    public ContarThread(int num) {
        maxContar = num;
    }

    @Override
    public void run() {
        for(int i = 0; i < maxContar; i++) {
            System.out.println("Repetición: " + i);
            System.out.println("Nombre del hilo: " + this.getName());
            try {
                this.sleep(2000);
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }
        }    
    }
    
}
