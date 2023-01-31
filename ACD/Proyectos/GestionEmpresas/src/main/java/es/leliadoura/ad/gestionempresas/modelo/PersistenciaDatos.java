package es.leliadoura.ad.gestionempresas.modelo;

import es.leliadoura.ad.gestionempresas.modelo.entity.Contacto;
import es.leliadoura.ad.gestionempresas.modelo.entity.Contrato;
import es.leliadoura.ad.gestionempresas.modelo.entity.Empresa;
import es.leliadoura.ad.gestionempresas.modelo.entity.Trabajador;
import java.util.Date;
import java.util.List;

/**
 * Acceso a la capa de persistencia
 *
 * @author marco
 */
public interface PersistenciaDatos {

    /**
     * Guarda una empresa
     *
     * @param empresa objeto a guardar
     */
    public void guardaEmpresa(Empresa empresa);

    /**
     * Modifica una empresa
     *
     * @param empresa objeto a modificar
     */
    public void modificarEmpresa(Empresa empresa);

    /**
     * Busca y devuelve la empresa por su NIF
     *
     * @param NIF identificador de la empresa
     * @return objeto empresa recuperado o null si no existe
     */
    public Empresa consultaEmpresa(String NIF);

    /**
     * Guarda un trabajador
     *
     * @param trabajador objeto a guardar
     */
    public void guardaTrabajador(Trabajador trabajador);

    /**
     * Modifica un trabajador
     *
     * @param trabajador objeto a modificar
     */
    public void modificarTrabajador(Trabajador trabajador);

    /**
     * Busca y devuelve la empresa por su DNI
     *
     * @param DNI identificador del trabajador
     * @return objeto empresa recuperado o null si no existe
     */
    public Trabajador consultaTrabajador(String DNI);

    /**
     * Guarda un contacto
     *
     * @param contacto objeto a guardar
     */
    public void guardarContacto(Contacto contacto);

    /**
     * Modificar un contacto
     *
     * @param contacto objeto a modificar
     */
    public void modificarContacto(Contacto contacto);

    /**
     * Borra un contacto
     *
     * @param contacto objeto a borrar
     */
    public void borrarContacto(Contacto contacto);

    /**
     * Recupera un contacto a partir de su correo electrónico
     *
     * @param correo
     * @param nombre
     * @param apellidos
     * @return objeto contacto recuperado o null si no existe
     */
    public Contacto recuperaContacto(String correo, String nombre, String apellidos);

    /**
     * Guarda un contrato
     *
     * @param contrato objeto a guardar
     */
    public void guardarContrato(Contrato contrato);

    /**
     * Modifica un contrato
     *
     * @param contrato objeto a modificar
     */
    public void modificarContrato(Contrato contrato);

    /**
     * Recupera un contrato a partir de su id
     *
     * @param DNI
     * @param NIF
     * @param fecInicio
     * 
     * @return el objeto contrato recuperado o null si no existe
     */
    public Contrato recuperaContrato(String DNI, String NIF, Date fecInicio);

    /**
     * Recupera la lista de contratos de una empresa
     *
     * @param NIF identificador de la empresa
     * @return listado de contratos
     */
    public List<Contrato> consultaContratosEmpresa(String NIF);

    /**
     * Recupera la lista de contratos vigentes de una empresa
     *
     * @param NIF identificador de la empresa
     * @return listado de contratos
     */
    public List<Contrato> consultaContratosActualesEmpresa(String NIF);

    /**
     * Recupera la lista de contratos de un trabajador
     *
     * @param DNI identificador del trabajador
     * @return listado de contratos
     */
    public List<Contrato> consultaContratosTrabajador(String DNI);

    /**
     * Recupera el listado completo de empresas
     *
     * @return
     */
    public List<Empresa> consultaEmpresas();

    /**
     * Recupera el listado completo de trabjadores
     *
     * @return
     */
    public List<Trabajador> consultaTrabajadores();

    /**
     * Recupera el listado completo de contratos
     *
     * @return
     */
    public List<Contrato> consultaContratos();

    /**
     * Recupera el listado completo de contactos
     *
     * @return
     */
    public List<Contacto> consultaContactos();

}
