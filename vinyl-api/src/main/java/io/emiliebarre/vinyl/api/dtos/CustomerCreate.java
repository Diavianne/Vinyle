package io.emiliebarre.vinyl.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record CustomerCreate(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String city
) {
}
