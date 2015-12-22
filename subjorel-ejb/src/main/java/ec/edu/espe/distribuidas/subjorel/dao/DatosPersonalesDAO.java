/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.dao;

import ec.edu.espe.distribuidas.subjorel.common.dao.DefaultGenericDAOImple;
import ec.edu.espe.distribuidas.subjorel.modelo.DatosPersonales;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Cristhy Alejandra
 */

@LocalBean 
@Stateless 

public class DatosPersonalesDAO extends DefaultGenericDAOImple<DatosPersonales,String>{
    
    public DatosPersonalesDAO()
    {
        super(DatosPersonales.class);
    }
}
