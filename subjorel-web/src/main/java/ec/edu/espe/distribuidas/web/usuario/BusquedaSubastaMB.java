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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author carlo
 */
@ManagedBean
@ViewScoped
public class BusquedaSubastaMB implements Serializable
{
    @EJB
    private UsuarioServicio usuarioServicio;
    
    @EJB
    private CategoriaJoyaServicio categoriaServicio;
    
    @EJB
    private SubastaServicio subastaServicio;
    private Integer codigoCategoriaJoya;
    
    private List<CategoriaJoya> lista;
    private List<Subasta> listaSubastas;
    private Subasta subastaSeleccionada;
    
    @PostConstruct
    public void postConstruct()
    {
        lista=categoriaServicio.obtenerTodas();
        listaSubastas=new ArrayList<Subasta>();
    }
    
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

    public Integer getCodigoCategoriaJoya() {
        return codigoCategoriaJoya;
    }

    public void setCodigoCategoriaJoya(Integer codigoCategoriaJoya) {
        this.codigoCategoriaJoya = codigoCategoriaJoya;
    }

    public List<CategoriaJoya> getLista() {
        return lista;
    }

    public void setLista(List<CategoriaJoya> lista) {
        this.lista = lista;
    }

    public List<Subasta> getListaSubastas() {
        return listaSubastas;
    }

    public void setListaSubastas(List<Subasta> listaSubastas) {
        this.listaSubastas = listaSubastas;
    }

    public Subasta getSubastaSeleccionada() {
        return subastaSeleccionada;
    }

    public void setSubastaSeleccionada(Subasta subastaSeleccionada) {
        this.subastaSeleccionada = subastaSeleccionada;
    }
    
    public void suscribirse()
    {
        Usuario usuario=usuarioServicio.obtenerPorId("carlos");
        System.out.println(usuario);
        System.out.println(subastaSeleccionada.getCodigo());
        subastaServicio.suscribirseSubasta(subastaSeleccionada,usuario);
    }
    
}
