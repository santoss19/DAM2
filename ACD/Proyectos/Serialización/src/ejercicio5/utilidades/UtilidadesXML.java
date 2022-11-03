/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5.utilidades;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author dam218
 */
public class UtilidadesXML {
    
    public Document creaDOMBaleiro(String etiquetaRaiz) {
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation impl = db.getDOMImplementation();
            doc = impl.createDocument(null, etiquetaRaiz, null);
        } catch(ParserConfigurationException ex) {
            System.err.println(ex);
        } 
        return doc;
    }
    
    public Element creaElementoTexto(String nomeEtiqueta, String texto, Document doc) {
        Element el = doc.createElement(nomeEtiqueta);
        el.setTextContent(texto);
        el.appendChild(doc.getDocumentElement());
        return el;
    }
    
    public Document XMLaDOM(String ruta) {
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(ruta);
        } catch(ParserConfigurationException | SAXException | IOException ex) {
            System.err.println(ex);
        }
        return doc;
    }
    
    public void mostraElementoRaiz(Document doc) {
        System.out.println("Elemento raíz : " + doc.getDocumentElement().getNodeName());
    }
    
    public void mostraContidoElemento(Element nodo) {
        try {
            if(nodo.getNodeValue() == null) {
                System.out.println("Este nodo non contén texto");
            } else {
                System.out.println("Contido do elemento " + nodo.getNodeName() + " : " + nodo.getNodeValue());
            }
            if(nodo.getChildNodes().getLength() > 0) {
                System.out.println("Fillos deste nodo :");
                for(int i = 0; i < nodo.getChildNodes().getLength(); i++) {
                    Node el = nodo.getChildNodes().item(i);
                    if(el.getNodeName().equals("#text")) {   
                    } else {
                        System.out.println("    Elemento " + i + " : ");
                        System.out.println("    Nombre : " + el.getNodeName());
                        if(el.getTextContent().isBlank() == false){
                            System.out.println("    Contenido : " + el.getTextContent());
                        }
                    } 
                }
            }
        } catch(DOMException ex) {
            System.err.println(ex);
        }
    }
    
    public Document borraElementosEtiqueta(String nomeEtiqueta, Document doc) {
        Document docB = doc;
        NodeList nl = docB.getDocumentElement().getChildNodes();
        for(int i = 0; i < nl.getLength(); i++) {
            NodeList hs = nl.item(i).getChildNodes();
            for(int j = 0; j < hs.getLength(); j++) {
                if(hs.item(j).getNodeName().equals(nomeEtiqueta)) {
                    Node p = hs.item(j).getParentNode();
                    NodeList phs = p.getChildNodes();
                    for(int k = 0; k < phs.getLength(); k++) {
                        if(phs.item(k).getNodeName().equals(nomeEtiqueta)) {
                            Node br = phs.item(k);
                            try {
                                p.removeChild(br);
                            } catch(DOMException ex) {
                                System.err.println("ERROR:" + ex);
                            }
                            
                        }
                    }
                }
            }
        }
        return docB;
    }
    
    public void DOMaXML(String nomeDocumento, Document doc) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource ds = new DOMSource(doc);
            StreamResult str = new StreamResult(new File(nomeDocumento));
            t.transform(ds, str);
        } catch(TransformerConfigurationException ex) {
            System.err.println(ex);
        } catch(TransformerException ex) {
            System.err.println(ex);
        }
    }
}
