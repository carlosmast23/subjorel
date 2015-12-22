/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.servicio;

import ec.edu.espe.distribuidas.subjorel.dao.UsuarioDAO;
import ec.edu.espe.distribuidas.subjorel.exception.ValidacionException;
import ec.edu.espe.distribuidas.subjorel.modelo.Usuario;
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

public class UsuarioServicio {
    
     @EJB
    private UsuarioDAO usuarioDAO;
     
     public List<Usuario>obtenerTodas(){
        return this.usuarioDAO.findAll();
    }
    
    public Usuario obtenerPorId(String codigoSede){
        return this.usuarioDAO.findById(codigoSede,false);
        
    }
    
    public void crearUsuario(Usuario usuario) throws ValidacionException{
        
        Usuario sedetmp = this.obtenerPorId(usuario.getNick());
        
        if (sedetmp==null)
        {
            this.usuarioDAO.insert(usuario);
        }
        else
        {
            throw new ValidacionException("El nick"+usuario.getNick()+"ya existe");
        }
    
    }
    
    public void eliminarUsuario(String codigoUsuario)
    {
        try 
        {
         Usuario sedetmp = this.obtenerPorId(codigoUsuario);
         this.usuarioDAO.remove(sedetmp);
        }
        
        catch (Exception e)
        {
        throw new ValidacionException("No se puede eliminar el usuario");
        }
    }

    public boolean login(String nick, String clave) 
    {
        Usuario usuario=obtenerPorId(nick);
        if(usuario!=null)
        {
            if(usuario.getClave().equals(clave))
            {
                return true;
            }
        }
        return false;
    }


}
