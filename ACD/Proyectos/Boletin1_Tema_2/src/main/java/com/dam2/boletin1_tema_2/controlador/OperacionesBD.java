/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.boletin1_tema_2.controlador;

import com.dam2.boletin1_tema_2.modelo.Alumno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam218
 * 
 */


/**
 * 
 * NOTA : WORKING !!
 * 
**/

public class OperacionesBD {

    protected Connection con = null;

    public boolean abrirConexion(String url, String user, String passw) {

        boolean sucess = false;

        try {
            if(con != null) {
                if (con.isClosed()) {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection(url, user, passw);
                    con.setAutoCommit(true);
                    sucess = true;
                } else {
                    System.err.println(ErrorBD.ERROR_CON_OPEN.getErrorMsg());
                } 
            } else {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, passw);
                con.setAutoCommit(true);
                sucess = true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.err.println(ErrorBD.ERROR_NO_CLASS.getErrorMsg());
        } catch (OperacionBDException ex) {
            if (url.isBlank() || url.isEmpty()) {
                throw new OperacionBDException(ErrorBD.ERROR_NO_URL.getErrorMsg());
            }
            if (user.isBlank() || user.isEmpty()) {
                throw new OperacionBDException(ErrorBD.ERROR_NO_USER_OR_PASS.getErrorMsg());
            }
            if (passw.isBlank() || passw.isEmpty()) {
                throw new OperacionBDException(ErrorBD.ERROR_NO_USER_OR_PASS.getErrorMsg());
            }
            throw new OperacionBDException(ErrorBD.ERROR_CONNECT.getErrorMsg());
        } finally {
            return sucess;
        }

    }

    public boolean cerrarConexion() {

        boolean sucess = false;

        try {
            if (!con.isClosed()) {
                con.close();
                sucess = true;
                System.out.println("Conexión cerrada");
            } else {
                System.err.println(ErrorBD.ERROR_CON_CLOSED.getErrorMsg());
            }
        } catch (OperacionBDException e) {
            throw new OperacionBDException(ErrorBD.ERROR_CLS_ERR.getErrorMsg());
        } finally {
            return sucess;
        }

    }

    public boolean agregaAlumno(Alumno al) {

        boolean sucess = false;

        try {

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO alumno(dni, nome, apelidos, idade) VALUES (?, ?, ?, ?)");

            pstmt.setString(1, al.getDni());
            pstmt.setString(2, al.getNombre());
            pstmt.setString(3, al.getApelidos());
            pstmt.setInt(4, al.getIdade());

            pstmt.execute();

            sucess = true;
        } catch (OperacionBDException e) {
            throw new OperacionBDException(e.getMessage());
        } finally {
            return sucess;
        }

    }

    public Alumno consultaAlumno(String dni) {
        Alumno al = new Alumno();

        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM alumno WHERE dni LIKE '" + dni + "'");

            while(result.next()) {
                al.setDni(result.getString("dni"));
                al.setNombre(result.getString("nome"));
                al.setApelidos(result.getString("apelidos"));
                al.setIdade(result.getInt("idade"));
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ErrorBD.ERROR_SEL_ERR.getErrorMsg());
        }

        return al;
    }

    public int borrarAlumno(String dni) {
        int t = 0;

        try {
            Statement stmt = con.createStatement();
            t = stmt.executeUpdate("DELETE FROM alumno WHERE dni LIKE '" + dni + "'");
        } catch (SQLException ex) {
            System.err.println(ErrorBD.ERROR_DEL_ERR.getErrorMsg());
        }

        return t;
    }

    public int modificaAlumno(Alumno al) {
        int t = 0;
        
        if(this.consultaAlumno(al.getDni()) != null) {
            String sql = "UPDATE alumno ";

            if(al.getNombre() != null) {
                if(sql.contains("SET")) {
                    sql = sql + ", nome='" + al.getNombre() + "'";
                } else {
                    sql = sql + "SET nome='" + al.getNombre() + "'";
                }
            }
            
            if(al.getApelidos()!= null) {
                if(sql.contains("SET")) {
                    sql = sql + ", apelidos='" + al.getApelidos()+ "'";
                } else {
                    sql = sql + "SET apelidos='" + al.getApelidos()+ "'";
                }
            }
            
            if(al.getIdade()!= 0) {
                if(sql.contains("SET")) {
                    sql = sql + ", idade='" + al.getIdade()+ "'";
                } else {
                    sql = sql + "SET idade='" + al.getIdade()+ "'";
                }
            }
            
            sql = sql + " WHERE dni LIKE '" + al.getDni() + "'";

            try {
                Statement stmt = con.createStatement();
                t = stmt.executeUpdate(sql);

            } catch (SQLException ex) {
                System.err.println("ERROR: " + ErrorBD.ERROR_MOD_ERR.getErrorMsg() + "(" + ex.getMessage() + ")");
            }
        }
            
        return t;
    }
    
    // Clase de ayuda a los métodos de filtrado de alumnos //
    
    protected List<Alumno> buscaAlumnos(String sql) { 
        
        List<Alumno> lista = new ArrayList<>();
        
        Alumno alNew = null;
        
        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                alNew = new Alumno(rs.getString("dni"),
                        rs.getString("nome"),
                        rs.getString("apelidos"),
                        rs.getInt("idade")
                );

                lista.add(alNew);
            }

        } catch (SQLException e) {
            System.err.println("ERROR : " + ErrorBD.ERROR_SEL_ERR.getErrorMsg());
        }
        
        return lista;
    }
    
    // ------------------------------------------------------- //

    public List<Alumno> listadoAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        
        String sql = "SELECT * FROM alumno";

        alumnos = this.buscaAlumnos(sql);

        return alumnos;
    }

    public List<Alumno> listadoAlumnos(Alumno al) {
        
        List<Alumno> alumnos = new ArrayList<>();

        String sql = "";

        if (al.getDni() != null) {
            
            sql = "SELECT * FROM alumno WHERE dni LIKE '" + al.getDni() + "'";
            
            alumnos = this.buscaAlumnos(sql);
            
            return alumnos;
            
        }

        if (al.getNombre() != null) {
            if (al.getApelidos() != null) {
                
                sql = "SELECT * FROM alumno WHERE nome LIKE '" + al.getNombre() + "' AND apelidos LIKE '" + al.getApelidos() + "'";
                
                alumnos = this.buscaAlumnos(sql);
                
                return alumnos;
               
            } else {
                
                sql = "SELECT * FROM alumno WHERE nome LIKE '" + al.getNombre() + "'";
                
                alumnos = this.buscaAlumnos(sql);
                
                return alumnos;
                
            }

        }

        if (al.getApelidos() != null) {
            
            sql = "SELECT * FROM alumno WHERE apelidos LIKE '" + al.getApelidos() + "'";
            
            alumnos = this.buscaAlumnos(sql);
            
            return alumnos;
            
        }

        if (al.getIdade() > 0) {
            
            sql = "SELECT * FROM alumno WHERE idade >= '" + al.getIdade() + "'";
            
            alumnos = this.buscaAlumnos(sql);
            
            return alumnos;
           
        }

        return null;
    }
    
}
