/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.servicio;
import ec.edu.espe.distribuidas.subjorel.dao.MovimientoDAO;
import ec.edu.espe.distribuidas.subjorel.modelo.Movimiento;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Cristhy Alejandra
 */
public class MovimientoServicio {
    
    @EJB
    private MovimientoDAO movimientoDAO;
     
     public List<Movimiento>obtenerTodas(){
        return this.movimientoDAO.findAll();
    }
    
    public Movimiento obtenerPorId(Integer codigoMovimiento){
        return this.movimientoDAO.findById(codigoMovimiento,false);
        
    }
        
}
