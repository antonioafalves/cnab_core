package br.com.orionsoft.cnab.teste;

import br.com.orionsoft.cnab.core.FormatoCampo;
import br.com.orionsoft.cnab.core.annotation.Campo;
import br.com.orionsoft.cnab.core.annotation.Identificador;
import br.com.orionsoft.cnab.core.annotation.Registro;

import java.math.BigDecimal;
import java.time.LocalDate;

@Registro
public class Detalhe {
    @Campo(inicio=1, tamanho=3, formato= FormatoCampo.NUMERICO)
    private int sequencia;
    @Identificador
    @Campo(inicio=4, tamanho=1, formato=FormatoCampo.ALFANUMERICO)
    private String id = "D";
    @Campo(inicio=5, tamanho=13, formato=FormatoCampo.ALFANUMERICO)
    private String nome;
    @Campo(inicio=18, tamanho=5, formato=FormatoCampo.DECIMAL)
    private BigDecimal valor;
    @Campo(inicio=23, tamanho=8, formato=FormatoCampo.DATA_AAAAMMDD)
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
