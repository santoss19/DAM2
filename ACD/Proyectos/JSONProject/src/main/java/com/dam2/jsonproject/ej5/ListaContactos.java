/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.jsonproject.ej5;

import java.util.List;

/**
 *
 * @author hugsa
 */
public class ListaContactos {
    
    List<Contacto> contactos = null;

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public String toString() {
        return "ListaContactos{" + "contactos=" + contactos + '}';
    }
    
}
