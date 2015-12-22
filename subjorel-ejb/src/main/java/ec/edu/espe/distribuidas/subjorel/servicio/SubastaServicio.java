/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.servicio;
import ec.edu.espe.distribuidas.subjorel.dao.SubastaDAO;
import ec.edu.espe.distribuidas.subjorel.exception.ValidacionException;
import ec.edu.espe.distribuidas.subjorel.modelo.Subasta;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Cristhy Alejandra
 */
public class SubastaServicio {
    
    @EJB
    private SubastaDAO subastaDAO;
     
     public List<Subasta>obtenerTodas(){
        return this.subastaDAO.findAll();
    }
    
    public Subasta obtenerPorId(Integer codigoSubasta){
        return this.subastaDAO.findById(codigoSubasta,false);
        
    }
    
    public void crearSubasta(Subasta subasta) throws ValidacionException{
        
        Subasta sedetmp = this.obtenerPorId(subasta.getCodigo());
        
        if (sedetmp==null)
        {
            this.subastaDAO.insert(subasta);
        }
        else
        {
            throw new ValidacionException("La subasta con el codigo "+subasta.getCodigo()+"ya existe");
        }
    
    }  
    
}
