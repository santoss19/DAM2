/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serialización;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import producto.CrearXMLPedidos;

/**
 *
 * @author dam218
 */

public class Herramientas {
    
    private int nums[] = {1,2,3,4,5};
    private String noms[] = {"Mango", "Pera", "Melocotón", "Fresa", "Kiwi"};
    private double pre[] = {1.24, 1.89, 0.90, 2.30, 2.10};
    private List<Producto> productos;
    private File fich = new File("produto.dat");
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private FileInputStream fis;
    private ObjectInputStream ois;

    public Herramientas() throws IOException {
        try {
            this.fos = new FileOutputStream(fich);
            this.fis = new FileInputStream(fich);
        } catch (FileNotFoundException ex) {
            System.err.println("ERROR: Archivo no encontrado o no accesible");
        }
        
        this.oos = new ObjectOutputStream(fos);
        this.ois = new ObjectInputStream(fis);
        this.productos = new ArrayList();
    }
    
    public void generarProductos() {
        for(int i = 0; i < nums.length; i++){
            productos.add(new Producto(nums[i], noms[i], pre[i]));
        }
    }
    
    public void salvarProductos() throws IOException {
        for(Producto producto : productos) {
            oos.writeObject(producto);
        }
        productos.removeAll(productos);
        oos.close();
        fos.close();
    }
    
    public void recuperarproductos() throws IOException {
        
        Producto producto = null;
        
        if(productos.isEmpty() != true) {
            productos.removeAll(productos);
        }
        
        while(fis.available() > 0) {
            try {
                producto = (Producto)ois.readObject();
            } catch (ClassNotFoundException ex) {
                System.err.println("ERROR: Clase del objeto no encontrada");
            }
            productos.add(producto);
        }
        ois.close();
        fis.close();
    }
    
    public void mostrarLista() {
        for(Producto producto : productos) {
            System.out.println(producto.toString());
        }
    }

    public List<Producto> getProductos() {
        List<Producto> pdts = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            pdts.add(new Producto(nums[i], noms[i], pre[i]));
        }
        return pdts;
    }
    
    public static void main(String[] args) throws IOException {
        Herramientas herr = new Herramientas();
        System.out.println(herr.getProductos());
    }
    
}
