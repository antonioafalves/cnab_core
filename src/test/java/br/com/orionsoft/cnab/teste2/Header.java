package br.com.orionsoft.cnab.teste2;

import br.com.orionsoft.cnab.core.Pattern;
import br.com.orionsoft.cnab.core.annotation.Field;
import br.com.orionsoft.cnab.core.annotation.Record;

@Record(delimiter ="|")
public class Header {
    @Field(size =3, format = Pattern.NUMERIC)
    private int sequencia;
    @Field(size =10, format = Pattern.ALPHANUMERIC, fixed =false)
    private String id = "HEADER";

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
