/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.orionsoft.cnab.teste;

import br.com.orionsoft.cnab.core.Arquivo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antonio
 */
public class Remessa extends Arquivo {
    private Header header;
    private List<Detalhe> detalhes;
    private Footer footer;

    public List<Detalhe> getDetalhes() {
        if (detalhes == null)
            detalhes = new ArrayList<Detalhe>();
        return detalhes;
    }

    public void setDetalhes(List<Detalhe> detalhes) {
        this.detalhes = detalhes;
    }

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

}
