package io.emiliebarre.vinyl.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record CustomerUpdate(
        @NotBlank String firstname,
        @NotBlank String lastname,
        @NotBlank String email,
        @NotBlank String phone
) {
}
