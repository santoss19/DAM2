/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.jsonproject.ej1;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author dam218
 */
public class UtilidadesJSON_EJ1 {
    
    Cliente[] clien = {new Cliente("11111111K", "Alvaro", "Regueira Queimado", new Enderezo[]{new Enderezo("C/Fantasias Sexuales", 1, 15960), new Enderezo("C/Fantasias Sexuales", 2, 15960)}),
    new Cliente("22222222F", "Luis", "Lustres García", new Enderezo[]{new Enderezo("C/Fantasias Sexuales", 2, 15960)}),
    new Cliente("33333333H", "Oscar", "Torres Tachanka", new Enderezo[]{new Enderezo("C/Fantasias Sexuales", 3, 15960)})};
    
    List<Cliente> clientes = new ArrayList<>();
    FileWriter fw = null;

    public UtilidadesJSON_EJ1() {
        for(int i = 0; i < 3; i++) {
            clientes.add(clien[i]);
        }
    }
    
    public void JSONGenerator() throws FileNotFoundException, IOException {
        fw = new FileWriter(new File("clientes.json"));
        JSONArray data = new JSONArray();
        for(Cliente cliente : clientes) {
            JSONObject obj = new JSONObject();
            obj.put("dni", cliente.getDni());
            obj.put("nombre", cliente.getNome());
            obj.put("apelidos", cliente.getApelidos());
            JSONArray ja = new JSONArray();
            for(Enderezo e : cliente.getEnderezos()) {
                JSONObject enderezo = new JSONObject();
                enderezo.put("rua", e.getRua());
                enderezo.put("numero", e.getNumero());
                enderezo.put("cp", e.getCp());
                ja.add(enderezo);
            }
            obj.put("enderezos", ja);
            data.add(obj);
        }
        fw.write(data.toJSONString());
        fw.close();
    }
    
    public void generadorXML() throws FileNotFoundException {
        XStream xs = new XStream();
        
        ListaClientes cls = new ListaClientes(clientes);
        
        xs.alias("clientes", ListaClientes.class);
        xs.alias("cliente", Cliente.class);
        xs.alias("enderezo", Enderezo.class);
        xs.toXML(cls, new FileOutputStream(new File("clientes.xml")));
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        UtilidadesJSON_EJ1 ej1 = new UtilidadesJSON_EJ1();
        ej1.generadorXML();
        ej1.JSONGenerator();
    }
}