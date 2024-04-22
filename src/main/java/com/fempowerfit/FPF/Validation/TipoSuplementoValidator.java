package com.fempowerfit.FPF.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoSuplementoValidator implements ConstraintValidator<TipoSuplemento, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("WHEYPROTEIN") || value.equals("CREATINA") || value.equals("PRE-TREINO") || value.equals("OUTRO");
    }

}
