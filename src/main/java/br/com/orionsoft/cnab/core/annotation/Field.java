package br.com.orionsoft.cnab.core.annotation;

import br.com.orionsoft.cnab.core.Pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Field {
    int start() default 0;

    int size() default 0;

    boolean fixed() default true;

    boolean required() default true;

    Pattern pattern();
}
