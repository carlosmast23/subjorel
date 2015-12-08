/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Cristhy Alejandra
 */

@Entity
@Table(name = "SUSCRIPCION_SUBASTA_05")
public class SuscripcionSubasta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "suscripcion_id", nullable = false)    
    private Integer codigo;
    
    @Column(name = "nick", nullable = false)    
    private String nick;
    
    @Column(name = "subasta_id", nullable = false)
    private Integer codigo_sub;

    @JoinColumn(name = "nick", referencedColumnName = "nick", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    
    @JoinColumn(name = "subasta_id", referencedColumnName = "subasta_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subasta subasta;
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getCodigo_sub() {
        return codigo_sub;
    }

    public void setCodigo_sub(Integer codigo_sub) {
        this.codigo_sub = codigo_sub;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.codigo);
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
        final SuscripcionSubasta other = (SuscripcionSubasta) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

        
    @Override
    public String toString() {
        return "SUSCRIPCION_SUBASTA_05{" + "codigo=" + codigo + ", nick=" + nick + ", codigo_sub=" + codigo_sub + '}';
    }

    
}
