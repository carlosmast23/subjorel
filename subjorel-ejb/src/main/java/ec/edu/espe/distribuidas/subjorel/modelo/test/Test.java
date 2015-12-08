/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.modelo.test;

import ec.edu.espe.distribuidas.subjorel.modelo.Ejemplo;
import ec.edu.espe.distribuidas.subjorel.servicio.EjemploServicio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Carlos
 */
public class Test 
{
    public static void main(String [] args)
    {
        
        Ejemplo ejemplo = new Ejemplo();
        ejemplo.setCodigo(2);
        ejemplo.setNombre("carlos");
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("ec.edu.espe.distribuidas_subjorel-ejb_ejb_1PU");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ec.edu.espe.distribuidas_subjorel-ejb_ejb_1PU");
//
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.persist(ejemplo);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        } finally {
//            em.close();
//
//        }
    }
}
