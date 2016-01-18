/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.web.usuario;

import ec.edu.espe.distribuidas.subjorel.modelo.Puja;
import ec.edu.espe.distribuidas.subjorel.modelo.Subasta;
import ec.edu.espe.distribuidas.subjorel.modelo.SuscripcionSubasta;
import ec.edu.espe.distribuidas.subjorel.modelo.Usuario;
import ec.edu.espe.distribuidas.subjorel.servicio.PujaServicio;
import ec.edu.espe.distribuidas.subjorel.servicio.SubastaServicio;
import ec.edu.espe.distribuidas.subjorel.servicio.UsuarioServicio;
import ec.edu.espe.distribuidas.web.Login;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author carlo
 */
@RequestScoped
@ManagedBean
public class PujaMB implements Serializable
{
    private List<SuscripcionSubasta> subastas;
    
    //obtiene la lista de los que hicieron pujas
    private List<Puja> pujasSubastas;
            
    private SuscripcionSubasta suscripcionSubasta;
    
    private Integer codigoSuscripcionSubasta;
    
    @EJB
    private UsuarioServicio usuarioServicio;
    
    @EJB
    private SubastaServicio subastaServicio;
    
    @EJB
    private PujaServicio pujaServicio;
    
    @ManagedProperty(value = "#{login}")
    private Login login;
    
    @PostConstruct
    public void postConstruct()
    {
       
        subastas=subastaServicio.pujasSuscritas();
        pujasSubastas=new ArrayList<Puja>();
        //pujasSubastas=pujaServicio.listaPujas(suscripcionSubasta.getSubasta());
        //System.out.println(codigoSuscripcionSubasta);
        //suscripcionSubasta=subastaServicio.suscripcionObtenerPorId(codigoSuscripcionSubasta);

    }
    
    
    public void metodo()
    {
    }
        
        
    
    public void puja()
    {
        Usuario usuario=login.getUsuarioLogueado();  
        //suscripcionSubasta.setUsuario(usuario);
        pujaServicio.nuevaPuja(suscripcionSubasta,usuario);
        //return "puja";
        
    }

    public List<SuscripcionSubasta> getSubastas() {
        return subastas;
    }

    public void setSubastas(List<SuscripcionSubasta> subastas) {
        this.subastas = subastas;
    }


    public SubastaServicio getSubastaServicio() {
        return subastaServicio;
    }

    public void setSubastaServicio(SubastaServicio subastaServicio) {
        this.subastaServicio = subastaServicio;
    }
    
    public void activar(String msg)
    {
        System.out.println(msg);
    }

    public SuscripcionSubasta getSuscripcionSubasta() {
        return suscripcionSubasta;
    }

    public void setSuscripcionSubasta(SuscripcionSubasta suscripcionSubasta) {
        this.suscripcionSubasta = suscripcionSubasta;
    }

    public Integer getCodigoSuscripcionSubasta() {
        return codigoSuscripcionSubasta;
    }

    public void setCodigoSuscripcionSubasta(Integer codigoSuscripcionSubasta) {
        this.codigoSuscripcionSubasta = codigoSuscripcionSubasta;
        suscripcionSubasta=subastaServicio.suscripcionObtenerPorId(codigoSuscripcionSubasta);
        pujasSubastas=pujaServicio.listaPujas(suscripcionSubasta.getSubasta());
        
        
    }

    public List<Puja> getPujasSubastas() 
    {
        return pujasSubastas;
    }

    public void setPujasSubastas(List<Puja> pujasSubastas) 
    {
        this.pujasSubastas = pujasSubastas;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    
    
    
    
    
}
