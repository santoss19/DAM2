package com.dam2.EjemplosSQL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam218
 */

public class Test_Connection {

    public static void main(String[] args) {
        
        //Apertura de conexión
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex) {
            System.err.println("ERROR: Clase no encontrada");
        }
        
        Connection con1 = null;

        try {
            String url = "jdbc:mysql://192.168.56.101:3306/pruebas";
            con1 = DriverManager.getConnection(url, "aduser", "abc123.");
            con1.setAutoCommit(false);
            System.out.println("Conexión completada");
        } catch (SQLException ex) {
            Logger.getLogger(Test_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Añadido de tablas
        
        try {
            
            String insertTable = "CREATE TABLE alumnos ("
                + " DNI varchar(8) PRIMARY KEY,"
                + " nome varchar(20),"
                + " apelidos varchar(20))"
            ;
            
            Statement stmnt = con1.createStatement();
            stmnt.executeUpdate(insertTable);
            
        } catch(SQLException ex) {
            System.err.println("ERROR: " + ex);
        } finally {
            try {
                con1.commit();
            } catch(SQLException ex) {
               System.err.println("ERROR: " + ex);
            }
        }
        
        
        
        // Modificación, insercción y borrado de datos
        
        try {
            
            String insertDatos = "INSERT INTO alumnos(DNI, nome, apelidos) VALUES "
                    + "('1A', 'Luhish', 'Lustres'),"
                    + "('2B', 'Alvaro', 'Regueira'),"
                    + "('3C', 'Alberto', 'Romero');"
            ;
            
            String updateDatos = "UPDATE alumnos " +
                    "SET nome='Oscar', apelidos='Torres Caídas' " +
                    "WHERE nome = 'Alberto';";
            
            String deleteDatos = "DELETE FROM alumnos WHERE nome = 'Alvaro';";
            
            Statement stmnt = con1.createStatement();
            
            // Ejecución del INSERT
            
            stmnt.executeUpdate(insertDatos);
            System.out.println("INSERT completado");
            
            // Ejecución del UPDATE
            
            stmnt.executeUpdate(updateDatos);
            System.out.println("UPDATE completado");
            
            // Ejecución del DELETE
            
            stmnt.executeUpdate(deleteDatos);
            System.out.println("DELETE completado");
            
        } catch(SQLException ex) {
            System.err.println("ERROR: " + ex);
        } finally {
            try {
                
                // Commit para guardar los cambios
                
                con1.commit();
            } catch(SQLException ex) {
               System.err.println("ERROR: " + ex);
            }
        }

        // Cierre de conexión
        
        try {
            con1.close();
            System.out.println("Conexión cerrada");
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex);
        }
    }

}
