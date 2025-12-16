package br.com.orionsoft.cnab.core;

import br.com.orionsoft.cnab.core.annotation.Field;
import br.com.orionsoft.cnab.core.annotation.Record;
import br.com.orionsoft.cnab.core.annotation.SubRecord;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class File {

    public String get() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        /* Busca a classe que implementou Arquivo */
        Class<? extends File> classe = this.getClass();
        /* Itera nos registros (fields) */
        for (java.lang.reflect.Field field : classe.getDeclaredFields()) {
            Method method = classe.getMethod("get".concat(field.getName().substring(0, 1).toUpperCase()).concat(field.getName().substring(1)));
            /* Se não for uma lista, cria uma e adiciona o campo na lista */
            List list;
            if (field.getType() == List.class) {
                list = (List) method.invoke(this);
            } else {
                list = new ArrayList<Record>();
                list.add(method.invoke(this));
            }
            builder.append(processRecord(list));
        }
        return builder.toString();
    }

    /**
     * TODO Usar metodo get()
     */
    public void save(PrintWriter writer) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /* Busca a classe que implementou Arquivo */
        Class<? extends File> classe = this.getClass();
        /* Itera nos registros (fields) */
        for (java.lang.reflect.Field field : classe.getDeclaredFields()) {
            Method method = classe.getMethod("get".concat(field.getName().substring(0, 1).toUpperCase()).concat(field.getName().substring(1)));
            /* Se não for uma lista, cria uma e adiciona o campo na lista */
            List list;
            if (field.getType() == List.class) {
                list = (List) method.invoke(this);
            } else {
                list = new ArrayList<Record>();
                list.add(method.invoke(this));
            }
            processRecord(list, writer);
        }
        writer.flush();
        writer.close();
    }

    public void read(Path path) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Reader r = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);
        BufferedReader br = new BufferedReader(r);
        String linha;
        while ((linha = br.readLine()) != null) {
            processLine(linha);
        }
    }

    public void read(InputStream is) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String linha;
        while ((linha = br.readLine()) != null) {
            processLine(linha);
        }
    }

    private void processLine(String line) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<? extends File> classe = this.getClass();
        for (java.lang.reflect.Field field : classe.getDeclaredFields()) {
            Method method = classe.getMethod("get".concat(field.getName().substring(0, 1).toUpperCase()).concat(field.getName().substring(1)));
            /* Se não for uma lista, cria uma e adiciona o campo na lista */
            List list;
            if (field.getType() == List.class) {
                list = (List) method.invoke(this);
            } else {
                list = new ArrayList<Record>();
                list.add(method.invoke(this));
            }
            // TODO Identificar o tipo de registro contido na line
        }
    }

    /**
     * TODO User metodo processRecord(List list)
     */
    private void processRecord(List list, PrintWriter writer) throws SecurityException, InvocationTargetException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException {
        /* Registros */
        for (Object registro : list) {
            if (registro != null) {
                StringBuilder linha = new StringBuilder();
                Class<?> c = registro.getClass();
                Record anotacaoRecord = c.getAnnotation(Record.class);
                if (anotacaoRecord != null) {
                    /* Campos */
                    for (java.lang.reflect.Field f : c.getDeclaredFields()) {
                        Field anotacaoField = f.getAnnotation(Field.class);
                        if (anotacaoField != null) {
                            /* Invoca o método get de cada campo */
                            Method m = c.getMethod("get".concat(f.getName().substring(0, 1).toUpperCase()).concat(f.getName().substring(1)));
                            Object valorCampo = m.invoke(registro);
                            linha.append(formatField(anotacaoField, valorCampo).concat(anotacaoRecord.delimiter()));
                        }
                    }
                    writer.println(linha);
                    /* SubRegistros */
                    for (java.lang.reflect.Field f : c.getDeclaredFields()) {
                        SubRecord anotacaoCampo = f.getAnnotation(SubRecord.class);
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
                            processRecord(l, writer);
                        }
                    }
                }
            }
        }
    }

    private String processRecord(List list) throws SecurityException, InvocationTargetException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException {
        /* Registros */
        StringBuilder linha = new StringBuilder();
        for (Object registro : list) {
            if (registro != null) {
                Class<?> c = registro.getClass();
                Record anotacaoRecord = c.getAnnotation(Record.class);
                if (anotacaoRecord != null) {
                    /* Campos */
                    for (java.lang.reflect.Field f : c.getDeclaredFields()) {
                        Field anotacaoField = f.getAnnotation(Field.class);
                        if (anotacaoField != null) {
                            /* Invoca o método get de cada campo */
                            Method m = c.getMethod("get".concat(f.getName().substring(0, 1).toUpperCase()).concat(f.getName().substring(1)));
                            Object valorCampo = m.invoke(registro);
                            linha.append(formatField(anotacaoField, valorCampo).concat(anotacaoRecord.delimiter()));
                        }
                    }
                    linha.append(System.lineSeparator());
                    /* SubRegistros */
                    for (java.lang.reflect.Field f : c.getDeclaredFields()) {
                        SubRecord anotacaoCampo = f.getAnnotation(SubRecord.class);
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
                            linha.append(processRecord(l));
                        }
                    }
                }
            }
        }
        return linha.toString();
    }

    private String formatField(Field field, Object value) {
        String result = field.pattern().format(value, field);
        if (!field.fixed()) {
            result = result.trim();
        }
        if (field.size() > 0) {
            if (result.length() > field.size()) {
                result = result.substring(0, field.size());
            }
        }
        return result;
    }
}
