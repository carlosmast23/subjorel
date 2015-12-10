/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.servicio;

import ec.edu.espe.distribuidas.subjorel.dao.CategoriaJoyaDAO;
import ec.edu.espe.distribuidas.subjorel.exception.ValidacionException;
import ec.edu.espe.distribuidas.subjorel.modelo.CategoriaJoya;
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

public class CategoriaJoyaServicio 
{
 @EJB
    private CategoriaJoyaDAO categoriaJoyaDAO;
     
     public List<CategoriaJoya>obtenerTodas(){
        return this.categoriaJoyaDAO.findAll();
    }
    
    public CategoriaJoya obtenerPorId(Integer codigoCategoria){
        return this.categoriaJoyaDAO.findById(codigoCategoria,false);
        
    }
    
    public void crearCategoria(CategoriaJoya categoriaJoya) throws ValidacionException{
        
        CategoriaJoya sedetmp = this.obtenerPorId(categoriaJoya.getCodigo());
        
        if (sedetmp==null)
        {
            this.categoriaJoyaDAO.insert(categoriaJoya);
        }
        else
        {
            throw new ValidacionException("La categoría de la joya "+categoriaJoya.getCodigo()+" ya existe");
        }
    
    }
    
    public void eliminarCategoria(Integer codigoCategoria)
    {
        try 
        {
         CategoriaJoya sedetmp = this.obtenerPorId(codigoCategoria);
         this.categoriaJoyaDAO.remove(sedetmp);
        }
        
        catch (Exception e)
        {
        throw new ValidacionException("No se puede eliminar la categoría");
        }
    }
    
}
