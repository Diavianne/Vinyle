package io.emiliebarre.vinyl.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmployeeCreate(
        @NotBlank @Size(max = 70) String firstname,
        @NotBlank @Size(max = 70) String lastname,
        @NotBlank @Email @Size(max = 100) String email,
        @NotBlank @Size(min = 8) String password
) {
}