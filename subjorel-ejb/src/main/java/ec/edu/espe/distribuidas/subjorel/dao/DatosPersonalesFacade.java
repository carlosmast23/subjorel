/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.dao;

import ec.edu.espe.distribuidas.subjorel.modelo.DATOS_PERSONALES_05;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Stateless
public class DatosPersonalesFacade extends AbstractFacade<DATOS_PERSONALES_05>
{
    @PersistenceContext(unitName = "ec.edu.espe.distribuidas_subjorel-ejb_ejb_1PU")
    //@PersistenceContext
    private EntityManager em;
      
    public DatosPersonalesFacade() 
    {
        super(DATOS_PERSONALES_05.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return null;
    }  
}
