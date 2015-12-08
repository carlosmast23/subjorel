/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import ec.edu.espe.distribuidas.subjorel.modelo.Ejemplo;
import ec.edu.espe.distribuidas.subjorel.servicio.EjemploServicio;
import javax.ejb.EJB;
import junit.framework.TestCase;

/**
 *
 * @author Carlos
 */
public class TestEjemplo extends TestCase 
{
    @EJB
    EjemploServicio servicio;
    public TestEjemplo(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

     //TODO add test methods here. The name must begin with 'test'. For example:
    public void testHello() 
    {
        Ejemplo ejemplo=new Ejemplo();
        ejemplo.setCodigo(3);
        ejemplo.setNombre("carlos");
        
        servicio.grabar(ejemplo);
    }
}
