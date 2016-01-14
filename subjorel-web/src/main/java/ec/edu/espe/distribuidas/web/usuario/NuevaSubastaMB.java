/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.web.usuario;

import ec.edu.espe.distribuidas.subjorel.modelo.CategoriaJoya;
import ec.edu.espe.distribuidas.subjorel.modelo.Joya;
import ec.edu.espe.distribuidas.subjorel.modelo.Subasta;
import ec.edu.espe.distribuidas.subjorel.modelo.Usuario;
import ec.edu.espe.distribuidas.subjorel.servicio.CategoriaJoyaServicio;
import ec.edu.espe.distribuidas.subjorel.servicio.JoyaServicio;
import ec.edu.espe.distribuidas.subjorel.servicio.SubastaServicio;
import ec.edu.espe.distribuidas.subjorel.servicio.UsuarioServicio;
import java.io.Serializable;
import java.util.Date;
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
public class NuevaSubastaMB implements Serializable{
    
    @EJB
    private UsuarioServicio usuarioServicio;
    
    @EJB
    private JoyaServicio joyaServicio;
    
    @EJB
    private CategoriaJoyaServicio categoriaServicio;
    
    @EJB
    private SubastaServicio subastaServicio;
    
    private Joya joya;
    private Subasta subasta;
    
    private List<CategoriaJoya> lista;
    private CategoriaJoya categoriaSeleccionada;
    private Integer codigoCategoriaJoya;
    
    private Date fechaInicio;
    private Date fechaFin;
    
    
    @PostConstruct
    public void postCostructor()
    {
        lista=categoriaServicio.obtenerTodas();
        System.err.println("tam: "+lista.size());
        joya=new Joya();
        subasta=new Subasta();
                
    }
    
    public void grabar()
    {   
        CategoriaJoya categoria=categoriaServicio.obtenerPorId(codigoCategoriaJoya);
        Usuario usuario=usuarioServicio.obtenerPorId("carlos");
        joya.setCategoria(categoria);        
        subasta.setVendedor(usuario);
        subasta.setIncrementoActual(subasta.getIncremento());
        subasta.setMonto(subasta.getPrecio());
        System.out.println(joya);
        subastaServicio.nuevaSubasta(subasta, joya);
    }

    public List<CategoriaJoya> getLista() {
        return lista;
    }

    public void setLista(List<CategoriaJoya> lista) {
        this.lista = lista;
    }

    public CategoriaJoya getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }

    public void setCategoriaSeleccionada(CategoriaJoya categoriaSeleccionada) {
        this.categoriaSeleccionada = categoriaSeleccionada;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Joya getJoya() {
        return joya;
    }

    public void setJoya(Joya joya) {
        this.joya = joya;
    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }

    public Integer getCodigoJoya() {
        return codigoCategoriaJoya;
    }

    public void setCodigoJoya(Integer codigoCategoriaJoya) {
        this.codigoCategoriaJoya = codigoCategoriaJoya;
    }

    
    
    
}
