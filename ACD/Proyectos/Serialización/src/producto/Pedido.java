/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producto;

import java.util.ArrayList;
import java.util.List;
import serialización.Producto;

/**
 *
 * @author dam218
 */
public class Pedido {
    
    private int idPedido;
    private String nomeCliente;
    private List<Producto> productos = null;

    public Pedido() {
    }

    public Pedido(int idPedido, String nomeCliente, List<Producto> pr) {
        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
        this.productos = new ArrayList();
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
        return "Producto{" + "idPedido=" + idPedido + ", nomeCliente=" + nomeCliente + '}';
    }
    
}
