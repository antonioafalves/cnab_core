package br.com.orionsoft.cnab.teste;

import br.com.orionsoft.cnab.core.FormatoCampo;
import br.com.orionsoft.cnab.core.annotation.Campo;
import br.com.orionsoft.cnab.core.annotation.Identificador;
import br.com.orionsoft.cnab.core.annotation.Registro;

@Registro
public class Header {
    @Campo(formato = FormatoCampo.NUMERICO, tamanho = 2)
    private Teste teste;
    @Campo(inicio=1, tamanho=3, formato=FormatoCampo.NUMERICO)
    private int sequencia;
    @Identificador
    @Campo(inicio=4, tamanho=1, formato=FormatoCampo.ALFANUMERICO)
    private final String id = "H";
    @Campo(inicio=5, tamanho=26, formato=FormatoCampo.ALFANUMERICO)
    private String empresa;


    public enum Teste {
        TESTE1(1),
        TESTE2(2);

        private final Integer value;

        Teste(Integer value) {
            this.value = value;
        }

    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getId() {
        return id;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public Integer getTeste() {
        return teste.value;
    }

    public void setTeste(Teste teste) {
        this.teste = teste;
    }

}
