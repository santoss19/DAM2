/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 *
 * @author dam218
 */
public class XestionLibro {
    public static void main(String[] args) {
        UtilidadesLibro ul = new UtilidadesLibro();
        try {
            ul.xerarDatLibro();
            ul.mostraLibros();
            ul.xerarXmlLibroDom();
            ul.xerarXmlLibroXStream();
        } catch (TransformerException | ClassNotFoundException | IOException | ParserConfigurationException e) {
            System.err.println("ERROR: " + e);
        }
    }
}
