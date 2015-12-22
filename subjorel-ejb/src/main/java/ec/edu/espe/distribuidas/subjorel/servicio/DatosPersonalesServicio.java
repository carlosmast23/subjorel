/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.servicio;

import ec.edu.espe.distribuidas.subjorel.dao.DatosPersonalesDAO;
import ec.edu.espe.distribuidas.subjorel.exception.ValidacionException;
import ec.edu.espe.distribuidas.subjorel.modelo.DatosPersonales;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Cristhy Alejandra
 */

@LocalBean 
@Stateless  
public class DatosPersonalesServicio {
    
    // Nunca get y set
    @EJB
    private DatosPersonalesDAO datosPersonalesDAO;
    
    
    public List<DatosPersonales>obtenerTodos(){
        return this.datosPersonalesDAO.findAll();
    }
    
    public DatosPersonales obtenerPorId(String codigoDatosPersonales){
        return this.datosPersonalesDAO.findById(codigoDatosPersonales,false);
        
    }
    
    public void crearDatosPesonales(DatosPersonales datosPersonales) throws ValidacionException{
        
        DatosPersonales sedetmp = this.obtenerPorId(datosPersonales.getCodigo());
        
        if (sedetmp==null)
        {
            this.datosPersonalesDAO.insert(datosPersonales);
        }
        else
        {
            throw new ValidacionException("El codigo"+datosPersonales.getCodigo()+"ya existe");
        }
    
    }
        
}
