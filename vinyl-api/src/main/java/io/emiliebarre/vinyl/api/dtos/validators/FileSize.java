package io.emiliebarre.vinyl.api.dtos.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD })
@Documented
@Constraint(validatedBy = FileSizeValidator.class)
public interface FileSize  {

    static final long FIVE_MB = 5 * 1024 * 1024;

    String message() default "The size of the file must be less than 5MB";

    long max() default FIVE_MB;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
