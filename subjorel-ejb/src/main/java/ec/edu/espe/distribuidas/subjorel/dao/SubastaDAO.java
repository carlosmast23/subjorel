/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.dao;

import ec.edu.espe.distribuidas.subjorel.common.dao.DefaultGenericDAOImple;
import ec.edu.espe.distribuidas.subjorel.modelo.Subasta;
import ec.edu.espe.distribuidas.subjorel.modelo.Usuario;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Cristhy Alejandra
 */

@LocalBean 
@Stateless 
public class SubastaDAO extends DefaultGenericDAOImple<Subasta,Integer>{
    public SubastaDAO()
    {
        super(Subasta.class);
    }
}