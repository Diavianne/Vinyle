package io.emiliebarre.vinyl.api.dtos;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public record VinylCreate(
        @NotBlank String title,
        @NotBlank String artist,
        @NotBlank String year,
        MultipartFile image
) {
}
