import modelo.Frase;

public class FraseApp {
    public static void main(String[] args) throws Exception {
        Frase frase = new Frase();

        System.out.print("Escribe tu frase = ");
        frase.recollerFrase();
        System.out.println("Frase sin espacios de más = " + frase.eliminarEspacios());
        System.out.println("Número de caracteres de la frase = " + frase.contarCaracteres());
        System.out.println("Frase invertida = " + frase.cadenaInvertida());
        System.out.println("Número de palabaras de la frase = " + frase.contaPalabras());
        System.out.println("Posición de la primera vocal de la frase = " + frase.primeraVocal());
        System.out.println("Posición de la última vocal de la frase = " + frase.ultimaPosicion());
        System.out.println("¿Mayúscula la primera letra? = " + frase.comprobaMayucula());
        System.out.println("Frase en mayúsculas = " + frase.convertirMayusculas());
        System.out.println("Frase en minúsculas = " + frase.convertirMinusculas());
        System.out.print("Frase en vector = ");
        frase.convertirVector();
    }
}
