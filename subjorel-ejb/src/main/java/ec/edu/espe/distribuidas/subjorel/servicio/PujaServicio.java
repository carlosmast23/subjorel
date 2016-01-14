/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.servicio;
import ec.edu.espe.distribuidas.subjorel.dao.MovimientoDAO;
import ec.edu.espe.distribuidas.subjorel.dao.PujaDAO;
import ec.edu.espe.distribuidas.subjorel.dao.SubastaDAO;
import ec.edu.espe.distribuidas.subjorel.dao.UsuarioDAO;
import ec.edu.espe.distribuidas.subjorel.exception.ValidacionException;
import ec.edu.espe.distribuidas.subjorel.modelo.Movimiento;
import ec.edu.espe.distribuidas.subjorel.modelo.Puja;
import ec.edu.espe.distribuidas.subjorel.modelo.Subasta;
import ec.edu.espe.distribuidas.subjorel.modelo.SuscripcionSubasta;
import ec.edu.espe.distribuidas.subjorel.modelo.Usuario;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Cristhy Alejandra
 */
@Stateless
@Local
public class PujaServicio {
    
    @EJB
    private PujaDAO pujaDAO;
    
    @EJB
    private MovimientoDAO movimientoDAO;
    
    @EJB
    private SubastaDAO subastaDAO;
    
    @EJB
    private UsuarioDAO usuarioDAO;
     
     public List<Puja>obtenerTodas(){
        return this.pujaDAO.findAll();
    }
    
    public Puja obtenerPorId(Integer codigoPuja){
        return this.pujaDAO.findById(codigoPuja,false);
        
    }
    
    public List<Puja> listaPujas(Subasta subasta)
    {
        List<Puja> listaPujas=this.pujaDAO.findAll();
        List<Puja> listaRespuesta=new ArrayList<Puja>();
        for (Puja puja : listaPujas) 
        {
            if(puja.getSubasta().getSubasta().equals(subasta))
            {
                listaRespuesta.add(puja);
            }
        }
        return listaRespuesta;
        //return listaPujas;
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
    
    /**
     * Metodo que crea una puja y genera una transaccion por la puja
     * @param monto
     * @param suscribcion
     * @param usuario 
     */
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void nuevaPuja(SuscripcionSubasta suscribcion)
    {
        Date date=new Date();
        DateFormat format = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        
        Subasta subasta= suscribcion.getSubasta();
        float valor=subasta.getMonto().floatValue()+subasta.getIncremento().floatValue();
        float valorSubasta=subasta.getIncremento().floatValue();
                
        subasta.setMonto(new BigDecimal(valor));
        //subasta.setIncrementoActual(new BigDecimal(subasta.getIncrementoActual().floatValue()+subasta.getIncremento().floatValue()));
        Usuario usuario=suscribcion.getUsuario();
        float saldoActualCuenta=usuario.getCredito().floatValue()-valorSubasta;
        usuario.setCredito(new BigDecimal(saldoActualCuenta));
        usuarioDAO.update(usuario);
        
        Movimiento movimiento=new Movimiento();
        movimiento.setUsuario(usuario);
        movimiento.setMonto(new BigDecimal(valorSubasta));
        movimiento.setSaldo(new BigDecimal(saldoActualCuenta));
        
        movimiento.setFecha_movimiento(date);
        movimientoDAO.insert(movimiento);
        
        Puja puja=new Puja();
        puja.setMovimiento(movimiento);
        puja.setSubasta(suscribcion);
        puja.setMonto(new BigDecimal(valorSubasta));
        puja.setFecha(new Date());
        puja.setOrden_puja(0);
        pujaDAO.insert(puja);
        
        subastaDAO.update(subasta);
        
    }
    
}
