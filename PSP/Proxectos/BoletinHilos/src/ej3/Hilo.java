package ej3;

public class Hilo extends Thread{

    static int contador = 0;
    private String cadena = "";

    public Hilo(String cadena) {
        super();
        this.cadena = cadena; 
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            contador++;
            System.out.print(contador + ":" + cadena + " ");
        }
    }


}