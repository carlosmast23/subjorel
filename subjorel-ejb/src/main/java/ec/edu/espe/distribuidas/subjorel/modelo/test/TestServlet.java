/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.modelo.test;

import ec.edu.espe.distribuidas.subjorel.modelo.Ejemplo;
import ec.edu.espe.distribuidas.subjorel.servicio.EjemploServicio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos
 */
public class TestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    EjemploServicio miservicio;

    //@org.junit.Test
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Ejemplo a = new Ejemplo();
        a.setCodigo(2);
        a.setNombre("ana");
        Ejemplo b = new Ejemplo();
        b.setCodigo(3);
        b.setNombre("pedro");
        miservicio.grabar(a);
        PrintWriter pw = response.getWriter();
        pw.println("insertado");

    }
}
