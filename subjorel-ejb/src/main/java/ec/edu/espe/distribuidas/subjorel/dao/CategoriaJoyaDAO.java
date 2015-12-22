/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.dao;

import ec.edu.espe.distribuidas.subjorel.common.dao.DefaultGenericDAOImple;
import ec.edu.espe.distribuidas.subjorel.modelo.CategoriaJoya;
import ec.edu.espe.distribuidas.subjorel.modelo.Usuario;
import javax.ejb.Stateless;

/**
 *
 * @author Cristhy Alejandra
 */
@Stateless
public class CategoriaJoyaDAO extends DefaultGenericDAOImple<CategoriaJoya,Integer>{
    public CategoriaJoyaDAO()
    {
        super(CategoriaJoya.class);
    }
}
