/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.jsonproject.ej3Yej4;

import java.util.List;

/**
 *
 * @author dam218
 */
public class Pedido {
    
    //Atributos de clase 
    
    long id;
    Cliente cliente;
    List<LineaPedido> lineasPedido = null;
    double importe;
    boolean entregado = false;

    //

    public Pedido(long id, Cliente cliente, double importe, List<LineaPedido> lineas, boolean ent) {
        this.id = id;
        this.cliente = cliente;
        this.importe = importe;
        this.lineasPedido = lineas;
        this.entregado = ent;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public void setLineasPedido(List<LineaPedido> lineasPedido) {
        this.lineasPedido = lineasPedido;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", cliente=" + cliente + ", lineasPedido=" + lineasPedido + ", importe=" + importe + ", entregado=" + entregado + '}';
    }
    
    
}
