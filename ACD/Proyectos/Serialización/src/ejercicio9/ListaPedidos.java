/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio9;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ejercicio4_y5.Pedido;

/**
 *
 * @author dam218
 */
public class ListaPedidos implements Serializable {
    List<Pedido> pedidos = new ArrayList<>();

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
