public class HiloA extends Thread {

    protected int contador = 0;
    protected boolean ejecutar = true;

    public HiloA(String name, int cont) {
        this.setName(name);
        this.contador = cont;
    }

    public void para()  {
        ejecutar = false;
    }

    @Override
    public void run() {
        while(ejecutar) { 
            contador++;
        }
        System.out.println("Contador " + getName() + ": " + contador);
    }

    public int getContador() {
        return contador;
    }
    
}
