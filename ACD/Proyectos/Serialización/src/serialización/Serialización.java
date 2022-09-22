/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serialización;

import java.io.IOException;

/**
 *
 * @author dam218
 */
public class Serialización {
     public static void main(String[] args) throws IOException {
        Herramientas herr = new Herramientas();
        
        herr.generarProductos();
        herr.salvarProductos();
        herr.recuperarproductos();
        herr.mostrarLista();
        
    }
}
