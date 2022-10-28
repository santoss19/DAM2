/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5.utilidades;

import org.w3c.dom.Document;

/**
 *
 * @author dam218
 */
public class UtilidadesExec {
    public static void main(String[] args) {
        UtilidadesXML uxml = new UtilidadesXML();
        //uxml.DOMaXML("contactos.xml", uxml.creaDOMBaleiro("contactos"));
        Document doc = uxml.XMLaDOM("contactos.xml");
        doc = uxml.borraElementosEtiqueta("contacto", doc);
        //uxml.mostraElementoRaiz(doc);
        //uxml.mostraContidoElemento((Element) doc.getElementsByTagName("contacto").item(0));
        uxml.DOMaXML("contactos.xml", doc);
    }
}
