package ej6.ej3;

public class HiloEJ3 implements Runnable{
    static int contador = 0;
    private String cadena = "";

    public HiloEJ3(String cadena) {
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
