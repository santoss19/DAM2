package modelo;

public class NumeroEnteroHijo extends NumeroEntero {

    NumeroEntero n1 = new NumeroEntero();
    NumeroEntero n2 = new NumeroEntero();

    public NumeroEnteroHijo(int valor1, int valor2) {
       this.n1.setValor(valor1);
       this.n2.setValor(valor2);
    }

    public String sumaNumeros() {
        return "La suma de los dos números da = " + (n1.getValor() + n2.getValor());
    }

    public String restaNumeros() {
        return "[Resta N1 - N2 = " + (n1.getValor() - n2.getValor()) + " // Resta N2 - N1 = " + (n2.getValor() - n1.getValor()) + "]";
    }

    public String comparaNumeros() {
        if(n1.getValor() > n2.getValor()){
            return "El número 1 es más grande que el número 2 (" + n1.getValor() + " > " + n2.getValor() + ")";
        } else if(n2.getValor() > n1.getValor()) {
            return "El número 2 es más grande que el número 1 (" + n2.getValor() + " > " + n1.getValor() + ")";
        } else if(n1.getValor() == n2.getValor()) {
            return "Los dos números son iguales (" + n1.getValor() + " = " + n2.getValor() + ")"; 
        }
        return "Ocurrió algo ...";
    } 
}