/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.jsonproject.ej5;

/**
 *
 * @author dam218
 */
public class Enderezo {
    
    String localidade;
    String rua;
    long numero;

    public Enderezo(String localidade, String rua, long numero) {
        this.localidade = localidade;
        this.rua = rua;
        this.numero = numero;
    }
    
    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Enderezo{" + "localidade=" + localidade + ", rua=" + rua + ", numero=" + numero + '}';
    }
    
}
