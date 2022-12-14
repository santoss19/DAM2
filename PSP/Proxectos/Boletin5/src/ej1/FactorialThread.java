package ej1;

public class FactorialThread extends Thread {

    int num = 0;
    int resultado = 1;

    public FactorialThread(int numero) {
        num = numero;
    }

    @Override
    public void run() {
        if(num == 0) {
            System.out.println("El factorial de : 0 es 1");
        } else {
            for(int i = 1; i < num; i++) {
                resultado += resultado * i; 
            }
            System.out.println("El factorial de : " + num + " es " + resultado);
        }
    }
}
