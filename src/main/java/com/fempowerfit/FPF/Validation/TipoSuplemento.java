package com.fempowerfit.FPF.Validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(FIELD)
@Constraint(validatedBy = TipoSuplementoValidator.class)
@Retention(RUNTIME)
public @interface TipoSuplemento {
    
    String message() default "Tipo inválido. Tipo deve ser WHEYPROTEIN, CREATINA, PRE-TREINO ou OUTROS.";

    Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}