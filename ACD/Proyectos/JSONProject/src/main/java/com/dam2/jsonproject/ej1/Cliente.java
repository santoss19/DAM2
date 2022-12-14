/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.jsonproject.ej1;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dam218
*/

public class Cliente {
    
    String dni;
    String nome;
    String apelidos;
    Enderezo[] enderezos;

    public Cliente(String dni, String nome, String apelidos, Enderezo[] enderezos) {
        this.dni = dni;
        this.nome = nome;
        this.apelidos = apelidos;
        this.enderezos = enderezos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Enderezo[] getEnderezos() {
        return enderezos;
    }

    public void setEnderezos(Enderezo[] enderezos) {
        this.enderezos = enderezos;
    }  
    
    public String getEnderezo() {
        List<Enderezo> enderezo = Arrays.asList(enderezos);
        return enderezo.toString();
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + ", nome=" + nome + ", apelidos=" + apelidos + ", enderezos={" + getEnderezo() + "}" + "}";
    }
}
