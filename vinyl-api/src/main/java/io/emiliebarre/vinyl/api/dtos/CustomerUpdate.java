package io.emiliebarre.vinyl.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record CustomerUpdate(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String address
) {
}
