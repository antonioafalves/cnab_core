package br.com.orionsoft.cnab.teste;

import br.com.orionsoft.cnab.core.Pattern;
import br.com.orionsoft.cnab.core.annotation.Field;
import br.com.orionsoft.cnab.core.annotation.identifier;
import br.com.orionsoft.cnab.core.annotation.Record;

@Record
public class Header {
    @Field(format = Pattern.NUMERIC, size = 2)
    private Teste teste;
    @Field(start =1, size =3, format = Pattern.NUMERIC)
    private int sequencia;
    @identifier
    @Field(start =4, size =1, format = Pattern.ALPHANUMERIC)
    private final String id = "H";
    @Field(start =5, size =26, format = Pattern.ALPHANUMERIC)
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
