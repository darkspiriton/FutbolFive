/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol.five.com.metodo;

import junit.framework.TestCase;

/**
 *
 * @author Cesar
 */
public class EncriptarTest extends TestCase {
    
    public EncriptarTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test of encriptaEnMD5 method, of class Encriptar.
     */
    public void testEncriptaEnMD5() {
        System.out.println("encriptaEnMD5");
        String stringAEncriptar = "123456";
        String expResult = "e10adc3949ba59abbe56e057f20f883e";
        String result = Encriptar.encriptaEnMD5(stringAEncriptar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
