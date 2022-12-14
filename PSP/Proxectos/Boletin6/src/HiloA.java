public class HiloA extends Thread {

    int contador = 0;

    public HiloA(String name, int cont) {
        this.setName(name);
        this.contador = cont;
    }

    @Override
    synchronized public void run() {
        for(int i = 0; true; i++) {System.out.println("Contador " + getName() + ": " + contador); contador++;}
    }   
}
