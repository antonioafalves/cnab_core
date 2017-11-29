/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.orionsoft.cnab.teste2;

import br.com.orionsoft.cnab.core.FormatoCampo;
import br.com.orionsoft.cnab.core.annotation.Campo;
import br.com.orionsoft.cnab.core.annotation.Registro;

/**
 *
 * @author Antonio
 */
@Registro(delimitador="|")
public class Footer {
    @Campo(tamanho=3, formato=FormatoCampo.NUMERICO)
    private int sequencia;
    @Campo(tamanho=10, formato=FormatoCampo.ALFANUMERICO, fixo=false)
    private String id = "FOOTER";

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
