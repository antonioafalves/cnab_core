package br.com.orionsoft.cnab.teste2;

import br.com.orionsoft.cnab.core.Pattern;
import br.com.orionsoft.cnab.core.annotation.Field;
import br.com.orionsoft.cnab.core.annotation.Record;

@Record(delimiter ="|")
public class Dependente {
    @Field(size =3, pattern = Pattern.NUMERIC)
    private int sequencia;
    @Field(size =10, pattern = Pattern.ALPHANUMERIC, fixed =false)
    private String id = "DEPENDENTE";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

}
