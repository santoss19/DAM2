package ej2;

public class Main {

    public static void main(String[] args) {
        CalculaFactorial[] hilos = {new CalculaFactorial(5), new CalculaFactorial(6), new CalculaFactorial(7), new CalculaFactorial(8), 
        new CalculaFactorial(9), new CalculaFactorial(10), new CalculaFactorial(11), 
        new CalculaFactorial(12), new CalculaFactorial(13), new CalculaFactorial(14)};
        
        for(int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }

        System.out.println("Programa principal terminado");
    }

}
