/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.web;


import ec.edu.espe.distribuidas.subjorel.servicio.UsuarioServicio;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



/**
 *
 * @author Carlos
 */
@ManagedBean
@RequestScoped
public class Ingresar 
{
    
    private String clave;
    private String nick;
    private String contrasenia;
    
        
    @EJB
    private UsuarioServicio usuarioServicio;
    /**
     * Creates a new instance of Ingresar
     */
    
    @PostConstruct
    public void postConstruct()
    {
        nick="carlos";
        clave="1234";
        contrasenia="12345";
    }
    
    public String login() 
    {
        //if(clave.equals("123") && nick.equals("carlos"))
        //{
        //    return "login";
       // }
       // else
       // {
       //     return "indexadmin";
       // }
        System.out.println(nick);
        System.out.println(contrasenia);
        if(contrasenia=="12345")
           return "index";
        else
            return "login";
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }    

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    
    
}
