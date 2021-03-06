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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Cristhy Alejandra
 */
@Entity
@Table(name = "SUBASTA_05")
public class Subasta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "subasta_id", nullable = false)    
    private Integer codigo;
    
    @Column(name = "precio_base", nullable = false)
    private BigDecimal precio;
    
    @Column(name = "monto_final", nullable = false)
    private BigDecimal monto;
    
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_ini;
    
    @Column(name = "fecha_fin", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_fin;
    
    @Column(name = "categoria", nullable = false)    
    private String categoria;
    
    @Column(name = "tiempo", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date tiempo;
    
    @Column(name = "incremento", nullable = false)
    private BigDecimal incremento;
    
    @Column(name = "incremento_actual", nullable = false)
    private BigDecimal incrementoActual;
    
    
    //@JoinColumn(name = "suscripcion_vendedor_id", referencedColumnName = "suscripcion_vendedor_id", insertable = false, updatable = false)
    //@ManyToOne(optional = false)
    @ManyToOne
    @JoinColumn(name="nick")
    private Usuario vendedor;
    
    //@JoinColumn(name = "joya_id", referencedColumnName = "joya_id", insertable = false, updatable = false)
    //@ManyToOne(optional = false)
    @ManyToOne
    @JoinColumn(name="joya_id")
    private Joya joya;
    
    //@JoinColumn(name = "movimiento_id", referencedColumnName = "movimiento_id", insertable = false, updatable = false)
    //@ManyToOne(optional = false)
    @ManyToOne
    @JoinColumn(name="movimiento_id")
    private Movimiento movimiento;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

   // public Integer getCodigo_sus() {
   //     return codigo_sus;
   // }

   // public void setCodigo_sus(Integer codigo_sus) {
   //     this.codigo_sus = codigo_sus;
   // }

   // public Integer getCodigo_joya() {
   //     return codigo_joya;
   // }

   // public void setCodigo_joya(Integer codigo_joya) {
   //     this.codigo_joya = codigo_joya;
   // }

    //public Integer getCodigo_mov() {
      //  return codigo_mov;
    //}

    //public void setCodigo_mov(Integer codigo_mov) {
      //  this.codigo_mov = codigo_mov;
    //}

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(Date fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }


    
    public Joya getJoya() {
        return joya;
    }

    public void setJoya(Joya joya) {
        this.joya = joya;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public BigDecimal getIncremento() {
        return incremento;
    }

    public void setIncremento(BigDecimal incremento) {
        this.incremento = incremento;
    }

    public BigDecimal getIncrementoActual() {
        return incrementoActual;
    }

    public void setIncrementoActual(BigDecimal incrementoActual) {
        this.incrementoActual = incrementoActual;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.codigo);
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
        final Subasta other = (Subasta) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SUBASTA_05{" + "codigo=" + codigo + ", codigo_sus=" + joya.getNombre() + ", codigo_joya= , codigo_mov=" + movimiento.getMonto() + ", precio=" + precio + ", monto=" + monto + ", fecha_ini=" + fecha_ini + ", fecha_fin=" + fecha_fin + ", categoria=" + categoria + ", tiempo=" + tiempo + '}';
    }

    
        
}
