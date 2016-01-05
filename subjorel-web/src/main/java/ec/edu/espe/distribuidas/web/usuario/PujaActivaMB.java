/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.web.usuario;

import ec.edu.espe.distribuidas.subjorel.modelo.SuscripcionSubasta;
import ec.edu.espe.distribuidas.subjorel.servicio.SubastaServicio;
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
@ManagedBean
@RequestScoped
public class PujaActivaMB implements Serializable
{
    private List<SuscripcionSubasta> subastas;
    private SuscripcionSubasta subasta;
    private SuscripcionSubasta suscripcionSubasta;
        
    @EJB
    private SubastaServicio subastaServicio;
    
    @PostConstruct
    public void postConstruct()
    {
        subastas=subastaServicio.pujasSuscritas();
        //suscripcionSubasta=subastas.get(0);
        //suscripcionSubasta.getSubasta().getFecha_fin().getTime();
        ///System.out.println(subasta.);
    }

    public List<SuscripcionSubasta> getSubastas() {
        return subastas;
    }

    public void setSubastas(List<SuscripcionSubasta> subastas) {
        this.subastas = subastas;
    }

    public SuscripcionSubasta getSubasta() {
        return subasta;
    }

    public void setSubasta(SuscripcionSubasta subasta) {
        this.subasta = subasta;
    }
    
    
}
