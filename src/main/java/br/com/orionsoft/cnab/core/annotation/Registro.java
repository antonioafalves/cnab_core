package br.com.orionsoft.cnab.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Registro {
    String id() default "";
    int idIndex() default 0;
    String delimitador() default "";
}
