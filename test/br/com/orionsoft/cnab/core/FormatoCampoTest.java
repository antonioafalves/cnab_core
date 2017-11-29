/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.orionsoft.cnab.core;

import br.com.orionsoft.cnab.core.annotation.Campo;
import br.com.orionsoft.cnab.teste.Header;
import br.com.orionsoft.cnab.teste.Remessa;
import java.io.PrintWriter;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author antonio
 */
public class FormatoCampoTest {
    
    public FormatoCampoTest() {
    }

    /**
     * Test of values method, of class FormatoCampo.
     */
//    @Test
    public void testValues() {
        System.out.println("values");
        FormatoCampo[] expResult = null;
        FormatoCampo[] result = FormatoCampo.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class FormatoCampo.
     */
//    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        FormatoCampo expResult = null;
        FormatoCampo result = FormatoCampo.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formatar method, of class FormatoCampo.
     */
//    @Test
    public void testFormatar() {
        System.out.println("formatar");
        Object value = null;
        Campo campo = null;
        FormatoCampo instance = null;
        String expResult = "";
        String result = instance.formatar(value, campo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testar() throws Exception {
        Header h = new Header();
        h.setTeste(Header.Teste.TESTE1);
        
        Remessa r = new Remessa();
        r.setHeader(h);
        
        r.gravar(new PrintWriter("teste.txt"));
    }
}
