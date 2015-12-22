/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.servicio;
import ec.edu.espe.distribuidas.subjorel.dao.JoyaDAO;
import ec.edu.espe.distribuidas.subjorel.exception.ValidacionException;
import ec.edu.espe.distribuidas.subjorel.modelo.Joya;
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
public class JoyaServicio {
     @EJB
    private JoyaDAO joyaDAO;
     
     public List<Joya>obtenerTodas(){
        return this.joyaDAO.findAll();
    }
    
    public Joya obtenerPorId(Integer codigoJoya){
        return this.joyaDAO.findById(codigoJoya,false);
        
    }
    
    public void crearJoya(Joya joya) throws ValidacionException{
        
        Joya sedetmp = this.obtenerPorId(joya.getCodigo());
        
        if (sedetmp==null)
        {
            this.joyaDAO.insert(joya);
        }
        else
        {
            throw new ValidacionException("El codigo de esta joya "+joya.getCodigo()+"ya existe");
        }
    
    }
    
    public void eliminarJoya(Integer codigoJoya)
    {
        try 
        {
         Joya sedetmp = this.obtenerPorId(codigoJoya);
         this.joyaDAO.remove(sedetmp);
        }
        
        catch (Exception e)
        {
        throw new ValidacionException("No se puede eliminar la joya seleccionada");
        }
    }

    public void obtenerPorId(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
