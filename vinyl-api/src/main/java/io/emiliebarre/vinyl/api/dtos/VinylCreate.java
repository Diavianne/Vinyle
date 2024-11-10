package io.emiliebarre.vinyl.api.dtos;

import org.springframework.web.multipart.MultipartFile;

public record VinylCreate(
        String title,
        String artist,
        String style,
        String year,
        String label,
        MultipartFile image
) {
}
