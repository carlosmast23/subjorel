/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.web;

import ec.edu.espe.distribuidas.subjorel.modelo.Joya;
import ec.edu.espe.distribuidas.subjorel.servicio.JoyaServicio;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Carlos
 */
public class JoyaConvert implements Converter {

    @EJB
    private JoyaServicio servicio;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) 
    {
        return servicio.obtenerPorId(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) 
    {
        return ((Joya)value).getCodigo()+"";
    }
    
}
