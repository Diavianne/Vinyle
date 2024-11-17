package io.emiliebarre.vinyl.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public record VinylCreate(
        @NotBlank String title,
        @NotBlank String artist,
        String style,
        @NotBlank String year,
        String label,
        MultipartFile image
) {
}
