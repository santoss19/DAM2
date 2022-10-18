/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import serialización.Herramientas;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import serialización.Producto;

/**
 *
 * @author dam218
 */


public class CrearXMLPedidos {
    
    String[] nomCliente = {"Paquiño", "Luis", "Torres", "Queimado", "Calberto"};
    int[] idPedido = {1,2,3,4,5};
    List<Pedido> listaPedidos;
    Herramientas herr = new Herramientas();
    String ruta = "test.xml";
    Document doc = null;
    File arch = new File("pedidos.dat");
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    FileInputStream fis = null;
    FileOutputStream fos = null;
    
    public CrearXMLPedidos() throws IOException {
        try {
            this.fis = new FileInputStream(arch);
            this.fos = new FileOutputStream(arch);
        } catch(FileNotFoundException ex) {
            System.err.println("ERROR: Archivo no encontrado!");
        }
        
        this.oos = new ObjectOutputStream(fos);
        this.ois = new ObjectInputStream(fis);
        herr.generarProductos();
        listaPedidos = new ArrayList<>();
    }
    
    /* PARTE SERIALIZACIÓN */
    
    public void xeraListaPedidos() {
        for(int i = 0; i < 5; i++) {
            List<Producto> productos = herr.getProductos();
            listaPedidos.add(new Pedido(idPedido[i], /*nomCliente[i]*/ "Test", productos));
        }
    }
    
    public void gardaListaPedidos() throws IOException {
        if(listaPedidos.isEmpty() == false) {
            for(Pedido ped : listaPedidos) {
                oos.writeObject(ped);
            }
            listaPedidos.removeAll(listaPedidos);
        } else {
            System.err.println("ERROR: A lista dos pedidos está vacía!");
        }
        oos.close();
        fos.close();
    }
    
    public void lePedidos() throws IOException {
        
        Pedido pedido = null;
        
        if(listaPedidos.isEmpty() == false) {
            listaPedidos.removeAll(listaPedidos);
        }
        while(fis.available() > 0) {
            try {
                pedido = (Pedido)ois.readObject();
            } catch (ClassNotFoundException ex) {
                System.err.println(ex);
            }
            listaPedidos.add(pedido);
        }
        ois.close();
        fis.close();
    }
        
    
    public void mostraPedidos() {
        for(Pedido ped : listaPedidos) {
            System.out.println(ped.toString());
        }
    }
    
    /* PARTE XML */
    
    public void creaXML() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation implementation = db.getDOMImplementation();
            doc = implementation.createDocument(null, "pedidos", null);
            doc.setXmlVersion("1.0");
        } catch (ParserConfigurationException ex) {
            System.err.println("¡Error!: Non se pudo parsear o documento XML.");
        }
    }
    
    public void transformerXML() {
        try {
            File f = new File("test.xml");
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult result = new StreamResult(f);
            DOMSource source = new DOMSource(doc);
        } catch (TransformerException ex) {
            System.err.println("ERROR: Transformer falló!");
        }
    }
    
    /*
        EN DISEÑO
    
        public void xeraXMLPedidos() {
        XStream xstream = new XStream();
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("pedidos", List.class);
        xstream.alias("pedido", Pedido.class);
        xstream.toXML(listaPedidos, fos);
    }*/
    
    /* EJERCICIO 5 */
    
    public void lePedidosXML() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(ruta);
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            System.err.println("¡ERROR! : Non se pudo cargar o documento XML.");
        }
    }
    
    public void prueba() {
        try {
            Document docTest = null;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation impl = db.getDOMImplementation();
            doc=impl.createDocument(null, "pedidos", null);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("test.xml"));
        t.transform(source, result);
        } catch(ParserConfigurationException | TransformerException ex) {
            ex.printStackTrace();
        }
        
    }
    
    
    public static void main(String[] args) throws IOException {
        CrearXMLPedidos cxmlp = new  CrearXMLPedidos();
        cxmlp.prueba();
    }
    
}
