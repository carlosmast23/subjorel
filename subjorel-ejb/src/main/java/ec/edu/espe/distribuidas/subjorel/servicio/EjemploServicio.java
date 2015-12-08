/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.servicio;

import ec.edu.espe.distribuidas.subjorel.dao.EjemploFacade;
import ec.edu.espe.distribuidas.subjorel.modelo.Ejemplo;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos
 */
@Stateless
@Local
public class EjemploServicio 
{
    @EJB
    private EjemploFacade ejemploFacade;
    
    public void grabar(Ejemplo ejemplo)
    {
        ejemploFacade.create(ejemplo);
    }
}
