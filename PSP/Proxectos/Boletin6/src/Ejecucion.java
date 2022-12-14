public class Ejecucion {
    public static void main(String[] args) throws Exception {

        HiloA h1 = new HiloA("HiloA", 0);
        HiloA h2 = new HiloA("HiloB", 10);

        h1.setPriority(Thread.MAX_PRIORITY);
        h2.setPriority(Thread.MIN_PRIORITY);

        h1.start();
        h2.start();
        
        System.out.println("FIN DE LA EJECUCIÓN");
    }
}
