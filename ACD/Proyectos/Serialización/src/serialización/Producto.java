/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serialización;

import java.io.Serializable;

/**
 *
 * @author dam218
 */
public class Producto implements Serializable{
    
    private int idProducto;
    private String descripcion;
    private double prezo;

    public Producto() {
    }

    public Producto(int idProducto, String descripcion, double prezo) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.prezo = prezo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", descripcion=" + descripcion + ", prezo=" + prezo + '}';
    }
    
}
