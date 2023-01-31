/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.modelo.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */

@Entity
@Table(name="empresas")

public class Empresa implements Serializable {
    
    

    @Id
    
    String NIF;
    
    @Basic
    @Column(name="razonSocial")
            
    String razonSocial;
    
    @Basic
    @Column(name="IBAN")
            
    String IBAN;
    
    @OneToMany
    
    List<Contacto> contactos = new ArrayList<>();

    public Empresa() {
    }

    public Empresa(String NIF, String razonSocial, String IBAN, List<Contacto> contactos) {
        this.NIF = NIF;
        this.razonSocial = razonSocial;
        this.IBAN = IBAN;
        this.contactos = contactos;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public String toString() {
        return "Empresa{" + "NIF=" + NIF + ", razonSocial=" + razonSocial + ", IBAN=" + IBAN + ", contactos=" + contactos + '}';
    }
    
    public boolean isEmpty() {
        return true;
    }
}
