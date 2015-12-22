package ec.edu.espe.distribuidas.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos
 */
@ManagedBean
@ViewScoped
public class ControlarCrudMB 
{
    private Boolean datosVisibles;
    private Boolean btnNuevo;
    private Boolean btnEditar;
    private Boolean btnEliminar;
    
    /**
     * Variable para controlar el nombre del titulo del panel
     */
    private String nombrePanelDatos;

    @PostConstruct
    public void postConstructor()
    {
        datosVisibles=false;
        //botones activados
        btnEditar=false;
        btnEliminar=false;
        btnNuevo=false;
        nombrePanelDatos="";
        
    }
    
    /**
     * Desctiva los botones de nuevo, editar, eliminar
     */
    private void desactivarBotones()
    {
        btnEditar=true;
        btnEliminar=true;
        btnNuevo=true;
    }
    
    public void nuevo()
    {
        btnEditar=true;
        btnEliminar=true;
        btnNuevo=true;//this.desactivarBotones();
        datosVisibles=true;
        nombrePanelDatos="NUEVO";
    }
    
    public void editar()
    {
        btnEditar=true;
        btnEliminar=true;
        btnNuevo=true;//this.desactivarBotones();
        datosVisibles=true;
        nombrePanelDatos="EDITAR";
    }
    
    /**
     * Cancelar el proceso de crear, editar, o eliminar
     */
    public void cancelar()
    {
        btnEditar=false;
        btnEliminar=false;
        btnNuevo=false;//this.desactivarBotones();
        datosVisibles=false;
    }
    
    public Boolean getDatosVisibles() {
        return datosVisibles;
    }

    public void setDatosVisibles(Boolean datosVisibles) {
        this.datosVisibles = datosVisibles;
    }

    public Boolean getBtnNuevo() {
        return btnNuevo;
    }

    public void setBtnNuevo(Boolean btnNuevo) {
        this.btnNuevo = btnNuevo;
    }

    public Boolean getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(Boolean btnEditar) {
        this.btnEditar = btnEditar;
    }

    public Boolean getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(Boolean btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public String getNombrePanelDatos() {
        return nombrePanelDatos;
    }

    public void setNombrePanelDatos(String nombrePanelDatos) {
        this.nombrePanelDatos = nombrePanelDatos;
    }
    
    
}
