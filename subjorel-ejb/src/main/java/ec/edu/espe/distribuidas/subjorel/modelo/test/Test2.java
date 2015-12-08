/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.modelo.test;

import ec.edu.espe.distribuidas.subjorel.modelo.Ejemplo;
import ec.edu.espe.distribuidas.subjorel.servicio.EjemploServicio;
import java.util.Properties;
import javax.naming.Context;
import javax.rmi.PortableRemoteObject;

/**
 *
 * @author Carlos
 */
public class Test2 {

    public static void main(String[] args) {
        try {
            Ejemplo e = new Ejemplo();
            e.setCodigo(2);
            e.setNombre("carlos");
            
            Context jndiContext = getInitialContext();
            Object ref = jndiContext.lookup("EjemploServicio");
            EjemploServicio servicio = (EjemploServicio) PortableRemoteObject.narrow(ref, EjemploServicio.class);
            //PortableRemoteObjet.narrow(servicio.grabar(e), Ejemplo.class);
            System.out.println("Voy a llamar al bean");
            //System.out.println(sal.saluda());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Context getInitialContext() throws javax.naming.NamingException 
    {
        Properties p = new Properties();
        p.put(Context.INITIAL_CONTEXT_FACTORY,
                "weblogic.jndi.WLInitialContextFactory");
        p.put(Context.PROVIDER_URL, "t3://localhost:7001");
        return new javax.naming.InitialContext(p);
    }
}
