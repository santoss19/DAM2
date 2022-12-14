package ej1;

public class FibonacciThread extends Thread {

    int num = 0;
    int resultado = 0;

    public FibonacciThread(int numero) {
        num = numero;
    }

    @Override
    public void run() {
        if(num == 0) {
            System.out.println("El resultado del número Fibonacci del numero : 0 es 0");
        } else if(num == 1) {
            System.out.println("El resultado del número Fibonacci del numero : 1 es 1");
        } else {
            resultado = (num - 1) + (num - 2);
            System.out.println("El resultado del número Fibonacci del numero : " + num + " es " + resultado);
        }
    }

}

