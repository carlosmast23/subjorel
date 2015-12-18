/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.test.dao;

import javax.ejb.embeddable.EJBContainer;
import javax.enterprise.context.spi.Context;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class NewEmptyJUnitTest {
    private static EJBContainer ejbContainer;
    private static Context ctx;
    //@EJB
    //EjemploServicio servicio;
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
        ejbContainer=EJBContainer.createEJBContainer();
        //ctx=ejbContainer.getContext();ejbContainer = EJBContainer.createEJBContainer();
        System.out.println("Starting the container");
        ctx = (Context) ejbContainer.getContext();


    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
      //   servicio.obtenerTodos();
     }
}
