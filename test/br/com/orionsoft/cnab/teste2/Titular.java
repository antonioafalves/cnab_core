/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.orionsoft.cnab.teste2;

import br.com.orionsoft.cnab.core.FormatoCampo;
import br.com.orionsoft.cnab.core.annotation.Campo;
import br.com.orionsoft.cnab.core.annotation.Registro;
import br.com.orionsoft.cnab.core.annotation.SubRegistro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antonio
 */
//@Arquivo(sequenceSize="3", sequenceIndex="0" )
@Registro(delimitador="|")
public class Titular {
    @Campo(tamanho=3, formato=FormatoCampo.NUMERICO)
    private int sequencia;
    @Campo(tamanho=10, formato=FormatoCampo.ALFANUMERICO, fixo=false)
    private String id = "TITULAR";
    @Campo(tamanho=11, formato=FormatoCampo.NUMERICO)
    private String cpf;
    @Campo(tamanho=8, formato=FormatoCampo.NUMERICO)
    private long telefone;
    @SubRegistro
    private List<Dependente> dependentes;

    public List<Dependente> getDependentes() {
        if (dependentes == null)
            dependentes = new ArrayList<Dependente>();
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

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
