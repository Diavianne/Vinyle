package io.emiliebarre.vinyl.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmployeeCreate(
        @NotBlank String firstname,
        @NotBlank String lastname,
        String job,
        @NotBlank String identifier,
        @NotBlank @Size(min = 9) String password,
        String manager
) {
}
