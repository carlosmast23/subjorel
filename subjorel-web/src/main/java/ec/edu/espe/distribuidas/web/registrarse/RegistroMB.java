/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.web.registrarse;

import ec.edu.espe.distribuidas.subjorel.exception.ValidacionException;
import ec.edu.espe.distribuidas.subjorel.modelo.DatosPersonales;
import ec.edu.espe.distribuidas.subjorel.modelo.Usuario;
import ec.edu.espe.distribuidas.subjorel.servicio.UsuarioServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author carlo
 */
@ManagedBean
@RequestScoped
public class RegistroMB implements Serializable {

    private Usuario usuario;
    private DatosPersonales datosPersonales;
    private Date calendario;

    @EJB
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void postConstruct() {
        usuario = new Usuario();
        datosPersonales = new DatosPersonales();
    }

    public String registrarUsuario() {
        
        try {
            usuarioServicio.crearUsuarioDatos(usuario, datosPersonales);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Usuario Creado", "El usuario fue creado correctamente"));
            context.addMessage(null, new FacesMessage("Ingrese con su cuenta", "Ingrese con su nick y clave"));
            return "login";
        } catch (ValidacionException ex) 
        {
            //System.out.println("Error ejb");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(ex.getMessage(),"Vuelva a intentar"));
            //System.err.println(ex.getMessage());
            return "registrarse";
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public Date getCalendario() {
        return calendario;
    }

    public void setCalendario(Date calendario) {
        this.calendario = calendario;
    }

}
