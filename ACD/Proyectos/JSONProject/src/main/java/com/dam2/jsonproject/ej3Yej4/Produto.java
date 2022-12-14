/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.jsonproject.ej3Yej4;

/**
 *
 * @author dam218
 */
public class Produto {
    
    long id;
    String nomeProduto;
    String descripcion;
    String foto;
    double prezo;

    public Produto(long id, String nomeProduto, String descripcion, String foto, double prezo) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descripcion = descripcion;
        this.foto = foto;
        this.prezo = prezo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nomeProduto=" + nomeProduto + ", descripcion=" + descripcion + ", foto=" + foto + ", prezo=" + prezo + '}';
    }
    
    
    
}
