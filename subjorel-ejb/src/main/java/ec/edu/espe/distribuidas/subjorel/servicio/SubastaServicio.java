/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.servicio;
import ec.edu.espe.distribuidas.subjorel.dao.JoyaDAO;
import ec.edu.espe.distribuidas.subjorel.dao.SubastaDAO;
import ec.edu.espe.distribuidas.subjorel.dao.SuscripcionSubastaDAO;
import ec.edu.espe.distribuidas.subjorel.exception.ValidacionException;
import ec.edu.espe.distribuidas.subjorel.modelo.Joya;
import ec.edu.espe.distribuidas.subjorel.modelo.Subasta;
import ec.edu.espe.distribuidas.subjorel.modelo.SuscripcionSubasta;
import ec.edu.espe.distribuidas.subjorel.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Cristhy Alejandra
 */
@Stateless
@LocalBean 
public class SubastaServicio {
    
    @EJB
    private SuscripcionSubastaDAO suscripcionSubastaDAO;
    
    @EJB
    private SubastaDAO subastaDAO;
    
    @EJB
    private JoyaDAO joyaDAO;
    
    @EJB
    private SuscripcionSubastaDAO suscripcionSubasta;
            
     
    public List<Subasta>obtenerTodas(){
        return this.subastaDAO.findAll();
    }
     
    public List<Subasta>obtenerPorUsuario(Usuario usuario)
    {
        List<Subasta> lista= this.subastaDAO.findAll();
        List<Subasta> resultado=new ArrayList<Subasta>();
        for (Subasta subasta : lista) 
        {
            if(subasta.getVendedor().equals(usuario))
            {
                resultado.add(subasta);
            }
        }
        return resultado;
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
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void nuevaSubasta(Subasta subasta,Joya joya)
    {
        joyaDAO.insert(joya);
        subasta.setJoya(joya);
        subastaDAO.insert(subasta);
      //  subastaDAO.insert(subasta);
        
    }
    
    /**
     * Servicio para suscribirse a una subasta
     */
    public void suscribirseSubasta(Subasta subasta,Usuario usuario)
    {
        SuscripcionSubasta suscripcion=new SuscripcionSubasta();
        suscripcion.setSubasta(subasta);
        suscripcion.setUsuario(usuario);        
        suscripcionSubasta.insert(suscripcion);
        
    }
    
    
    public List<SuscripcionSubasta> pujasSuscritas()
    {
        return suscripcionSubastaDAO.findAll();
    }
    
    public SuscripcionSubasta suscripcionObtenerPorId(Integer codigoSubasta)
    {
        return this.suscripcionSubastaDAO.findById(codigoSubasta,false);
        
    }
}
