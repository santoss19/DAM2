/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.jsonproject.ej6;

import com.dam2.jsonproject.ej3Yej4.Pedido;
import com.dam2.jsonproject.ej3Yej4.UtilidadesJSON_EJ3;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author dam218
 */
public class UtilidadesGson {
    
    public List<Pedido> xeraPedidosGson() {
        
        UtilidadesJSON_EJ3 utg = new UtilidadesJSON_EJ3();
        
        return utg.xeraPedidos();
    }
    
    public void creaJsonPedidos() {
        List<Pedido> pedidos = xeraPedidosGson();
        Gson gson = new Gson();
        
        try {
            String pedidosJson = gson.toJson(pedidos);
            FileWriter fw = new FileWriter(new File("pedidos.json"));
            fw.write(pedidosJson);
            fw.close();
        } catch (IOException ex) {
            System.err.println("ERROR: " + ex);
        }
    }
    
    public List<Pedido> leJsonPedidos() {
        
        Gson gson = new Gson();
        List<Pedido> listaLeida = null;
        FileReader fr = null;
        
        try {
            fr = new FileReader(new File("pedidos.json"));
            listaLeida = gson.fromJson(fr, List.class);
            fr.close();
        } catch (FileNotFoundException ex) {
            System.err.println("ERROR: Archivo no encontrado");
        } catch (IOException ex) {
            System.err.println("ERROR: " + ex);
        }
        
        return listaLeida;
        
    }
    
    public void mostraJsonPedidos() {
        List<Pedido> listaLeida = leJsonPedidos();
        for(int i = 0; i < listaLeida.size(); i++) {
            System.out.println(listaLeida.toString());
        }
    }
            
    public static void main(String[] args) {
        UtilidadesGson utg = new UtilidadesGson();
        utg.creaJsonPedidos();
        utg.mostraJsonPedidos();
    }
}
