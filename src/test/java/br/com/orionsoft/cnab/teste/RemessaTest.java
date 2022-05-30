package br.com.orionsoft.cnab.teste;

import org.junit.Test;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class RemessaTest {

    @Test
    public void retorno() throws Exception {
        Path path = Paths.get("/home/antonio/dev/orion/cnab_core", "teste.txt");
        Remessa r = new Remessa();
        r.ler(path);
    }

    @Test
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
        header.setTeste(Header.Teste.TESTE1);
        remessa.setHeader(header);

        sequencia++;
        d1.setSequencia(sequencia);
        d1.setNome("Fulano");
        d1.setValor(BigDecimal.valueOf(1.23));
        d1.setData(LocalDate.now());
        remessa.getDetalhes().add(d1);

        sequencia++;
        d2.setSequencia(sequencia);
        d2.setNome("Sicrano da Silva SaurO");
        d2.setValor(BigDecimal.valueOf(1.23));
        d2.setData(LocalDate.now());
        remessa.getDetalhes().add(d2);

        sequencia++;
        footer.setSequencia(sequencia);
        footer.setQuantidade(sequencia);
        remessa.setFooter(footer);

        remessa.gravar(new PrintWriter("teste.txt"));
    }
}