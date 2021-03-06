/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.web;

import ec.edu.espe.distribuidas.subjorel.modelo.Usuario;
import ec.edu.espe.distribuidas.subjorel.servicio.UsuarioServicio;
import java.io.Serializable;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Carlos
 */
@ManagedBean(name = "login")
//@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@SessionScoped
public class Login implements Serializable
{
    private String nick;
    private String clave;
    
    private Usuario usuarioLogueado;
    
    @EJB
    private UsuarioServicio servicio;

    public String login()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        if(servicio.login(nick, clave))
        { 
            usuarioLogueado=servicio.obtenerPorId(nick);
            context.addMessage(null, new FacesMessage("Bienvenido al Sistema Subjorel","!Buen dia!"));
            return "indexusuario";
        }
        context.addMessage(null, new FacesMessage("El usuario o clave son incorrectos","!Vuelva a intentar!"));
        return "login";
    }
    
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public UsuarioServicio getServicio() {
        return servicio;
    }

    public void setServicio(UsuarioServicio servicio) {
        this.servicio = servicio;
    }
    
    
}
