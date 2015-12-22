/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.web;

import ec.edu.espe.distribuidas.subjorel.modelo.CategoriaJoya;
import ec.edu.espe.distribuidas.subjorel.modelo.Joya;
import ec.edu.espe.distribuidas.subjorel.servicio.CategoriaJoyaServicio;
import ec.edu.espe.distribuidas.subjorel.servicio.JoyaServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Carlos
 */
@ManagedBean
@ViewScoped
public class JoyaMB extends ControlarCrudMB implements Serializable
{
    private Integer id;
    private Joya entidad;
    private Joya entidadSelecionada;
    private List<CategoriaJoya> listaCategoria;
    private CategoriaJoya categoriaJoya;
    
   // private List<SelectItem> selectItem;
    
    @EJB
    private JoyaServicio servicio;
    
    @EJB
    private CategoriaJoyaServicio servicioCategoria;
    
    private List<Joya> lista;
    
    private String opcion;

    @ PostConstruct
    public void postCostructor()
    {
        lista=servicio.obtenerTodas();
        System.err.println(lista.size());
        entidad=new Joya();
        opcion="ninguno";
        listaCategoria=servicioCategoria.obtenerTodas();
        System.out.println("tam "+listaCategoria.size());
        
    }
    
    public void eliminar()
    {
        System.err.println("--->"+entidadSelecionada.getCodigo());
        servicio.eliminarJoya(entidadSelecionada.getCodigo());
        lista=servicio.obtenerTodas();
        enviarMensaje("la entidad se elimino correctamente");
    }
    
    public void grabar()
    {
        System.out.println("-> "+categoriaJoya);
        //entidad=new Ejemplo();
        if(opcion=="grabar")
        {
            servicio.crearJoya(entidad);
            enviarMensaje("La entidad  se graba correctamente");
        }
        
        if(opcion=="editar")
        {
            //servicio.(entidad);
            enviarMensaje("La entidad se edito correctamente");
        }
        
        lista=servicio.obtenerTodas();
        super.cancelar();
        //servicio.grabar(entidad);
        //return "index";
    }

    @Override
    public void nuevo() 
    {
        entidad=new Joya();
        super.nuevo(); //To change body of generated methods, choose Tools | Templates.
        opcion="grabar";
    }
    
    
    
    @Override
    public void editar()
    {
        entidad=entidadSelecionada;
        //servicio.editar(entidad);
        super.editar();
        opcion="editar";
       // return "index";
    }


    public List<Joya> getLista() {
        return lista;
    }

    public void setLista(List<Joya> lista) {
        this.lista = lista;
    }
    
    public String login()
    {
        return "acceso";
    }

    public Joya getEntidad() {
        return entidad;
    }

    public void setEntidad(Joya entidad) {
        this.entidad = entidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Joya getEntidadSelecionada() {
        return entidadSelecionada;
    }

    public void setEntidadSelecionada(Joya entidadSelecionada) {
        this.entidadSelecionada = entidadSelecionada;
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Entidad seleccionada", ((CategoriaJoya) event.getObject()).getCodigo().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Entidad deselccionada", ((CategoriaJoya) event.getObject()).getCodigo().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void enviarMensaje(String mensaje)
    {
        FacesContext context = FacesContext.getCurrentInstance();         
        context.addMessage(null, new FacesMessage("Successful", mensaje) );
    }

    public List<CategoriaJoya> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<CategoriaJoya> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public CategoriaJoya getCategoriaJoya() {
        return categoriaJoya;
    }

    public void setCategoriaJoya(CategoriaJoya categoriaJoya) {
        this.categoriaJoya = categoriaJoya;
    }
    
    
}
