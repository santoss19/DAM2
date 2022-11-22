/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio9;

import com.thoughtworks.xstream.XStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import ejercicio4_y5.Pedido;
import ejercicio1.Producto;

/**
 *
 * @author dam218
 */
public class XMLXstream {
    
    XStream xs = new XStream();
    ListaPedidos pedidos = new ListaPedidos();
    FileInputStream fis;
    ObjectInputStream ois;
    
    public XMLXstream() throws FileNotFoundException, IOException {
        fis = new FileInputStream("pedidos.dat");
        ois = new ObjectInputStream(fis);
    }
    
    public void recuperaPedidos() throws ClassNotFoundException, IOException {
        while(fis.available() > 0) {
            pedidos.getPedidos().add((Pedido) ois.readObject());
        }
        System.err.println(pedidos);
    }
    
    public void exec() throws FileNotFoundException {
        if(pedidos.getPedidos().isEmpty()) {
            System.err.println("A lista dos pedidos está vacía");
        } else {
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("pedidos", ListaPedidos.class);
            xs.alias("pedido", Pedido.class);
            xs.alias("producto", Producto.class);
            xs.toXML(pedidos, new FileOutputStream("pedidos.xml"));
        }
    }
  
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
       XMLXstream xml = new XMLXstream();
       xml.recuperaPedidos();
       xml.exec();
    }
    
}
