/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.jsonproject.ej1;

/**
 *
 * @author dam218
 */
public class Enderezo {
    
    String rua;
    long numero;
    long cp;

    public Enderezo(String rua, long numero, long cp) {
        this.rua = rua;
        this.numero = numero;
        this.cp = cp;
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

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "Enderezo{" + "rua=" + rua + ", numero=" + numero + ", cp=" + cp + '}';
    }
}
