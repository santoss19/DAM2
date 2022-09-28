import modelo.NumeroEnteroHijo;

public class Aritmetica {
    public static void main(String[] args) throws Exception {
        
        NumeroEnteroHijo neh = new NumeroEnteroHijo(3, 5);

        System.out.println(neh.sumaNumeros());
        System.out.println(neh.restaNumeros());
        System.out.println(neh.comparaNumeros());

    }
}
