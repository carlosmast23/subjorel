/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.web.usuario;

import ec.edu.espe.distribuidas.subjorel.modelo.Subasta;
import ec.edu.espe.distribuidas.subjorel.modelo.SuscripcionSubasta;
import ec.edu.espe.distribuidas.subjorel.modelo.Usuario;
import ec.edu.espe.distribuidas.subjorel.servicio.PujaServicio;
import ec.edu.espe.distribuidas.subjorel.servicio.SubastaServicio;
import ec.edu.espe.distribuidas.subjorel.servicio.UsuarioServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
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
    private SuscripcionSubasta suscripcionSubasta;
    
    private Integer codigoSuscripcionSubasta;
    
    @EJB
    private UsuarioServicio usuarioServicio;
    
    @EJB
    private SubastaServicio subastaServicio;
    
    @EJB
    private PujaServicio pujaServicio;
    
    @PostConstruct
    public void postConstruct()
    {
        subastas=subastaServicio.pujasSuscritas();
        //System.out.println(codigoSuscripcionSubasta);
        //suscripcionSubasta=subastaServicio.suscripcionObtenerPorId(codigoSuscripcionSubasta);

    }
    
    
    public void metodo()
    {
    }
        
        
    
    public void puja()
    {
        Usuario usuario=usuarioServicio.obtenerPorId("carlos");        
        pujaServicio.nuevaPuja(100, suscripcionSubasta,usuario);
        
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
    }

    
    
    
    
    
}
