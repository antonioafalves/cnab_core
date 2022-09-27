package br.com.orionsoft.cnab.teste2;

import org.junit.Test;

import java.io.PrintWriter;

public class RemessaTest {

    public RemessaTest() {
    }

    @Test
    public void teste() throws Exception {
        int sq = 0;
        Remessa remessa = new Remessa();
        Header header = new Header();
        Footer footer = new Footer();

        Titular t1 = new Titular();
        Titular t2 = new Titular();
        Titular t3 = new Titular();

        Dependente d11 = new Dependente();

        Dependente d21 = new Dependente();
        Dependente d22 = new Dependente();

        Dependente d31 = new Dependente();
        Dependente d32 = new Dependente();
        Dependente d33 = new Dependente();

        /* Header */
        header.setSequencia(++sq);
        remessa.setHeader(header);

        /* Titular/dependente */
        t1.setSequencia(++sq);
        t1.setCpf("01456815997");
        t1.setTelefone(84134976);
        d11.setSequencia(++sq);
        t1.getDependentes().add(d11);
        remessa.getTitular().add(t1);

        t2.setSequencia(++sq);
        d21.setSequencia(++sq);
        t2.getDependentes().add(d21);
        d22.setSequencia(++sq);
        t2.getDependentes().add(d22);
        remessa.getTitular().add(t2);

        t3.setSequencia(++sq);
        d31.setSequencia(++sq);
        t3.getDependentes().add(d31);
        d32.setSequencia(++sq);
        t3.getDependentes().add(d32);
        d33.setSequencia(++sq);
        t3.getDependentes().add(d33);
        remessa.getTitular().add(t3);

        footer.setSequencia(++sq);
        remessa.setFooter(footer);

        remessa.save(new PrintWriter("teste.txt"));
    }
}