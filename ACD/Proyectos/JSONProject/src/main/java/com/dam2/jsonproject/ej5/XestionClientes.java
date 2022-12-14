/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.jsonproject.ej5;

import com.dam2.jsonproject.ej3Yej4.Cliente;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author dam218
 */
public class XestionClientes {
    
    public List<Cliente> xeraListaClientes() {
        List<Cliente> clientes = new ArrayList<>();
        
        for(int i = 0; i < 5; i++) {
            clientes.add(new Cliente(i + "", 
                    "Oscar", 
                    "Torres Caidas"));
        }
        
        return clientes;
    }
    
    public void gardaJsonClientes() {
        
        List<Cliente> clientes = this.xeraListaClientes();
        JSONArray array = new JSONArray();
        
        for(int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            JSONObject object = new JSONObject();
            
            object.put("DNI", cliente.getDNI());
            object.put("Nome", cliente.getNome());
            object.put("Apelidos", cliente.getApelidos());
            
            array.add(object);
        }
        
        try {
            FileWriter fw = new FileWriter(new File("clientes.json"));
            fw.write(array.toJSONString());
            fw.close();
        } catch(IOException ex) {
            System.err.println("ERROR:" + ex);
        }
        
    }
    
    public List<Cliente> leJsonClientes() {
        
        List<Cliente> clientesList = new ArrayList<>();
        File fich = new File("clientes.json");
        JSONParser parser = new JSONParser();
        JSONArray clientes = new JSONArray();
        
        try {
             clientes = (JSONArray) parser.parse(new FileReader(fich));
        } catch (IOException ex) {
            System.err.println("ERROR: " + ex);
        }  catch (ParseException ex) {
            System.err.println("ERROR: " + ex);
        }
        
        for(int i = 0; i < clientes.size(); i++) {
            JSONObject object = (JSONObject) clientes.get(i);
            Cliente cliente = new Cliente(
                    (String) object.get("DNI"), 
                    (String) object.get("nombre"), 
                    (String) object.get("apelidos"));
            
            clientesList.add(cliente);
      
        }
        
        return clientesList;
        
    }
    
    public List<Contacto> xeraListaContactos() {
        
        List<Cliente> clientes = leJsonClientes();
        List<Contacto> contactos = new ArrayList<>();
        
        for(int i = 0; i < clientes.size(); i++) {
            contactos.add(new Contacto(
            clientes.get(i).getDNI(),
            clientes.get(i).getNome(),
            clientes.get(i).getApelidos(),
            new Enderezo("Rianxo", "C/Torres Caídas", i)));
        }
        
        return contactos;
        
    }
    
    public void gardaJsonContactos() {
        
        List<Contacto> contactos = xeraListaContactos();
        JSONArray array = new JSONArray();
        
        for(int i = 0; i < contactos.size(); i++) {
            Contacto contacto = contactos.get(i);
            JSONObject object = new JSONObject();
            
            object.put("DNI", contacto.getDNI());
            object.put("nome", contacto.getNome());
            object.put("apelidos", contacto.getApelidos());
            
            JSONObject end = new JSONObject();
            Enderezo enderezo = contacto.getEnderezo();
            
            end.put("localidade", enderezo.getLocalidade());
            end.put("rua", enderezo.getRua());
            end.put("numero", enderezo.getNumero());
            
            object.put("enderezo", end);
            array.add(object);
        }
    
        try {
            FileWriter fw = new FileWriter(new File("contactos.json"));
            fw.write(array.toJSONString());
            fw.close();
        } catch(IOException ex) {
            System.err.println("ERROR:" + ex);
        }
    }
    
    public List<Contacto> leJsonContactos() {
        
        List<Contacto> contactos = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONArray contactosJson = null;
        
        try {
            FileReader fr = new FileReader(new File("contactos.json"));
            contactosJson = (JSONArray) parser.parse(fr);
        } catch(IOException ex) {
            System.err.println("ERROR: " + ex);
        } catch(ParseException ex) {
            System.err.println("ERROR: " + ex);
        }
        
        
        for(int i = 0; i < contactosJson.size(); i++) {
            
            JSONObject object = (JSONObject)contactosJson.get(i);
            JSONObject end = (JSONObject) object.get("enderezo");
            
            Contacto contacto = new Contacto(
                    (String) object.get("DNI"), 
                    (String) object.get("nome"), 
                    (String) object.get("apelidos"), 
                    new Enderezo(
                        (String) end.get("localidade"),
                        (String) end.get("rua"),
                        (long) end.get("numero")
            ));
            
            contactos.add(contacto);
            
        }
        
        return contactos;
    }
    
    public void mostraJsonContactos() {
        System.out.println(leJsonContactos().toString());
    }
    
    public void gardaXmlJsonContactos() {
        XStream xs = new XStream();
        ListaContactos contactos = new ListaContactos();
        contactos.setContactos(leJsonContactos());
        
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("contactos", ListaContactos.class);
        xs.alias("contacto", Contacto.class);
        
        try {
            xs.toXML(
                    contactos, 
                    new FileOutputStream(new File("contactos.xml")));
        } catch(FileNotFoundException ex) {
            System.err.println("ERROR: " + ex);
        }
  
    }
    
    public void gardaDatJsonContactos() {
        
        List<Contacto> contactos = leJsonContactos();
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            fos = new FileOutputStream(new File("contactos.dat"));
            oos = new ObjectOutputStream(fos);
            
            for(int i = 0; i < contactos.size(); i++) {
                oos.writeObject(contactos.get(i));
            }
            
            oos.close();
            fos.close();
 
        } catch(IOException ex) {
            System.err.println("ERROR: " + ex);
        }
        
    }
    
    public void leMostraDatContactos() {
        
        List<Contacto> contactos = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(new File("contactos.dat"));
            ois = new ObjectInputStream(fis);
            
            while(fis.available() > 0) {
                try {
                    contactos.add((Contacto) ois.readObject());
                } catch(ClassNotFoundException ex) {
                    System.err.println("ERROR: " + ex);
                }
            }
        } catch (IOException ex) {
            System.err.println("ERROR: " + ex);
        } finally {
            if(contactos.size() > 0) {
                for(int i = 0; i < contactos.size(); i++) {
                    System.out.println(contactos.get(i).toString());
                }
            } else {
                System.err.println("Ocurrio un error y la lista está vacia");
            }
        }
        
    }
    
    public void leMostraXmlContactos() {
        
        XStream xs = new XStream();
        
        xs.setMode(XStream.NO_REFERENCES);
        xs.addPermission(AnyTypePermission.ANY);
        
        System.out.println(xs.fromXML(new File("contactos.xml"))); 
        
    }
}
