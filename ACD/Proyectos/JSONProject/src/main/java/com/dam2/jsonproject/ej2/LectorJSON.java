/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.jsonproject.ej2;

import com.dam2.jsonproject.ej1.Cliente;
import com.dam2.jsonproject.ej1.Enderezo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author dam218
 */
public class LectorJSON {
    
    public void execLector(File arch) throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray ja = (JSONArray) parser.parse(new FileReader(arch));
        
        for(int i = 0; i < ja.size(); i++) {
            JSONObject obj = (JSONObject) ja.get(i);
            JSONArray enderezos = (JSONArray) obj.get("enderezos");
            Enderezo[] enderezosArray = new Enderezo[enderezos.size()];
            for(int j = 0; j < enderezos.size(); j++) {
                JSONObject endJSON = (JSONObject)enderezos.get(j);
                Enderezo end = new Enderezo((String) endJSON.get("rua"),(Long) endJSON.get("numero"), (Long)endJSON.get("cp"));
                enderezosArray[j] = end;
            }
            Cliente cliente = new Cliente((String) obj.get("dni"),(String) obj.get("nombre"),(String) obj.get("apelidos"), (Enderezo[]) enderezosArray);
            System.out.println(cliente.toString());
        }
    }
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        LectorJSON json = new LectorJSON();
        json.execLector(new File("clientes.json"));
    }
}
