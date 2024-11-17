package io.emiliebarre.vinyl.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record VinylUpdate(
        @NotBlank String title,
        @NotBlank String artist,
        String style,
        @NotBlank String year,
        String label,
        String image
) {
}
