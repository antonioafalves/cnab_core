package br.com.orionsoft.cnab.teste;

import br.com.orionsoft.cnab.core.Pattern;
import br.com.orionsoft.cnab.core.annotation.Field;
import br.com.orionsoft.cnab.core.annotation.Identifier;
import br.com.orionsoft.cnab.core.annotation.Record;

@Record
public class Footer {
    @Field(start =1, size =3, pattern = Pattern.NUMERIC)
    private int sequencia;
    @Identifier
    @Field(start =4, size =1, pattern = Pattern.ALPHANUMERIC)
    private String id = "F";
    @Field(start =5, size =3, pattern = Pattern.NUMERIC)
    private int quantidade;
    @Field(start =8, size =23, pattern = Pattern.ALPHANUMERIC)
    private String reservado = "";

    public String getReservado() {
        return reservado;
    }

    public void setReservado(String reservado) {
        this.reservado = reservado;
    }

    public String getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

}
