package modelo;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Frase {
    
    private String frase;

    public Frase() {}

    public void recollerFrase() {
       Scanner teclado = new Scanner(System.in);
       frase = teclado.nextLine();
       teclado.close();
    }

    public void mostraFrase() {
        System.out.println(frase);
    }

    public String eliminarEspacios() {
        frase = frase.trim();
        return frase;
    }

    public int contarCaracteres() {
        char[] fraseChar = frase.toCharArray();
        int numCarac = 0;

        for(int i = 0; i < fraseChar.length; i++) {
            if(fraseChar[i] != ' ' && fraseChar[i] != ',' && fraseChar[i] != ';' && fraseChar[i] != ':' && fraseChar[i] != '.') {
                numCarac++;
            }
        }

        return numCarac;
    }

    public String cadenaInvertida() {
        StringBuffer str = new StringBuffer(frase);
        return new String(str.reverse());
    }

    public int contaPalabras() {
        int numPalabras = 0;
        StringTokenizer stk = new StringTokenizer(frase);
        
        while(stk.hasMoreTokens()) {
            if(stk.nextToken() != " ") {
                numPalabras++;
            }
        }

        return numPalabras;
    }

    public void separarPalabras() {
        String[] fraseChar = new String[contaPalabras()];
        StringTokenizer stk = new StringTokenizer(frase);
        int i = 0;

        while(stk.hasMoreTokens()) {
            if(stk.nextToken() != " ") {
                fraseChar[i] = stk.nextToken();
                i++;
            }
        }

        System.out.println();
        System.out.print("Palabras[");
        for(int j = 0; j < fraseChar.length; j++) {
            System.out.print(fraseChar[j]);
        }
        System.out.print("]");
    }

    public int primeraVocal() {
        int i = 0;
        String fraseMinus = frase.toLowerCase();
        char[] fraseChar = fraseMinus.toCharArray(); 
        
        for(i = 0; i < fraseChar.length; i++) {
            if(fraseChar[i] == 'a' || fraseChar[i] == 'o' || fraseChar[i] == 'e' || fraseChar[i] == 'i' || fraseChar[i] == 'u') break;
        }

        return i;
    }

    public int ultimaPosicion() {
        int i = 0;
        char[] fraseChar = frase.toLowerCase().toCharArray();
        
        for(i = fraseChar.length - 1; i > 0; i--) {
            if(fraseChar[i] == 'a' || fraseChar[i] == 'o' || fraseChar[i] == 'e' || fraseChar[i] == 'i' || fraseChar[i] == 'u') break; 
        }

        return i + 1;
    }

    public boolean comprobaMayucula() {
        boolean resultado = false;

        if(Character.isUpperCase(frase.charAt(0))) {
            resultado = true;
        }

        return resultado;
    }

    public String convertirMayusculas() {
        return frase.toUpperCase();
    }

    public String convertirMinusculas() {
        return frase.toLowerCase();
    }

    public void convertirVector() {
        char[] vector = frase.toCharArray();
        for(int i = 0; i < vector.length; i++) System.out.print(vector[i] + " ");
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

}
