package com.fempowerfit.FPF.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoSuplementoValidator implements ConstraintValidator<TipoSuplemento, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equalsIgnoreCase("WHEYPROTEIN") || value.equalsIgnoreCase("CREATINA") || value.equalsIgnoreCase("PRE-TREINO") || value.equalsIgnoreCase("OUTRO");
    }

}
