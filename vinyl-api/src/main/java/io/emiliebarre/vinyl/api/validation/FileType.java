package io.emiliebarre.vinyl.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FileTypeValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FileType {
    String message() default "Type de fichier non autorisé";

    String[] types();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}