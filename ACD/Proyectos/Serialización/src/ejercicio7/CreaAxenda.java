/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ejercicio7;
import ejercicio5.utilidades.UtilidadesXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author dam218
 */

public class CreaAxenda {
    
    final static String[] nomes = {"Rodrigo", "Oscar", "Luis", "Alvaro", "Antonio", "Manolo"};
    final static String[] nTelefono = {"678987612", "678091278", "692345678", "698123098", "612345678", "673123456"};
    final static String[] ruas = {"C/Torres Caidas", "C/César Rodríguez Dorado", "C/Avenida Gonzalo", "C/Avenida General", "C/Google", "C/Acceso a Datos"};
    final static String[] nRuas = {"1", "2", "3", "4", "5", "6"};
    
    public static void main(String[] args) {
        
        UtilidadesXML uxml = new UtilidadesXML();
        Document doc = uxml.creaDOMBaleiro("axenda");
        for(int i = 0; i < 6; i++){
            //Creacion do elemento contacto
            Element el = doc.createElement("contacto");
            //Creacion do elemento nome
            Element nome = doc.createElement("nome");
            nome.setTextContent(nomes[i]);
            el.appendChild(nome);
            //
            //Creacion do elemento nuTelefono
            Element nuTelefono = doc.createElement("nuTelefono");
            nuTelefono.setTextContent(nTelefono[i]);
            nuTelefono.appendChild(el);
            //
            //Creacion do elemento enderezo
            Element enderezo = doc.createElement("enderezo");
            
                Element rua = doc.createElement("rua"); //Elemento rua
                rua.setTextContent(ruas[i]);
                enderezo.appendChild(rua);
                Element numero = doc.createElement("numero"); //Elemento numero
                numero.setTextContent(nRuas[i]);
                enderezo.appendChild(numero);
       
            el.appendChild(enderezo);
            doc.getDocumentElement().appendChild(el);
        }
        uxml.DOMaXML("axenda.xml", doc);   
    }
}
