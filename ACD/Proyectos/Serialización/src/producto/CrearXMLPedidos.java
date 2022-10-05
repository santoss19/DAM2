/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producto;

import java.io.IOException;
import java.util.List;
import serialización.Herramientas;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.File;

/**
 *
 * @author dam218
 */
public class CrearXMLPedidos {
    
    String[] nomCliente = {"Paquiño", "Luis", "Torres", "Queimado", "Calberto"};
    int[] idPedido = {1,2,3,4,5};
    List<Pedido> listaPedidos;
    Herramientas herr;
    Document doc = null;
    
    public CrearXMLPedidos() {}
    
    public void xeraListaPedidos() {
        herr.generarProductos();
        for(int i = 0; i < nomCliente.length; i++) {
            listaPedidos.add(new Pedido(idPedido[i], nomCliente[i], herr.getProductos()));
        }
    }
    
    public void creaXML() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation implementation = db.getDOMImplementation();
            doc = implementation.createDocument(null, "pedidos", null);
            doc.setXmlVersion("1.0");
        } catch (ParserConfigurationException ex) {
            System.err.println("¡Error!: Non se pudo parsear o documento XML.");
        }
    }
    
    public void lePedidos(String rutaArchivo) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(rutaArchivo);
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            System.err.println("¡ERROR! : Non se pudo cargar o documento XML.");
        }
    }
    
    public void gardaListaPedidos() {
        
    }
    
    public void mostraPedidos() {
        
    }
    
    public void xeraXMLPedidos() {
        
    }
}
