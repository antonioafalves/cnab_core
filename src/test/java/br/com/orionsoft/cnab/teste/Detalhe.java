package br.com.orionsoft.cnab.teste;

import br.com.orionsoft.cnab.core.Pattern;
import br.com.orionsoft.cnab.core.annotation.Field;
import br.com.orionsoft.cnab.core.annotation.Identifier;
import br.com.orionsoft.cnab.core.annotation.Record;

import java.math.BigDecimal;
import java.time.LocalDate;

@Record
public class Detalhe {
    @Field(start =1, size =3, pattern = Pattern.NUMERIC)
    private int sequencia;
    @Identifier
    @Field(start =4, size =1, pattern = Pattern.ALPHANUMERIC)
    private String id = "D";
    @Field(start =5, size =13, pattern = Pattern.ALPHANUMERIC)
    private String nome;
    @Field(start =18, size =5, pattern = Pattern.DECIMAL)
    private BigDecimal valor;
    @Field(start =23, size =8, pattern = Pattern.DATE_AAAAMMDD)
    private LocalDate data;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

}
