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
@Table(name = "JOYA_05")
public class JOYA_05 implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "joya_id", nullable = false)    
    private Integer codigo;
    
    @Column(name = "categoria_id", nullable = false)    
    private Integer codigo_cat;
    
    @Column(name = "nombre", nullable = false)    
    private String nombre;
    
    @Column(name = "imagen", nullable = false)
    private String imagen;
    
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo_cat() {
        return codigo_cat;
    }

    public void setCodigo_cat(Integer codigo_cat) {
        this.codigo_cat = codigo_cat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final JOYA_05 other = (JOYA_05) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JOYA_05{" + "codigo=" + codigo + ", codigo_cat=" + codigo_cat + ", nombre=" + nombre + ", imagen=" + imagen + ", descripcion=" + descripcion + '}';
    }

    
}
