/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.modelo;

import java.io.Serializable;
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
@Table(name = "DATOS_PERSONALES_05")
public class DatosPersonales implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "datos_personales_id", nullable = false)    
    private String codigo;
    
    @Column(name = "nick", nullable = false)
    private String nick;
    
    @Column(name = "nombre", nullable = false)    
    private String nombre;
    
    @Column(name = "apellido", nullable = false)    
    private String apellido;
    
    @Column(name = "sexo", nullable = false)
    private String sexo;
    
    @Column(name = "direccion", nullable = false)    
    private String direccion;
    
    @Column(name = "telefono", nullable = false)
    private String telefono;
    
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_nacimiento;
    
    @Column(name = "email", nullable = false)
    private String email;

    
    @JoinColumn(name = "nick", referencedColumnName = "nick", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.codigo);
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
        final DatosPersonales other = (DatosPersonales) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DATOS_PERSONALES_05{" + "codigo=" + codigo + ", nick=" + nick + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", direccion=" + direccion + ", telefono=" + telefono + ", fecha_nacimiento=" + fecha_nacimiento + ", email=" + email + '}';
    }
    
    
    
}
