/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.web;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Home
 */
@Named(value = "ejemplo3")
@RequestScoped
public class Ejemplo3 {

    /**
     * Creates a new instance of Ejemplo3
     */
    private String opcion="nuevo";
    
    public Ejemplo3() 
    {
        this.opcion="todo esta bien";
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
    
    
}
