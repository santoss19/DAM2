/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.modelo.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author marco
 */

@Entity
@Table(name="contratos")

public class Contrato implements Serializable {
    
    @Column
    @Id
    @GeneratedValue

    long id;
    
    @OneToOne(cascade = CascadeType.ALL)
            
    Trabajador trabajador = new Trabajador();
    
    @ManyToOne(cascade = CascadeType.ALL)
            
    Empresa empresa = new Empresa();
    
    @Column(name="fechaInicio", nullable = false)
            
    Date fechInic = null;
    
    @Column(name = "fechaFin", nullable = true)
            
    Date fechFin = null;
    
    @Basic
    @Column(name="salario")
            
    float salario;
    
    @Basic
    @Column(name="jornada")
    
    int jornada;

    public Contrato() {}

    public Contrato(float salario, int jornada) {
        this.salario = salario;
        this.jornada = jornada;
    }

    public long getId() {
        return id;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Date getFechInic() {
        return fechInic;
    }

    public void setFechInic(Date fechInic) {
        this.fechInic = fechInic;
    }

    public Date getFechFin() {
        return fechFin;
    }

    public void setFechFin(Date fechFin) {
        this.fechFin = fechFin;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    @Override
    public String toString() {
        return "Contrato{" + "id=" + id + ", trabajador=" + trabajador + ", empresa=" + empresa + ", fechInic=" + fechInic + ", fechFin=" + fechFin + ", salario=" + salario + ", jornada=" + jornada + '}';
    }
    
    public boolean isEmpty() {
        
        if(empresa == null) {
            return true;
        }
        if(fechFin == null) {
            return true;
        }
        if(fechInic == null) {
            return true;
        }
        if(jornada == 0) {
            return true;
        }
        if(salario == 0) {
            return true;
        }
        if(trabajador == null) {
            return true;
        }
        
        return false;
    }

}
