package modelo;

public class Racional {

    private int numerador;
    private int denominador;

    
    public Racional() {
        this.denominador = 1;
        this.numerador = 1;
    }

    public void asignarDatos(int num, int dem) {
        this.numerador = num;
        this.denominador = dem;
        System.out.println("Nuevo número racional asignando los valores " + numerador + " y " + denominador + " : " + numerador + "/" + denominador);
    }

    public String visualizarRacional() {
        return "Nuevo racional creado: " + numerador + "/" + denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    @Override
    public String toString() {
        return this.numerador + "/" + this.denominador;
    }
    
}