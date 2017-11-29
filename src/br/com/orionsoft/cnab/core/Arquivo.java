/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.orionsoft.cnab.core;

import br.com.orionsoft.cnab.core.annotation.Campo;
import br.com.orionsoft.cnab.core.annotation.Registro;
import br.com.orionsoft.cnab.core.annotation.SubRegistro;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antonio
 */
public abstract class Arquivo {

    public boolean gravar(PrintWriter writer) throws Exception {
        /* Busca a classe que implementou Arquivo */
        Class classe = this.getClass();
        /* Itera nos registros (fields) */
        for (Field field : classe.getDeclaredFields()) {
            Method method = classe.getMethod("get".concat(field.getName().substring(0, 1).toUpperCase()).concat(field.getName().substring(1)));
            /* Se não for uma lista, cria uma e adiciona o campo na lista */
            List list;
            if (field.getType() == List.class) {
                list = (List) method.invoke(this);
            } else {
                list = new ArrayList<Registro>();
                list.add(method.invoke(this));
            }
            processarRegistros(list, writer);
        }
        writer.flush();
        writer.close();
        return true;
    }
    
    public boolean ler(Path path) throws Exception {
        Reader r = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));
        BufferedReader br = new BufferedReader(r);
    	String linha;
        while ((linha = br.readLine()) != null){
            processarLinha(linha);
        }
        return true;
    }

    public boolean ler(InputStream is) throws Exception {
    	BufferedReader br =  new BufferedReader(new InputStreamReader(is));
    	String linha;
        while ((linha = br.readLine()) != null){
            processarLinha(linha);
        }
        return true;
    }

    private void processarLinha(String linha) throws Exception {
        Class classe = this.getClass();
        for (Field field : classe.getDeclaredFields()) {
            Method method = classe.getMethod("get".concat(field.getName().substring(0, 1).toUpperCase()).concat(field.getName().substring(1)));
            /* Se não for uma lista, cria uma e adiciona o campo na lista */
            List list;
            if (field.getType() == List.class) {
                list = (List) method.invoke(this);
            } else {
                list = new ArrayList<Registro>();
                list.add(method.invoke(this));
            }
            // TODO Identificar o tipo de registro contido na linha
        }
    }

    private void processarRegistros(List list, PrintWriter writer) throws SecurityException, InvocationTargetException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException {
        /* Registros */
        for (Object registro : list) {
            if (registro != null) {
                StringBuilder linha = new StringBuilder();
                Class c = registro.getClass();
                Registro anotacaoRegistro = (Registro) c.getAnnotation(Registro.class);
                if (anotacaoRegistro != null) {
                    /* Campos */
                    for (Field f : c.getDeclaredFields()) {
                        Campo anotacaoCampo = f.getAnnotation(Campo.class);
                        if (anotacaoCampo != null) {
                            /* Invoca o método get de cada campo */
                            Method m = c.getMethod("get".concat(f.getName().substring(0, 1).toUpperCase()).concat(f.getName().substring(1)));
                            Object valorCampo = m.invoke(registro);
                            linha.append(formatarCampo(anotacaoCampo, valorCampo).concat(anotacaoRegistro.delimitador()));
                        }
                    }
                    writer.println(linha);
                    /* SubRegistros */
                    for (Field f : c.getDeclaredFields()) {
                        SubRegistro anotacaoCampo = f.getAnnotation(SubRegistro.class);
                        if (anotacaoCampo != null) {
                            /* Invoca o método get de cada campo */
                            Method m = c.getMethod("get".concat(f.getName().substring(0, 1).toUpperCase()).concat(f.getName().substring(1)));
                            List l;
                            if (f.getType() == List.class) {
                                l = (List) m.invoke(registro);
                            } else {
                                l = new ArrayList();
                                l.add(m.invoke(registro));
                            }
                            processarRegistros(l, writer);
                        }
                    }
                }
            }
        }
    }

    private String formatarCampo(Campo campo, Object value) {
        String result = campo.formato().formatar(value, campo);
        if (!campo.fixo()) {
            result = result.trim();
        } 
        if (campo.tamanho() > 0) {
            if (result.length() > campo.tamanho()) {
                result = result.substring(0, campo.tamanho());
            }
        }
        return result;
    }
}
