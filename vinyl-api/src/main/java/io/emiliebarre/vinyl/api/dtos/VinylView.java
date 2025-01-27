package io.emiliebarre.vinyl.api.dtos;

public record VinylView(
        Long id,
        String title,
        String artist,
        String year,
        String image
) {
}
