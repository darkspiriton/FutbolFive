/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol.five.com.singleton;

import junit.framework.TestCase;

/**
 *
 * @author Cesar
 */
public class RegistrarListaTest extends TestCase {
    
    public RegistrarListaTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

  

    /**
     * Test of verificarEspacioEstandar method, of class RegistrarLista.
     */
    public void testVerificarEspacioEstandar() {
        System.out.println("verificarEspacioEstandar");
        String cod = "1";
        RegistrarLista instance = RegistrarLista.getRegistrarLista();
        boolean expResult = true;
        boolean result = instance.verificarEspacioEstandar(cod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of verificarEspacioSolidaria method, of class RegistrarLista.
     */
    public void testVerificarEspacioSolidaria() {
        System.out.println("verificarEspacioSolidaria");
        String cod = "1";
        RegistrarLista instance = RegistrarLista.getRegistrarLista();
        boolean expResult = true;
        boolean result = instance.verificarEspacioSolidaria(cod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of insertarListaEstandar method, of class RegistrarLista.
     */
    public void testInsertarListaEstandar() {
        System.out.println("insertarListaEstandar");
        String cod = "1";
        String user = "pollin";
        RegistrarLista instance = RegistrarLista.getRegistrarLista();
        boolean expResult = false;
        boolean result = instance.insertarListaEstandar(cod, user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of insertarListaSolidaria method, of class RegistrarLista.
     */
    public void testInsertarListaSolidaria() {
        System.out.println("insertarListaSolidaria");
        String cod = "2";
        String user = "pollin";
        RegistrarLista instance = RegistrarLista.getRegistrarLista();
        boolean expResult = false;
        boolean result = instance.insertarListaSolidaria(cod, user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
