package ej2;

public class Terminal extends Thread {
    
    protected Cajero cj = null;
    private int misVentas = 0;

    public Terminal(String nombre, Cajero cajero) {
        setName(nombre);
        cj = cajero;
    }


    protected void getMisVentas() {
        System.out.println("El " + getName() + " vendio " + misVentas + " unidades");
    }

    @Override
    public void run() {
        synchronized(cj) {
            for(misVentas = 0; misVentas < 20000; misVentas++) {
                cj.sumarLocalidades();
            }
            this.getMisVentas();
        }
       
    }

}
