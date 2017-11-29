/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.orionsoft.cnab.teste;

import br.com.orionsoft.cnab.core.annotation.Campo;
import br.com.orionsoft.cnab.core.FormatoCampo;
import br.com.orionsoft.cnab.core.annotation.Identificador;
import br.com.orionsoft.cnab.core.annotation.Registro;

/**
 *
 * @author Antonio
 */
@Registro
public class Footer {
    @Campo(inicio=1, tamanho=3, formato=FormatoCampo.NUMERICO)
    private int sequencia;
    @Identificador
    @Campo(inicio=4, tamanho=1, formato=FormatoCampo.ALFANUMERICO)
    private String id = "F";
    @Campo(inicio=5, tamanho=3, formato=FormatoCampo.NUMERICO)
    private int quantidade;
    @Campo(inicio=8, tamanho=23, formato=FormatoCampo.ALFANUMERICO)
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
