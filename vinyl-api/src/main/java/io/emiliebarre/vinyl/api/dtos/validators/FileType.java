package io.emiliebarre.vinyl.api.dtos.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.http.MediaType;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = FileTypeValidator.class)
public interface FileType extends Annotation {


    String[] types() default { MediaType.ALL_VALUE };

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
