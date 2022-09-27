package br.com.orionsoft.cnab.teste2;

import br.com.orionsoft.cnab.core.Pattern;
import br.com.orionsoft.cnab.core.annotation.Field;
import br.com.orionsoft.cnab.core.annotation.Record;
import br.com.orionsoft.cnab.core.annotation.SubRecord;

import java.util.ArrayList;
import java.util.List;

//@Arquivo(sequenceSize="3", sequenceIndex="0" )
@Record(delimiter ="|")
public class Titular {
    @Field(size =3, pattern = Pattern.NUMERIC)
    private int sequencia;
    @Field(size =10, pattern = Pattern.ALPHANUMERIC, fixed =false)
    private String id = "TITULAR";
    @Field(size =11, pattern = Pattern.NUMERIC)
    private String cpf;
    @Field(size =8, pattern = Pattern.NUMERIC)
    private long telefone;
    @SubRecord
    private List<Dependente> dependentes;

    public List<Dependente> getDependentes() {
        if (dependentes == null)
            dependentes = new ArrayList<>();
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
