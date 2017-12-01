/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.orionsoft.cnab.teste;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

/**
 *
 * @author Antonio
 */
public class Teste {

//    @Test
    public void retorno() throws Exception {
        Path path = Paths.get("C:/Users/antonio/Documents/NetBeansProjects/CNAB_core", "teste.txt");
        Remessa r = new Remessa();
        r.ler(path);
    }
    
//    @Test
    public void remessa() throws Exception {
        int sequencia = 0;
        Remessa remessa = new Remessa();
        Header header = new Header();
        Detalhe d1 = new Detalhe();
        Detalhe d2 = new Detalhe();
        Footer footer = new Footer();

        sequencia++;
        header.setSequencia(sequencia);
        header.setEmpresa("Empresa");
        remessa.setHeader(header);

        sequencia++;
        d1.setSequencia(sequencia);
        d1.setNome("Fulano");
        d1.setValor(new BigDecimal(1.23));
        d1.setData(Calendar.getInstance());
        remessa.getDetalhes().add(d1);

        sequencia++;
        d2.setSequencia(sequencia);
        d2.setNome("Sicrano da Silva SaurO");
        d2.setValor(new BigDecimal(1.23));
        d2.setData(Calendar.getInstance());
        remessa.getDetalhes().add(d2);

        sequencia++;
        footer.setSequencia(sequencia);
        footer.setQuantidade(sequencia);
        remessa.setFooter(footer);

        remessa.gravar(new PrintWriter("teste.txt"));
    }
}