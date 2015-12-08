/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.dao;

import ec.edu.espe.distribuidas.subjorel.modelo.Ejemplo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Stateless
public class EjemploFacade extends AbstractFacade<Ejemplo>
{
    @PersistenceContext(unitName = "subjorel_unit_name")
    private EntityManager em;

    public EjemploFacade() 
    {
        super(Ejemplo.class);
    }    
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
}
