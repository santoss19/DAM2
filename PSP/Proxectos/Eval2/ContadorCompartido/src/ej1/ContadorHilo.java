package ej1;

public class ContadorHilo extends Thread {
    
    Contador contador = null;

    public ContadorHilo(String nombre, Contador cont) {
        setName(nombre);
        this.contador = cont;
    }

    protected void dormir() {
        try {
            sleep((long) (Math.random() * 1000) + 500);    
        } catch (InterruptedException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        //synchronized(contador) {
            for(int i = 0; i < 3; i++) {
                //dormir();
                contador.setContador(contador.getContador() + 1);
                System.out.println(getName() + " puso el valor del contador en .... " + contador.getContador());   
            }
            System.out.println(getName() + " ha acabado");
        //} 
    }
}
