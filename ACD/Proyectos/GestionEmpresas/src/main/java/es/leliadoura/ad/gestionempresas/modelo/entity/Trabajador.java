/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.modelo.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author marco
 */

@Entity
@Table(name="trabajadores")

public class Trabajador implements Serializable {
    
    @Id
            
    String DNI;
    
    @Basic
    @Column(name="nombre")
    
    String nombre;
    
    @Basic
    @Column(name="apellidos")
    
    String apellidos;
    
    @Basic
    @Column(name="IBAN")
    
    String IBAN;
    
    @Basic
    @Column(name="segSocial")
    
    long segSocial;
    
    @Basic
    @Column(name="correo")
    
    String correo;
    
    @Basic
    @Column(name="telefono")
    
    float telefono;

    public Trabajador() {
    }

    public Trabajador(String DNI, String nombre, String apellidos, String IBAN, long segSocial, String correo, float telefono) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.IBAN = IBAN;
        this.segSocial = segSocial;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public long getSegSocial() {
        return segSocial;
    }

    public void setSegSocial(long segSocial) {
        this.segSocial = segSocial;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public float getTelefono() {
        return telefono;
    }

    public void setTelefono(float telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", IBAN=" + IBAN + ", segSocial=" + segSocial + ", correo=" + correo + ", telefono=" + telefono + '}';
    }
    
    public boolean isEmpty() {
        return true;
    }

}
