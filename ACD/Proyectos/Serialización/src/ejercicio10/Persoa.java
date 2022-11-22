/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10;

import java.io.Serializable;

/**
 *
 * @author dam218
 */
public class Persoa implements Serializable {
    
    String nome;
    String DNI;
    
    public Persoa(String nome, String DNI) {
        this.nome = nome;
        this.DNI = DNI;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Persoa{" + "nome=" + nome + ", DNI=" + DNI + '}';
    }
    
}
