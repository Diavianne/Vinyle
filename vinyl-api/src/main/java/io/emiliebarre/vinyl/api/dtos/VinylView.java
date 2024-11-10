package io.emiliebarre.vinyl.api.dtos;

public record VinylView(
        Long id,
        String title,
        String artist,
        String style,
        String year,
        String label,
        String image
) {
}
