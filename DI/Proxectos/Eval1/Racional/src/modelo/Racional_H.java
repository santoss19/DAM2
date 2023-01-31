package modelo;

public class Racional_H {

    private int numerador;
    private int denominador;

    
    public Racional_H() {
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
}