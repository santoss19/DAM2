/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.modelo;

import es.leliadoura.ad.gestionempresas.modelo.entity.Contacto;
import es.leliadoura.ad.gestionempresas.modelo.entity.Contrato;
import es.leliadoura.ad.gestionempresas.modelo.entity.Empresa;
import es.leliadoura.ad.gestionempresas.modelo.entity.Trabajador;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author dam218
 */
public class PersistenciaDatosImpl implements PersistenciaDatos {
    
    @Override
    public void guardaEmpresa(Empresa empresa) {
        
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        
        if(!empresa.isEmpty()) {
            session.persist(empresa);
        }
        
        session.getTransaction().commit();
        
    }

    @Override
    public void modificarEmpresa(Empresa empresa) {
        
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        
        if(!empresa.isEmpty()) {
            session.merge(empresa);
        }
        
        session.getTransaction().commit();
        
    }

    @Override
    public Empresa consultaEmpresa(String NIF) {
        
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        Empresa empresa = null;
        
        if(!NIF.isBlank() && !NIF.isEmpty()) {
            empresa = session.find(Empresa.class, NIF);
        }
        
        return empresa;
        
    }

    @Override
    public void guardaTrabajador(Trabajador trabajador) {
        
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        
        if(!trabajador.isEmpty()) {
            sesion.persist(trabajador);
        }
        
        sesion.getTransaction().commit();
        
    }

    @Override
    public void modificarTrabajador(Trabajador trabajador) {
        
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        
        if(!trabajador.isEmpty()) {
            sesion.merge(trabajador);
        }
        
        sesion.getTransaction().commit();
        
    }

    @Override
    public Trabajador consultaTrabajador(String DNI) {
        Trabajador t = null;
        
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        
        t = sesion.find(Trabajador.class, DNI);
        
        sesion.getTransaction().commit();
        
        return t;
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        
        sesion.persist(contacto);
        
        sesion.getTransaction().commit();
        
    }

    @Override
    public void modificarContacto(Contacto contacto) {
        
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        
        sesion.merge(contacto);
        
        sesion.getTransaction().commit();
        
    }

    @Override
    public void borrarContacto(Contacto contacto) {
        
        Session sesion = HibernateSession.getSession();
        sesion.beginTransaction();
        
        sesion.remove(contacto);
        
        sesion.getTransaction().commit();
    }

    @Override
    public Contacto recuperaContacto(String correo, String nombre, String apellidos) {
        
        Contacto contacto = new Contacto();
        Session sesion = HibernateSession.getSession();
        
        sesion.beginTransaction();
        
        sesion.createQuery(correo, Contacto.class);
        
        
        
        return contacto;
    }

    @Override
    public void guardarContrato(Contrato contrato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificarContrato(Contrato contrato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Contrato recuperaContrato(String DNI, String NIF, Date fecInicio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Contrato> consultaContratosEmpresa(String NIF) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Contrato> consultaContratosActualesEmpresa(String NIF) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Contrato> consultaContratosTrabajador(String DNI) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Empresa> consultaEmpresas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Trabajador> consultaTrabajadores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Contrato> consultaContratos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Contacto> consultaContactos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
