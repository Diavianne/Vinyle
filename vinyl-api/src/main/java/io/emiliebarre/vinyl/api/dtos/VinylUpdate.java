package io.emiliebarre.vinyl.api.dtos;

public record VinylUpdate(
        String title,
        String artist,
        String style,
        String year,
        String label,
        String image
) {
}
