package ej2;

public class Hilo extends Thread{

    Listado salida = null;
    boolean sem = true;

    public Hilo(Listado li) {
        salida = li;
    }

    @Override
    public void run() {
        synchronized(this.salida) {
            this.salida.mostrar();
        }
    }
}