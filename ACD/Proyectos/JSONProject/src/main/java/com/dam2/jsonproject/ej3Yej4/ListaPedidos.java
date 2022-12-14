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
public class ListaPedidos {
    
    List<Pedido> pedidos = null;

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "ListaPedidos{" + "pedidos=" + pedidos + '}';
    }
    
}
