/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.jsonproject.ej3Yej4;

/**
 *
 * @author dam218
 */
public class LineaPedido {
    Produto producto;
    long cantidad;
    double prezoTotal;

    public LineaPedido(Produto producto, long cantidad, double prezoTotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.prezoTotal = prezoTotal;
    }

    public Produto getProducto() {
        return producto;
    }

    public void setProducto(Produto producto) {
        this.producto = producto;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrezoTotal() {
        return prezoTotal;
    }

    public void setPrezoTotal(double prezoTotal) {
        this.prezoTotal = prezoTotal;
    }

    @Override
    public String toString() {
        return "LineaPedido{" + "producto=" + producto + ", cantidad=" + cantidad + ", prezoTotal=" + prezoTotal + '}';
    }
    
}
