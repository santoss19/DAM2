/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio8;

import ejercicio6.UtilidadesXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author dam218
 */
public class ProcesaAxenda {
    public static void main(String[] args) {
        UtilidadesXML uxml = new UtilidadesXML();
        Document doc = uxml.XMLaDOM("axenda.xml");
        uxml.mostraElementoRaiz(doc);
        uxml.mostraContidoDoFicheiro();
        Document axenda1 = uxml.borraElementosEtiqueta("nuTelefono", doc);
        uxml.DOMaXML("axenda1.xml", axenda1);
        Document axenda2 = uxml.borraElementosEtiqueta("enderezo", doc);
        uxml.DOMaXML("axenda2.xml", axenda2);
        Document axenda3 = uxml.añadeElementoAoDocumento("correoe");
        uxml.DOMaXML("axenda3.xml", axenda3);
    }
}
