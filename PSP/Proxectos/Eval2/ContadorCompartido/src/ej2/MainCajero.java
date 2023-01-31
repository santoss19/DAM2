package ej2;

public class MainCajero {
    public static void main(String[] args) {
        
        Cajero caj = new Cajero("Cajero Mercadona");
        Terminal t1 = new Terminal("Terminal 1", caj);
        Terminal t2 = new Terminal("Terminal 2", caj);
        Terminal t3 = new Terminal("Terminal 3", caj);

        caj.getNombre();
        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Interrumpido");
        }

        caj.totalLocalidades();

        System.out.println("FIN DEL PROGRAMA..");
    }
}
