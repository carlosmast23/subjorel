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
import javax.persistence.Table;

/**
 *
 * @author Cristhy Alejandra
 */
@Entity
@Table(name = "SUSCRIPCION_VENDEDOR_05")
public class SuscripcionVendedor implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "suscripcion_vendedor_id", nullable = false)    
    private String codigo_sus;
    
    @Column(name = "nick", nullable = false)
    private String nick;
    
    @Column(name = "privacidad", nullable = false)
    private String privacidad;

    public String getCodigo_sus() {
        return codigo_sus;
    }

    public void setCodigo_sus(String codigo_sus) {
        this.codigo_sus = codigo_sus;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(String privacidad) {
        this.privacidad = privacidad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.codigo_sus);
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
        final SuscripcionVendedor other = (SuscripcionVendedor) obj;
        if (!Objects.equals(this.codigo_sus, other.codigo_sus)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SUSCRIPCION_VENDEDOR_05{" + "codigo_sus=" + codigo_sus + ", nick=" + nick + ", privacidad=" + privacidad + '}';
    }

    
}
