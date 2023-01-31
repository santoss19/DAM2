package ej1;

public class MainContador {
    public static void main(String[] args) throws Exception {
      
        Contador cont = new Contador();

        ContadorHilo h1 = new ContadorHilo("Hilo 1", cont);
        ContadorHilo h2 = new ContadorHilo("Hilo 2", cont);
        ContadorHilo h3 = new ContadorHilo("Hilo 3", cont);
        ContadorHilo h4 = new ContadorHilo("Hilo 4", cont);

        h2.start();
        h4.start();
        h1.start();
        h3.start();

        System.out.println("FIN DEL MAIN ...");

    }
}
