package io.emiliebarre.vinyl.api.dtos;

import org.springframework.web.multipart.MultipartFile;

public record VinylView(
        Long id,
        String title,
        String artist,
        String year,
        String imageId
) {
}
