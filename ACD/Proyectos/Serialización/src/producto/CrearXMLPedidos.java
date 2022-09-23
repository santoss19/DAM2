/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producto;

import java.io.IOException;
import java.util.List;
import serialización.Herramientas;

/**
 *
 * @author dam218
 */
public class CrearXMLPedidos {
    
    String[] nomCliente = {"Paquiño", "Luis", "Torres", "Queimado", "Calberto"};
    int[] idPedido = {1,2,3,4,5};
    List<Pedido> listaPedidos;
    Herramientas herr;
    
    public CrearXMLPedidos() {}
    
    public void xeraListaPedidos() {
        herr.generarProductos();
        for(int i = 0; i < nomCliente.length; i++) {
            listaPedidos.add(new Pedido(idPedido[i], nomCliente[i], herr.getProductos()));
        }
    }
    
    public void gardaListaPedidos() {
        
    }
    
    public void lePedidos() {
        
    }
    
    public void mostraPedidos() {
        
    }
    
    public void xeraXMLPedidos() {
        
    }
}
