/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.web.usuario;

import ec.edu.espe.distribuidas.subjorel.modelo.CategoriaJoya;
import ec.edu.espe.distribuidas.subjorel.modelo.Subasta;
import ec.edu.espe.distribuidas.subjorel.modelo.Usuario;
import ec.edu.espe.distribuidas.subjorel.servicio.CategoriaJoyaServicio;
import ec.edu.espe.distribuidas.subjorel.servicio.SubastaServicio;
import ec.edu.espe.distribuidas.subjorel.servicio.UsuarioServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author carlo
 */
@ManagedBean
@ViewScoped
public class BuscarSubastaMB implements Serializable {

    @EJB
    private UsuarioServicio usuarioServicio;
    
    @EJB
    private CategoriaJoyaServicio categoriaServicio;
    
    @EJB
    private SubastaServicio subastaServicio;

    private Integer codigoCategoriaJoya;
    
    private List<CategoriaJoya> lista;
    private List<Subasta> listaSubastas;
    
    private Subasta subasta;
    private Subasta subastaSeleccionada;
    
    @PostConstruct
    public void postConstruct()
    {
        lista=categoriaServicio.obtenerTodas();
        listaSubastas=new ArrayList<Subasta>();
    }

    public List<CategoriaJoya> getLista() {
        return lista;
    }
    
    /**
     * Funcion que carga las subastas filtrando por categoria
     */
    public void cargarSubastas()
    {
        listaSubastas.clear();
        List<Subasta> subastas=subastaServicio.obtenerTodas();
        CategoriaJoya categoriaSeleccionada=categoriaServicio.obtenerPorId(codigoCategoriaJoya);
        for (Subasta subasta : subastas) {
            if(subasta.getJoya().getCategoria().equals(categoriaSeleccionada))
            {
                listaSubastas.add(subasta);
            }
        }
               
    }
    
    public void suscribirse()
    {
        Usuario usuario=usuarioServicio.obtenerPorId("carlos");
        System.out.println(usuario);
        System.out.println(subasta);
        subastaServicio.suscribirseSubasta(subasta,usuario);
    }

    public void setLista(List<CategoriaJoya> lista) {
        this.lista = lista;
    }

    public Integer getCodigoCategoriaJoya() {
        return codigoCategoriaJoya;
    }

    public void setCodigoCategoriaJoya(Integer codigoCategoriaJoya) {
        this.codigoCategoriaJoya = codigoCategoriaJoya;
    }

    public List<Subasta> getListaSubastas() {
        return listaSubastas;
    }

    public void setListaSubastas(List<Subasta> listaSubastas) {
        this.listaSubastas = listaSubastas;
    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }
    
    public void cambiarCategoria() 
    {
        //if(codigoCategoriaJoya !=null && !codigoCategoriaJoya.equals(""))
            
    }

    public Subasta getSubastaSeleccionada() {
        return subastaSeleccionada;
    }

    public void setSubastaSeleccionada(Subasta subastaSeleccionada) {
        this.subastaSeleccionada = subastaSeleccionada;
    }
    
    public void onRowSelect(SelectEvent event) 
    {
        subastaSeleccionada=(Subasta) event.getObject();
        System.out.println(subastaSeleccionada);
        FacesMessage msg = new FacesMessage("Entidad seleccionada", ((Subasta) event.getObject()).getCodigo().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Entidad deselccionada", ((Subasta) event.getObject()).getCodigo().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
}
