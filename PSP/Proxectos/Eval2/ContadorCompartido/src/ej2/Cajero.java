package ej2;

public class Cajero {

    protected String nombre = "";
    protected int localidades = 0;

    public Cajero(String nom) {
        nombre = nom;
    }

    public void sumarLocalidades() {
        localidades = localidades + 1;
    }

    public int mostrarLocalidades() {
        return localidades;
    }

    public void getNombre() {
        System.out.println("Cajero: " + nombre);
    }

    public void totalLocalidades() {
        System.out.println("El total de localidades vendidas fue de " + localidades);
    }

}