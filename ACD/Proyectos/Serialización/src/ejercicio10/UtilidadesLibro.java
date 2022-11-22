/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10;

import com.thoughtworks.xstream.XStream;
import ejercicio9.ListaPedidos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import ejercicio4_y5.Pedido;
import ejercicio1.Producto;

/**
 *
 * @author dam218
 */
public class UtilidadesLibro {
    
    File file = new File("libros.dat");
    FileOutputStream fos ;
    ObjectOutputStream oos;
    FileInputStream fis;
    ObjectInputStream ois;
    String[] isbn = {"17617172", "18371811", "18618191", "1837119371", "193973ADHA", "18362174HBD"};
    int[] anoP = {1991, 1992, 1993, 1994, 1995, 1996};
    String[] tit = {"TEST 1", "TEST 2", "TEST 3", "TEST 4", "TEST 5", "TEST 6"};
    List<String> aut = new ArrayList<>();
    Persoa[] lect = {new Persoa("Luhish", "25352113K"), new Persoa("Marco", "813718Ñ"), new Persoa("Oscar", "1371837U"), new Persoa("Alberto", "173781D"), new Persoa("Alvarote", "18371828P"), new Persoa("Jorge", "17368281M")};
    
    public UtilidadesLibro() {
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch(IOException ex2) {
            System.err.println(ex2);
        }
        
        String[] nombres = {"Luis", "Torres", "Alvaro", "Alberto", "Jorge","Jaime"};
        aut.addAll(Arrays.asList(nombres));
    }
    
    public void xerarDatLibro() throws IOException {
        for(int i = 0; i < 6; i++) {
            Libro lib = new Libro(isbn[i], tit[i], aut, anoP[i], false, lect[i]);
            oos.writeObject(lib);
        }
        oos.close();
        fos.close();
    }
    
    public void mostraLibros() throws IOException, ClassNotFoundException {
        while(fis.available() > 0) {
            Libro lib = (Libro) ois.readObject();
            System.out.println(lib.toString());
        }
        ois.close();
        fis.close();
    }
    
    protected Libro[] obterDatosArquivo() throws IOException, ClassNotFoundException {
        
        FileInputStream fisO = null;
        ObjectInputStream oisO = null;
        
        try {
            fisO = new FileInputStream(file);
            oisO = new ObjectInputStream(fisO);
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch(IOException ex2) {
            System.err.println(ex2);
        }
        
        Libro[] libros = new Libro[6];
        int i = 0;
        while(fisO.available() > 0) {
            Libro lib = (Libro) oisO.readObject();
            libros[i] = lib;
            i++;
        }
        return libros;
    }
    
    protected Node creaElementoNovo(Document doc, Node pai, String nombreNodo, String contido) {
        if(pai == null) {
            if(contido == null) {
                Node nod = doc.createElement(nombreNodo);
                doc.getDocumentElement().appendChild(nod);
                return nod;
            } else {
                Node nod = doc.createElement(nombreNodo);
                nod.setTextContent(contido);
                doc.getDocumentElement().appendChild(nod);
                return nod;
            }
        } else {
            if(contido == null) {
                Node nod = doc.createElement(nombreNodo);
                pai.appendChild(nod);
                return nod;
            } else {
                Node nod = doc.createElement(nombreNodo);
                nod.setTextContent(contido);
                pai.appendChild(nod);
                return nod;
            }
        }
    }
    
    public void xerarXmlLibroDom() throws IOException, ClassNotFoundException, ParserConfigurationException, TransformerException {
       
        Libro[] libros = this.obterDatosArquivo();     
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        DOMImplementation imp = db.getDOMImplementation();
        Document doc = imp.createDocument(null, "libros", null);
        
        for(int i = 0; i < libros.length; i++) {
            Libro lib = libros[i];
            Node pai = creaElementoNovo(doc, doc.getDocumentElement(), "libro", null);
            creaElementoNovo(doc, pai, "isbn", lib.getISBN());
            creaElementoNovo(doc, pai, "titulo", lib.getTitulo());
            Node autores = creaElementoNovo(doc, pai, "autores", null);
            for(int j = 0; j < lib.getAutores().size(); j++) {
                creaElementoNovo(doc, autores, "autor", lib.getAutores().get(j));
            }
            creaElementoNovo(doc, pai, "anoPublicación", "" + lib.getAnoPublicacion());
            creaElementoNovo(doc, pai, "prestado", lib.isPrestado() + "");
            Node lector = creaElementoNovo(doc, pai, "lector", null);
            creaElementoNovo(doc, lector, "nombre", lib.getLector().getNome());
            creaElementoNovo(doc, lector, "dni", lib.getLector().getDNI());
        }
        
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult str = new StreamResult(new File("libros.xml"));
        t.transform(source, str);
        ois.close();
        fis.close();
    }
    
    public void xerarXmlLibroXStream() throws IOException, ClassNotFoundException {
        XStream xs = new XStream();
        ListaLibros listalibros = new ListaLibros();
        listalibros.getLibros().addAll(Arrays.asList(this.obterDatosArquivo()));
        
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("libros", ListaLibros.class);
        xs.alias("libro", Libro.class);
        xs.toXML(listalibros, new FileOutputStream("libros.xml"));
        
    }
    
}
