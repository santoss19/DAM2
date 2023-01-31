/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.boletin1_tema_2.vista;

import com.dam2.boletin1_tema_2.controlador.ErrorBD;
import com.dam2.boletin1_tema_2.controlador.OperacionesBD;
import com.dam2.boletin1_tema_2.modelo.Alumno;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dam218
 */
public class Menu {
    
    protected static final String URL = "jdbc:mysql://192.168.56.101:3306/tarea1_bd";
    protected static final String USR = "tarea1_bd";
    protected static final String PASSW = "abc123.";
    protected static final Scanner scan = new Scanner(System.in);
    protected static final OperacionesBD opc = new OperacionesBD();

    protected Alumno crearAlumno(int opcion) {

        Alumno al = new Alumno();

        switch (opcion) {
            case 0:
                System.out.print("Introduce DNI: ");
                al.setDni(scan.next());
                break;
            case 1:
                System.out.print("Introduce nombre: ");
                al.setNombre(scan.next());
                break;
            case 2:
                System.out.print("Introduce nombre: ");
                al.setNombre(scan.next());
                System.out.println("");
                System.out.print("Introcue apellidos: ");
                al.setApelidos(scan.next());
                break;
            case 3:
                System.out.print("Introduce apellidos: ");
                al.setApelidos(scan.next());
                break;
            case 4:
                System.out.print("Introduce edad: ");
                try {
                    al.setIdade(Integer.parseInt(scan.next()));
                } catch (NumberFormatException ex) {
                    System.err.println("ERROR: " + ErrorBD.ERROR_NO_CORRECT_DATA_LETERS.getErrorMsg());
                }
                break;
            default:
                throw new AssertionError();
        }

        return al;
    }

    protected Alumno crearAlumno() {

        Alumno al = new Alumno();

        System.out.print("Introduce DNI: ");
        al.setDni(scan.next());

        System.out.print("Introduce nombre: ");
        al.setNombre(scan.next());

        System.out.print("Introduce apellidos: ");
        al.setApelidos(scan.next());

        System.out.print("Introduce edad: ");
        try {
            al.setIdade(Integer.parseInt(scan.next()));
        } catch (NumberFormatException ex) {
            System.err.println("ERROR: " + ErrorBD.ERROR_NO_CORRECT_DATA_LETERS.getErrorMsg());
        }
        
        return al;
    }
    
    protected Alumno modAlumno() {
        
        Alumno alu = new Alumno();
        
        int opcion = 0;
        
        do {
            
            do {
                
                System.out.print("Dame DNI del alumno : ");
                alu.setDni(scan.next());
                
            } while(alu.getDni() == null);
            
            
            System.out.println("¿ Que quieres modificar ?");
            System.out.println("1. Nombre");
            System.out.println("2. Apellidos");
            System.out.println("3. Edad");
            
            try {
                opcion = Integer.parseInt(scan.next());
            } catch(NumberFormatException ex) {
                System.err.println("ERROR: " + ErrorBD.ERROR_NO_CORRECT_DATA_LETERS.getErrorMsg());
            }
            
            switch(opcion) {
                case 1:
                    System.out.print("Dame nombre nuevo: ");
                    alu.setNombre(scan.next());
                    break;
                case 2:
                    System.out.print("Dame apellidos nuevos: ");
                    alu.setApelidos(scan.next());
                    break;
                case 3:
                    System.out.print("Dame edad nueva: ");
                    try {
                        alu.setIdade(Integer.parseInt(scan.next()));
                    } catch(NumberFormatException ex) {
                        System.err.println("ERROR: " + ErrorBD.ERROR_NO_CORRECT_DATA_LETERS.getErrorMsg());
                    }
                    break;
                default : 
                    System.out.println("Opcion equivocada...");
            }
            
        } while(opcion != 1 && opcion != 2 && opcion != 3);
        
        return alu;
    }

    protected boolean imprimirMenu(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("=== ALUMNOS DATA BASE ===");
                System.out.println("1.Agregar alumno");
                System.out.println("2.Recuperar alumno");
                System.out.println("3.Borrar alumno");
                System.out.println("4.Modificar alumno");
                System.out.println("5.Recuperar alumnos");
                System.out.println("6.Recuperar alumnos (filtrando)");
                System.out.println("7.Salir");
                return true;
            case 2:
                System.out.println("=== ALUMNOS DATA BASE ===");
                System.out.println("1.Filtrar por DNI");
                System.out.println("2.Filtrar por nombre");
                System.out.println("3.Filtrar por nombre y por apellidos");
                System.out.println("4.Filtrar por apellidos");
                System.out.println("5.Filtrar por edad");
                System.out.println("6.Cancelar");
                return true;
            case 3:
                System.out.println("=== ALUMNOS DATA BASE ===");
                System.out.println("1.Abrir conexión");
                System.out.println("2.Salir");
                return true;
            default:
                return false;
        }

    }
    
    protected void menuInicio() {
        
        int opcion = 0;
        
        do {
            
            this.imprimirMenu(3);
            
            try {
                opcion = Integer.parseInt(scan.next());
            } catch(NumberFormatException ex) {
                System.err.println("ERROR: " + ErrorBD.ERROR_NO_CORRECT_DATA_LETERS.getErrorMsg());
            }
            
            switch (opcion) {
                case 1:
                    opc.abrirConexion(URL, USR, PASSW);
                    this.menu();
                    break;
                case 2:
                    try {
                        System.out.println("Saliendo ...");
                        Thread.sleep(2000);
                    } catch(InterruptedException ex) {
                        System.err.println("Interrumpido");
                    }
                    break;
                default:
                    System.err.println("Opcion equivocada ...");
                    break;
            }
            
        } while(opcion != 2);
        
    }

    protected void menu() {

        Alumno al = new Alumno();
        

        int opcion = 0;

        do {
            
            this.imprimirMenu(1);

            try {
                opcion = Integer.parseInt(scan.next());
            } catch (NumberFormatException ex) {
                System.err.println("ERROR: Solo se debe introducir un número del 1 al 7");
            }

            switch (opcion) {
                case 1:
                    al = this.crearAlumno();
                    opc.agregaAlumno(al);
                    break;
                case 2:
                    al = this.crearAlumno(0);
                    System.out.println(opc.consultaAlumno(al.getDni()).toString());
                    break;
                case 3:
                    al = this.crearAlumno(0);
                    opc.borrarAlumno(al.getDni());
                    break;
                case 4:
                    al = this.modAlumno();
                    opc.modificaAlumno(al);
                    break;
                case 5:
                    List<Alumno> alumnos = opc.listadoAlumnos();
                    for(Alumno alu : alumnos) {
                        System.out.println(alu.toString());
                    }
                    break;
                case 6:
                    menuFiltrar();
                    break;
                case 7:
                    try {
                        System.out.println("Saliendo...");
                        opc.cerrarConexion();
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        System.err.println("ERROR: Interrumpido");
                    }
                    break;
                default:
                    System.out.println("Opción equivocada..");
                    break;
            }
            
        } while (opcion != 7);

    }

    protected void menuFiltrar() {

        int opcion = 0;
        Alumno al = new Alumno();

        do {
            
            List<Alumno> alumnos = null;
            
            this.imprimirMenu(2);

            try {
                opcion = Integer.parseInt(scan.next());
            } catch (NumberFormatException ex) {
                System.err.println("ERROR: Solo se debe introducir un número del 1 al 5");
            }

            switch (opcion) {
                case 1:
                    al = this.crearAlumno(0);
                    alumnos = opc.listadoAlumnos(al);
                    for(Alumno alu : alumnos) {
                        System.out.println(alu.toString());
                    }
                    break;
                case 2:
                    al = this.crearAlumno(1);
                    alumnos = opc.listadoAlumnos(al);
                    for(Alumno alu : alumnos) {
                        System.out.println(alu.toString());
                    }
                    break;
                case 3:
                    al = this.crearAlumno(2);
                    alumnos = opc.listadoAlumnos(al);
                    for(Alumno alu : alumnos) {
                        System.out.println(alu.toString());
                    }
                    break;
                case 4:
                    al = this.crearAlumno(3);
                    alumnos = opc.listadoAlumnos(al);
                    for(Alumno alu : alumnos) {
                        System.out.println(alu.toString());
                    }
                    break;
                case 5:
                    al = this.crearAlumno(4);
                    alumnos = opc.listadoAlumnos(al);
                    for(Alumno alu : alumnos) {
                        System.out.println(alu.toString());
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        System.err.println("Interrumpido...");
                    }
                default:
                    System.out.println("Opción equivocada");
                    break;
            }

        } while (opcion != 6);

    }

    public void startMenu() {
        this.menuInicio();
        scan.close();
    }
}
