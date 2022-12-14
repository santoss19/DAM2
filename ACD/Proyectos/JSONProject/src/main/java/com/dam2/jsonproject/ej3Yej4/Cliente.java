/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.jsonproject.ej3Yej4;

/**
 *
 * @author dam218
 */
public class Cliente {
    
    String DNI;
    String nome;
    String apelidos;

    public Cliente(String DNI, String nome, String apelidos) {
        this.DNI = DNI;
        this.nome = nome;
        this.apelidos = apelidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "DNI=" + DNI + ", nome=" + nome + ", apelidos=" + apelidos + '}';
    }
    
}
