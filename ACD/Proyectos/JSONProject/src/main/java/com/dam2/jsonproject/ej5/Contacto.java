/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.jsonproject.ej5;

import com.dam2.jsonproject.ej3Yej4.Cliente;
import java.io.Serializable;

/**
 *
 * @author dam218
 */
public class Contacto extends Cliente implements Serializable {
    
    Enderezo enderezo = null;
    
    public Contacto(String DNI, String nome, String apelidos, Enderezo end) {
        super(DNI, nome, apelidos);
        this.enderezo = end;
    }

    public Enderezo getEnderezo() {
        return enderezo;
    }

    public void setEnderezo(Enderezo enderezo) {
        this.enderezo = enderezo;
    }

    @Override
    public String toString() {
        return "Contacto{" + "enderezo=" + enderezo + '}';
    }
    
}
