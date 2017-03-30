/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import br.edu.ifpb.praticas.ejb.teste.exemplo.services.Calculadora;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Pedro Arthur
 */
public class CalculadoraTeste {
    
    private static EJBContainer container;
    private static Context context;
    private static final String RESOURCE = "java:global/classes/CalculadoraBean!br.edu.ifpb.praticas.ejb.teste.exemplo.services.Calculadora";
    
    @BeforeClass
    public static void setUpClass() {
        container = EJBContainer.createEJBContainer();
        context = container.getContext();
    }
    
    @Test
    public void addTest() throws NamingException {
        Calculadora calculadora = (Calculadora) context.lookup(RESOURCE);

        assertEquals(10, calculadora.sum(5, 5));
        assertEquals(15, calculadora.sum(10, 5));
        assertEquals(32, calculadora.sum(2, 30));
        assertEquals(25, calculadora.sum(30, -5));
        assertEquals(14, calculadora.sum(-5, 19));
    }
    
    @Test
    public void testeSubtracao() throws NamingException {
        Calculadora calculadora = (Calculadora) context.lookup(RESOURCE);

        assertEquals(0, calculadora.subtract(5, 5));
        assertEquals(5, calculadora.subtract(10, 5));
        assertEquals(-5, calculadora.subtract(5, 10));
        assertEquals(-28, calculadora.subtract(2, 30));
        assertEquals(3, calculadora.subtract(30, 27));
    }
}
