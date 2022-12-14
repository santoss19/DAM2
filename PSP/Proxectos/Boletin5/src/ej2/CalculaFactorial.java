package ej2;

public class CalculaFactorial extends Thread {
    
    int num = 0;
    int resultado = 1;

    public CalculaFactorial(int numero) {
        num = numero;
    }

    @Override
    public void run() {
        System.out.println("Empieza el proceso... Calculo del factorial de :" + num);
        if(num == 0) {
            System.out.println("Acabo el proceso.... El factorial de : 0 es 1");
        } else {
            for(int i = 1; i < num; i++) {
                resultado += resultado * i; 
            }
            System.out.println("Acabo el proceso.... El factorial de : " + num + " es " + resultado);
        }
    }

}
