/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam2.boletin1_tema_2.controlador;

import java.sql.SQLException;

/**
 *
 * @author dam218
 */
public class OperacionBDException extends SQLException {
    public OperacionBDException(String errorMessage) {
        super(errorMessage);
    }
}
