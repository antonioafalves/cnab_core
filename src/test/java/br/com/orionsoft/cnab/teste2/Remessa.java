package br.com.orionsoft.cnab.teste2;

// Criar um hashMap com Identificadores possiveis e suas respectivas classes
// Percorre a classe arquivo identificando os seus registros, para cada
// tipo de registro encontrado busca o IDENTIFICADOR do @Registro
// Dentro de um registro, busque @Subregistros para pegar a classe
// e seu IDENTIFICADOR do @Registro para também colocá-lo no Map

import br.com.orionsoft.cnab.core.File;

import java.util.ArrayList;
import java.util.List;

public class Remessa extends File {
    private Header header;
    private List<Titular> titular;
    private Footer footer;

    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<Titular> getTitular() {
        if (titular == null)
            titular = new ArrayList<>();
        return titular;
    }

    public void setTitular(List<Titular> titular) {
        this.titular = titular;
    }

}
