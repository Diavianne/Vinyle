package io.emiliebarre.vinyl.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmployeeCreate(
        @NotBlank @Size(max = 50) String identifier,
        @NotBlank @Size(max = 50) String firstname,
        @NotBlank @Size(max = 50) String lastname,
        @NotBlank String password
) {
}