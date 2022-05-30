package br.com.orionsoft.cnab.core.annotation;

import br.com.orionsoft.cnab.core.FormatoCampo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Campo {
	int inicio() default 0;
	int tamanho() default 0;
        boolean fixo() default true;
        boolean requerido() default true;
	FormatoCampo formato();
}
