/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.boletin1_tema_2.modelo;

/*
 *
 * @author dam218
 * 
 */

public class Alumno {
    
    String dni;
    String nombre;
    String apelidos;
    int idade;
    
    public Alumno() {}

    public Alumno(String dni, String nombre, String apelidos, int idade) {
        this.dni = dni;
        this.nombre = nombre;
        this.apelidos = apelidos;
        this.idade = idade;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Alumno{" + "dni=" + dni + ", nombre=" + nombre + ", apelidos=" + apelidos + ", idade=" + idade + '}';
    }
    
}
