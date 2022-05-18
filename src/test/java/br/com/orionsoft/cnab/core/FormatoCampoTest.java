package br.com.orionsoft.cnab.core;

import br.com.orionsoft.cnab.core.annotation.Campo;
import br.com.orionsoft.cnab.teste.Header;
import br.com.orionsoft.cnab.teste.Remessa;
import org.junit.Assert;

import java.io.PrintWriter;

public class FormatoCampoTest {
    
    public FormatoCampoTest() {
    }

//    @Test
    public void testValues() {
        System.out.println("values");
        FormatoCampo[] expResult = null;
        FormatoCampo[] result = FormatoCampo.values();
        Assert.assertArrayEquals(expResult, result);
    }

//    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        FormatoCampo expResult = null;
        FormatoCampo result = FormatoCampo.valueOf(name);
        Assert.assertEquals(expResult, result);
    }

//    @Test
    public void testFormatar() {
        System.out.println("formatar");
        Object value = null;
        Campo campo = null;
        FormatoCampo instance = null;
        String expResult = "";
        String result = instance.formatar(value, campo);
        Assert.assertEquals(expResult, result);
    }

//    @Test
    public void testar() throws Exception {
        Header h = new Header();
        h.setTeste(Header.Teste.TESTE1);

        Remessa r = new Remessa();
        r.setHeader(h);

        r.gravar(new PrintWriter("teste.txt"));
    }
}
