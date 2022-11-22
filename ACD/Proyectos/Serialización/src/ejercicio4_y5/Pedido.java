/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4_y5;

import java.io.Serializable;
import java.util.List;
import ejercicio1.Producto;

/**
 *
 * @author dam218
 */
public class Pedido implements Serializable{
    
    private int idPedido;
    private String nomeCliente;
    private List<Producto> productos = null;

    public Pedido() {
    }

    public Pedido(int idPedido, String nomeCliente, List<Producto> pr) {
        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
        this.productos = pr;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", nomeCliente=" + nomeCliente + " productos=" + productos +'}';
    }
    
}
