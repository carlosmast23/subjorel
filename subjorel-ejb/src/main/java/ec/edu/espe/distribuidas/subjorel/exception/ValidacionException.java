/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.subjorel.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author Cristhy Alejandra
 */
@ApplicationException(rollback = true,inherited = true)
public class ValidacionException extends RuntimeException
{
    public ValidacionException(String message)
    {
        super(message);
    }
}