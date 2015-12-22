/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.servicio;
import ec.edu.espe.distribuidas.subjorel.dao.PujaDAO;
import ec.edu.espe.distribuidas.subjorel.exception.ValidacionException;
import ec.edu.espe.distribuidas.subjorel.modelo.Puja;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Cristhy Alejandra
 */
public class PujaServicio {
    
    @EJB
    private PujaDAO pujaDAO;
     
     public List<Puja>obtenerTodas(){
        return this.pujaDAO.findAll();
    }
    
    public Puja obtenerPorId(Integer codigoPuja){
        return this.pujaDAO.findById(codigoPuja,false);
        
    }
    
    public void crearPuja(Puja puja) throws ValidacionException{
        
        Puja sedetmp = this.obtenerPorId(puja.getCodigo());
        
        if (sedetmp==null)
        {
            this.pujaDAO.insert(puja);
        }
        else
        {
            throw new ValidacionException("El codigo de la puja "+puja.getCodigo()+"ya existe");
        }
    
    }
    
    
}
