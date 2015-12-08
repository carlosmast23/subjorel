/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Cristhy Alejandra
 */

@Entity
@Table(name = "PUJA_05")
public class Puja implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "puja_id", nullable = false)    
    private Integer codigo;
    
    @Column(name = "movimiento_id", nullable = false)    
    private Integer codigo_mov; 
    
    @Column(name = "suscripcion_id", nullable = false)    
    private Integer codigo_sus;    
    
    @Column(name = "monto", nullable = false)
    private BigDecimal monto;
    
    @Column(name = "fecha", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    @Column(name = "orden_puja", nullable = false)    
    private Integer orden_puja;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo_mov() {
        return codigo_mov;
    }

    public void setCodigo_mov(Integer codigo_mov) {
        this.codigo_mov = codigo_mov;
    }

    public Integer getCodigo_sus() {
        return codigo_sus;
    }

    public void setCodigo_sus(Integer codigo_sus) {
        this.codigo_sus = codigo_sus;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getOrden_puja() {
        return orden_puja;
    }

    public void setOrden_puja(Integer orden_puja) {
        this.orden_puja = orden_puja;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Puja other = (Puja) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PUJA_05{" + "codigo=" + codigo + ", codigo_mov=" + codigo_mov + ", codigo_sus=" + codigo_sus + ", monto=" + monto + ", fecha=" + fecha + ", orden_puja=" + orden_puja + '}';
    }

    
}
