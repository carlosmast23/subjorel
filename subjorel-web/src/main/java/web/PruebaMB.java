/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Home
 */
@Named(value = "pruebaMB")
@ManagedBean
@ViewScoped
public class PruebaMB implements Serializable{
    private String texto="hola 20";
    /**
     * Creates a new instance of PruebaMB
     */
    public PruebaMB() {
        texto="hola 30";
    }
    
    @PostConstruct
    public void iniciar()
    {
        texto="hola 23";
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    
}
