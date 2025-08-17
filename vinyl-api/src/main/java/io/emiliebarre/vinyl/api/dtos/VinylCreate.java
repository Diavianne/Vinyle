package io.emiliebarre.vinyl.api.dtos;

import io.emiliebarre.vinyl.api.validation.FileSize;
import io.emiliebarre.vinyl.api.validation.FileType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;


public record VinylCreate(
        @NotBlank @Size(max = 255) String title,
        @NotBlank @Size(max = 255) String artist,
        @NotBlank @Size(max = 4) String year,
        @FileType(types = {
                MediaType.IMAGE_JPEG_VALUE,
                MediaType.IMAGE_PNG_VALUE})
        @FileSize(max = FileSize.FIVE_MB) MultipartFile image) {
}