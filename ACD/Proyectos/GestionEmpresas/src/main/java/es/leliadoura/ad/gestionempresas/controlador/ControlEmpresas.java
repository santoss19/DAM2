/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.controlador;

import es.leliadoura.ad.gestionempresas.errores.ControlEmpresasException;
import es.leliadoura.ad.gestionempresas.modelo.entity.Contrato;
import es.leliadoura.ad.gestionempresas.modelo.entity.Empresa;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author marco
 */
public interface ControlEmpresas {

    /**
     * Comprueba si existe la empresa y si no existe, la guarda.Si existe,
     * devuelve un error.
     *
     * @param empresa a guardar
     * @throws es.leliadoura.ad.gestionempresas.errores.ControlEmpresasException
     * en caso de no poderse guardar
     */
    public void guardaEmpresa(Empresa empresa) throws ControlEmpresasException;

    /**
     * Comprueba si existe la empresa; si no existe, la guarda y si existe la
     * actualiza.
     *
     * @param empresa a guardar o actualizar
     */
    public void guardaActualizaEmpresa(Empresa empresa);

    /**
     * Busca la empresa y el trabajador y los asocia creando un nuevo contrato
     * con los datos indicados
     *
     * @param NIF identificador de la empresa
     * @param DNI identificador del trabajador
     * @param fecInicial fecha de inicio del contrato
     * @param salario salario bruto anual
     * @param horas jornada semanal en horas
     * @throws es.leliadoura.ad.gestionempresas.errores.ControlEmpresasException
     * en caso de error al intentar crear el contrato
     */
    public void crearContrato(String NIF, String DNI, Date fecInicial, BigDecimal salario, Integer horas) throws ControlEmpresasException;

    /**
     * Recupera el contrato actual existente entre una empresa y un trabajador
     *
     * @param DNI identificador del trabajador
     * @param NIF identificador de la empresa
     * @return el objeto contrato recuperado o null si no existe
     */
    public Contrato consultaContratoActual(String DNI, String NIF);
    
    /**
     * Comprueba si ya existe una empresa registrada con el NIF
     * @param NIF identificador de la empresa
     * @return true en caso de ya existir el NIF y false si no existe
     */
    public boolean existeEmpresa(String NIF);
}
