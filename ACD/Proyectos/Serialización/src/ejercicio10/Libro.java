/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam218
 */
public class Libro implements Serializable {
    
    private String ISBN;
    private String titulo;
    private List<String> autores = new ArrayList<>();
    private int anoPublicacion;
    private boolean prestado;
    private Persoa lector;
    
    public Libro(String isbn, String tit, List<String> aut, int anoP, boolean prest, Persoa lect) {
        
        this.ISBN = isbn;
        this.titulo = tit;
        this.autores = aut;
        this.anoPublicacion = anoP;
        this.prestado = prest;
        this.lector = lect;
   
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public Persoa getLector() {
        return lector;
    }

    public void setLector(Persoa lector) {
        this.lector = lector;
    }

    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", autores=" + autores + ", anoPublicacion=" + anoPublicacion + ", prestado=" + prestado + ", lector=" + lector + '}';
    }
    
}
