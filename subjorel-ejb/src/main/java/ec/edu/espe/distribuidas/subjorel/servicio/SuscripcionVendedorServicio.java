/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.servicio;

import ec.edu.espe.distribuidas.subjorel.dao.SuscripcionVendedorDAO;
import ec.edu.espe.distribuidas.subjorel.modelo.SuscripcionVendedor;
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
public class SuscripcionVendedorServicio {
    
    @EJB
    private SuscripcionVendedorDAO suscripcionVendedorDAO;
     
     public List<SuscripcionVendedor>obtenerTodas(){
        return this.suscripcionVendedorDAO.findAll();
    }
    
    public SuscripcionVendedor obtenerPorId(Integer codigoSuscripcionVendedor){
        return this.suscripcionVendedorDAO.findById(codigoSuscripcionVendedor,false);
        
    }
}
