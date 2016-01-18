/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.web.usuario;

import ec.edu.espe.distribuidas.subjorel.modelo.Subasta;
import ec.edu.espe.distribuidas.subjorel.modelo.Usuario;
import ec.edu.espe.distribuidas.subjorel.servicio.SubastaServicio;
import ec.edu.espe.distribuidas.web.Login;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author carlo
 */

@ManagedBean(name ="listaSubastaMB")
//@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@RequestScoped
public class ListaSubastaMB implements Serializable{
    private List<Subasta> subastas;
    private Subasta subasta;
    
    @EJB
    private SubastaServicio subastaServicio;
    
    @ManagedProperty(value = "#{login}")
    private Login login;
    
    @PostConstruct
    public void postConstruct()
    {
        //subastas=subastaServicio.obtenerTodas();
        subastas=subastaServicio.obtenerPorUsuario(login.getUsuarioLogueado());
    }

    public List<Subasta> getSubastas() {
        return subastas;
    }

    public void setSubastas(List<Subasta> subastas) {
        this.subastas = subastas;
    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    
    
}
