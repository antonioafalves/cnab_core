package br.com.orionsoft.cnab.teste;

import br.com.orionsoft.cnab.core.Pattern;
import br.com.orionsoft.cnab.core.annotation.Field;
import br.com.orionsoft.cnab.core.annotation.Identifier;
import br.com.orionsoft.cnab.core.annotation.Record;

@Record
public class Header {
    @Field(pattern = Pattern.NUMERIC, size = 2)
    private Teste teste;
    @Field(start =1, size =3, pattern = Pattern.NUMERIC)
    private int sequencia;
    @Identifier
    @Field(start =4, size =1, pattern = Pattern.ALPHANUMERIC)
    private final String id = "H";
    @Field(start =5, size =26, pattern = Pattern.ALPHANUMERIC)
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
