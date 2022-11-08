/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producto;

//import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import serialización.Herramientas;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
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
    File arch = new File("pedidos.xml");
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    FileInputStream fis = null;
    FileOutputStream fos = null;
    
    public CrearXMLPedidos() throws IOException {
        //try {
            //this.fis = new FileInputStream(arch);
            //this.fos = new FileOutputStream(arch);
        //} catch(FileNotFoundException ex) {
            //System.err.println("ERROR: Archivo no encontrado!");
        //}
        
        //this.oos = new ObjectOutputStream(fos);
        //this.ois = new ObjectInputStream(fis);
        listaPedidos = new ArrayList<>();
    }
    
    /* PARTE SERIALIZACIÓN */
    
    public void xeraListaPedidos() {
        for(int i = 0; i < 5; i++) {
            listaPedidos.add(new Pedido(idPedido[i], /*nomCliente[i]*/ "Test", herr.getProductos()));
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
    
     public void crearXMLPedidos() {
        try {
            Document docTest = null;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation impl = db.getDOMImplementation();
            doc = impl.createDocument(null, "pedidos", null);
            
            for(int i = 0; i < listaPedidos.size(); i++) {
                Element pedido = doc.createElement("pedido");
                doc.getDocumentElement().appendChild(pedido);
                Element idPedido = doc.createElement("idPedido");
                idPedido.setTextContent(listaPedidos.get(i).getIdPedido() + "");
                pedido.appendChild(idPedido);
                Element nomeCliente = doc.createElement("nomeCliente");
                nomeCliente.setTextContent(listaPedidos.get(i).getNomeCliente());
                pedido.appendChild(nomeCliente);
                Element productos = doc.createElement("productos");
                pedido.appendChild(productos);
                for(int j = 0; j < listaPedidos.get(i).getProductos().size(); j++) {
                    Producto pdt = listaPedidos.get(i).getProductos().get(j);
                    Element producto = doc.createElement("producto");
                    producto.setAttribute("numeroProducto", "" + j);
                    productos.appendChild(producto);
                    Element idProducto = doc.createElement("idProducto");
                    idProducto.setTextContent(pdt.getIdProducto() + "");
                    producto.appendChild(idProducto);
                    Element descripcion = doc.createElement("descripcion");
                    descripcion.setTextContent(pdt.getDescripcion());
                    producto.appendChild(descripcion);
                    Element prezo = doc.createElement("prezo");
                    prezo.setTextContent(pdt.getPrezo() + "");
                    producto.appendChild(prezo);
                }
            }
            
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("test.xml"));
            t.transform(source, result);
        } catch(ParserConfigurationException | TransformerException ex) {
            ex.printStackTrace();
        }
        
    }
     
    public void lePedidosXML() throws IOException {
        try {
            Document docPedidos = null;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(ruta);
            mostraContidoFicheiroNodo(doc.getDocumentElement());
        } catch(ParserConfigurationException | SAXException ex) {
            System.err.println("ERROR: " + ex);
        }
    }
    
    public void mostraContidoFicheiroNodo(Node nodo) throws IOException {
        switch (nodo.getNodeType()) {
            case Node.TEXT_NODE:
                if(nodo.getNodeValue().toString().isBlank() == false && nodo.getNodeValue().toString().isEmpty() == false) {
                    System.out.println("<" + nodo.getNodeName() + "> " + nodo.getNodeValue() + "<" + nodo.getNodeName() + "/>");
                }
                break;
            case Node.ELEMENT_NODE:
                System.out.println("<" + nodo.getNodeName() + ">");
                if(nodo.getChildNodes().getLength() > 0) {
                    for(int i = 0; i < nodo.getChildNodes().getLength(); i++) {
                        mostraContidoFicheiroNodo(nodo.getChildNodes().item(i));
                    }
                }
                System.out.println("<" + nodo.getNodeName() + "/>");
                break;
            default:
                throw new AssertionError();
        }
     
               
    }
    
    public void mostraContidoFicheiro(Document doc) {
        try {
            Document parse = null;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            parse = db.parse(ruta);
            DOMSource domS = new DOMSource(parse);
            StreamResult str = new StreamResult(new StringWriter());
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.transform(domS, str);
            String xmlString = str.getWriter().toString();
            System.out.println(xmlString);
        } catch(ParserConfigurationException | SAXException | IOException | TransformerException ex) {
            System.err.println(ex);
        }
        
    }
    
    /* EJERCICIO 5 */
    
//    public void xeraXMLPedidos() {
//        XStream xstream = new XStream();
//        xstream.setMode(XStream.NO_REFERENCES);
//        xstream.alias("pedidos", List.class);
//        xstream.alias("pedido", Pedido.class);
//        xstream.toXML(listaPedidos, fos);
//    }
    
    
    public static void main(String[] args) throws IOException {
        CrearXMLPedidos cxmlp = new  CrearXMLPedidos();
        //cxmlp.xeraListaPedidos();
        //cxmlp.crearXMLPedidos();
        //cxmlp.lePedidosXML();
        //cxmlp.xeraXMLPedidos();
    }
    
}
