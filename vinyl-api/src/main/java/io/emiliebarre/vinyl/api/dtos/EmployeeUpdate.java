package io.emiliebarre.vinyl.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmployeeUpdate(
        @NotBlank @Size(max = 50) String firstname,
        @NotBlank @Size(max = 50) String lastname,
        @NotBlank @Size(max = 50) String password
) {
}