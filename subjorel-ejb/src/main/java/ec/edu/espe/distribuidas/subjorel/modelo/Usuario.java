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
@Table(name = "USUARIO_05")
public class Usuario implements Serializable{
    
    @Id    
    @Column(name = "nick", nullable = false)    
    private String nick;
    
    @Column(name = "clave", nullable = false)
    private String clave;
    
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_creacion;
    
    @Column(name = "fecha_ultima_visita", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ultima_visita;
    
    @Column(name = "numero_visitas", nullable = false)    
    private Integer numero_visitas;
    
    @Column(name = "credito", nullable = false)
    private BigDecimal credito;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getUltima_visita() {
        return ultima_visita;
    }

    public void setUltima_visita(Date ultima_visita) {
        this.ultima_visita = ultima_visita;
    }

    public Integer getNumero_visitas() {
        return numero_visitas;
    }

    public void setNumero_visitas(Integer numero_visitas) {
        this.numero_visitas = numero_visitas;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.nick);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nick, other.nick)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "USUARIO_05{" + "nick=" + nick + ", clave=" + clave + ", fecha_creacion=" + fecha_creacion + ", ultima_visita=" + ultima_visita + ", numero_visitas=" + numero_visitas + ", credito=" + credito + '}';
    }

    
       
}
