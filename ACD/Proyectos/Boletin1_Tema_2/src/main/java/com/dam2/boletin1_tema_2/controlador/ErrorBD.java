/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.dam2.boletin1_tema_2.controlador;

/**
 *
 * @author dam218
 */
public enum ErrorBD {
    
    ERROR_CONNECT("Ha ocurrido un error en la conexión a la BD"),
    ERROR_NO_URL("No se ha proporcionado una URL a la BD"),
    ERROR_NO_USER_OR_PASS("No se ha proporcionado un usuario o una contraseña"),
    ERROR_USER("Usuario o contraseña incorrectos"),
    ERROR_NODATA("Datos no encontrados"),
    ERROR_NO_CLASS("No se encontró el driver solicitado / recomendado"),
    ERROR_CON_OPEN("No se puede abrir la conexión porque ya está abierta"),
    ERROR_CON_CLOSED("No se puede cerrar la conexión porque ya está cerrada"),
    ERROR_CLS_ERR("Algo ocurrió mientras se cerraba la conexión, vuelve a intentarlo"),
    ERROR_INC_DATA("Datos del alumno incorrectos"),
    ERROR_RPT_DATA("Los datos del alumno ya están en la BD"),
    ERROR_NO_TABLE("La tabla proporcionada no existe"),
    ERROR_INS_ERROR("La inserción en la BD falló"),
    ERROR_SEL_ERR("La busqueda de datos falló"),
    ERROR_DEL_ERR("El borrado del alumno falló"),
    ERROR_MOD_ERR("La modificación de entradas falló"),
    ERROR_NODATA_APORTED("No se aportó ningún dato para buscar"),
    ERROR_NO_CORRECT_DATA_LETERS("Los datos aportados son erroneos (Letras en vez de números)");    
    protected String msg;
    
    private ErrorBD(String msg) {
        this.msg = msg;
    }
    
    public String getErrorMsg() {
        return this.msg;
    }
    
}
