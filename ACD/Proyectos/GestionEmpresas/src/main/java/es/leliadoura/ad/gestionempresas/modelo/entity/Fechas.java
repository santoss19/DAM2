/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.modelo.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dam218
 */
public class Fechas {
    
    public String datoToString(Date fecha) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simplFormat = new SimpleDateFormat(pattern);
        return simplFormat.format(fecha);
    }
    
    public Date stringToDate(String fecha) {
        String patter = "yyyy-MM-dd";
        SimpleDateFormat simpleFormat = new SimpleDateFormat(patter);
        try {
            return simpleFormat.parse(fecha);
        } catch(ParseException ex) {
            System.err.println("Error al pasar a formate DATE");
        }
        return null;
    }
    
}
