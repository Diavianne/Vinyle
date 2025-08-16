package io.emiliebarre.vinyl.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FileSizeValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FileSize {
    String message() default "Fichier trop volumineux";

    long max();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    long FIVE_MB = 5 * 1024 * 1024;
}