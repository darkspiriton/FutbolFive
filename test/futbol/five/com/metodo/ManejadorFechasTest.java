/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.metodo;

import java.sql.Date;
import junit.framework.TestCase;

/**
 *
 * @author Samuel
 */
public class ManejadorFechasTest extends TestCase {
    
    public ManejadorFechasTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test of getFechaActual method, of class ManejadorFechas.
     */
    public void testGetFechaActual() {
        System.out.println("getFechaActual");
        ManejadorFechas instance = new ManejadorFechas();
        String expResult = "";
        String result = instance.getFechaActual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoraActual method, of class ManejadorFechas.
     */
    public void testGetHoraActual() {
        System.out.println("getHoraActual");
        ManejadorFechas instance = new ManejadorFechas();
        String expResult = "";
        String result = instance.getHoraActual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumarFechasDias method, of class ManejadorFechas.
     */
    public void testSumarFechasDias() {
        System.out.println("sumarFechasDias");
        Date fch = null;
        int dias = 0;
        ManejadorFechas instance = new ManejadorFechas();
        Date expResult = null;
        Date result = instance.sumarFechasDias(fch, dias);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restarFechasDias method, of class ManejadorFechas.
     */
    public void testRestarFechasDias() {
        System.out.println("restarFechasDias");
        Date fch = null;
        int dias = 0;
        ManejadorFechas instance = new ManejadorFechas();
        Date expResult = null;
        Date result = instance.restarFechasDias(fch, dias);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diferenciasDeFechas method, of class ManejadorFechas.
     */
    public void testDiferenciasDeFechas() {
        System.out.println("diferenciasDeFechas");
        java.util.Date fechaInicial = null;
        java.util.Date fechaFinal = null;
        ManejadorFechas instance = new ManejadorFechas();
        int expResult = 0;
        int result = instance.diferenciasDeFechas(fechaInicial, fechaFinal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deStringToDate method, of class ManejadorFechas.
     */
    public void testDeStringToDate() {
        System.out.println("deStringToDate");
        String fecha = "";
        ManejadorFechas instance = new ManejadorFechas();
        java.util.Date expResult = null;
        java.util.Date result = instance.deStringToDate(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of devolverDia method, of class ManejadorFechas.
     */
    public void testDevolverDia() {
        System.out.println("devolverDia");
        String fecha = "2014-11-10";
        ManejadorFechas instance = new ManejadorFechas();
        String expResult = "Martes";
        String result = instance.devolverDia(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getDia method, of class ManejadorFechas.
     */
    public void testGetDia() {
        System.out.println("getDia");
        int i = 0;
        ManejadorFechas instance = new ManejadorFechas();
        String expResult = "";
        String result = instance.getDia(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
