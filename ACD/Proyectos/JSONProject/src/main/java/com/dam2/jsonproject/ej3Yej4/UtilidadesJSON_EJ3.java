/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.jsonproject.ej3Yej4;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author dam218
 */
public class UtilidadesJSON_EJ3 {
    
    // EJERCICIO 3
    
    public List<Pedido> xeraPedidos() {
        
        List<Pedido> pedidos = new ArrayList<>();
        Cliente[] clientes = {new Cliente("1256172L", "Luhish", "Lustres"), new Cliente("1838281P", "Alberto", "Romero"), new Cliente("1737181Ñ", "Alvaro", "Regueira"), new Cliente("178781781O", "Oscar", "TorresCaidas")};
        Produto[] productos = {new Produto(91889, "CPU-Álvaro", "Repuesto procesador cabeza Álvaro", "http://server-img/alvaro.png", 110.99), new Produto(71727, "CPU-Ronal", "Repuesto procesador cabeza Ronal", "http://server-img/ronal.png", 229.99), new Produto(91889, "CPU-Luhish", "Repuesto procesador cabeza Luhish", "http://server-img/luhish.png", 399.99)};
        LineaPedido[] lineas = {new LineaPedido(productos[0], 10, productos[0].getPrezo() * 10), new LineaPedido(productos[1], 20, productos[1].getPrezo() * 20), new LineaPedido(productos[2], 40, productos[2].getPrezo() * 40)};
        List<LineaPedido> lineasPedido = new ArrayList<>();
        long[] id = {1928181, 102818191, 1902881, 1928191};
        
        for(int j = 0; j < lineas.length; j++) lineasPedido.add(lineas[j]);
        
        for(int i = 0; i < clientes.length; i++) {
            pedidos.add(new Pedido(id[i], clientes[i], 171.90, lineasPedido, false));
        }
        
        return pedidos;
        
    }
    
    public void creaJsonPedidos() {
        
        List<Pedido> pedidos = this.xeraPedidos();
        JSONArray pedidosJson = new JSONArray();
        for(int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            JSONObject pedidoJson = new JSONObject();
            
            // Creación atributo ID
            
            pedidoJson.put("id", pedido.getId());
            
            // Creación atributo Cliente
            
            Cliente cliente = pedido.getCliente();
            JSONObject clienteJson = new JSONObject();
            clienteJson.put("DNI", cliente.getDNI());
            clienteJson.put("nome", cliente.getNome());
            clienteJson.put("apelidos", cliente.getApelidos());
            pedidoJson.put("cliente", clienteJson);
            
            // Creación atributo LineaPedido
            
            JSONArray listaLineas = new JSONArray();
            for(int j = 0; j < pedido.getLineasPedido().size(); j++) {
                LineaPedido linea = pedido.getLineasPedido().get(j);
                JSONObject lineaJson = new JSONObject();
                
                JSONObject productoJson = new JSONObject();
                Produto producto = linea.getProducto();
                productoJson.put("id", producto.getId());
                productoJson.put("nomeProducto", producto.getNomeProduto());
                productoJson.put("descripcion", producto.getDescripcion());
                productoJson.put("foto", producto.getFoto());
                productoJson.put("prezo", producto.getPrezo());
                lineaJson.put("producto", productoJson);
                
                lineaJson.put("cantidade", linea.getCantidad());
                lineaJson.put("prezoTotal", linea.getPrezoTotal());
                
                listaLineas.add(lineaJson);
            }
            pedidoJson.put("lineasPedido", listaLineas);
            
            //Creación atributos Importe y Entrgeado
            
            pedidoJson.put("importe", pedido.getImporte());
            pedidoJson.put("entregado", pedido.isEntregado());
            
            //Añadimos pedidoJson a pedidosJson
            
            pedidosJson.add(pedidoJson);
        }
        
        // Pasamos todo a .json
        
        try {
            FileWriter fw = new FileWriter(new File("pedidos.json"));
            fw.write(pedidosJson.toJSONString());
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(UtilidadesJSON_EJ3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void generadorXML() {
        
        ListaPedidos lista = new ListaPedidos();
        lista.setPedidos(this.xeraPedidos());
        
        XStream xs = new XStream();
        
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("pedidos", ListaPedidos.class);
        xs.alias("pedido", Pedido.class);
        xs.alias("lineaPedido", LineaPedido.class);
        
        try {
            xs.toXML(lista, new FileOutputStream(new File("pedidos.xml")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilidadesJSON_EJ3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // EJERCICIO 4
    
    public List<Pedido> lePedidosJson() {
        
        List<Pedido> pedidos = new ArrayList<>();
        FileReader reader = null;
               
        try {
            JSONParser parser = new JSONParser();
            reader = new FileReader(new File("pedidos.json"));
            JSONArray jarray = (JSONArray) parser.parse(reader);
            
            for(int i = 0; i < jarray.size(); i++) {
                JSONObject pedidoJSON = (JSONObject) jarray.get(i);
                JSONObject clienteJSON = (JSONObject) pedidoJSON.get("cliente");
                Cliente cliente = new Cliente((String) clienteJSON.get("DNI"), (String) clienteJSON.get("nome"), (String) clienteJSON.get("apelidos"));
                JSONArray lineasPedidoJSON = (JSONArray) pedidoJSON.get("lineasPedido");
                List<LineaPedido> lineasPedido = new ArrayList<>();
                for(int j = 0; j < lineasPedidoJSON.size(); j++) {
                    JSONObject lineaPedidoJSON = (JSONObject) lineasPedidoJSON.get(j);
                    JSONObject productoJSON = (JSONObject) lineaPedidoJSON.get("producto");
                    Produto producto = new Produto((Long) productoJSON.get("id"), (String) productoJSON.get("nomeProducto"), (String) productoJSON.get("descripcion"), (String) productoJSON.get("foto"), (Double) productoJSON.get("prezo")); 
                    LineaPedido lineaPedido = new LineaPedido(producto, (Long) lineaPedidoJSON.get("cantidade"), (Double) lineaPedidoJSON.get("prezoTotal"));
                    lineasPedido.add(lineaPedido);
                }
                Pedido pedido = new Pedido((Long) pedidoJSON.get("id"), cliente, (Double) pedidoJSON.get("importe"), lineasPedido, (Boolean) pedidoJSON.get("entregado"));
                pedidos.add(pedido);
            }
 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilidadesJSON_EJ3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UtilidadesJSON_EJ3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(UtilidadesJSON_EJ3.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(UtilidadesJSON_EJ3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pedidos;
    }
    
    public void mostraJsonPedidos(List<Pedido> pedidos) {
        for(int i = 0; i < pedidos.size(); i++) {
            System.out.println(pedidos.get(i).toString());
        }
    }
    
    public static void main(String[] args) {
        UtilidadesJSON_EJ3 ujson = new UtilidadesJSON_EJ3();
        ujson.xeraPedidos();
        ujson.creaJsonPedidos();
        ujson.generadorXML();
        ujson.mostraJsonPedidos(ujson.lePedidosJson());
    }
}