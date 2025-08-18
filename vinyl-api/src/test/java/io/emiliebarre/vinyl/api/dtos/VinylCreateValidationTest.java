package io.emiliebarre.vinyl.api.dtos;

import io.emiliebarre.vinyl.api.validation.FileSize;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;

class VinylCreateValidationTest {

    @Test
    void testImageSizeLimit() {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();
            byte[] content = new byte[(int) (FileSize.FIVE_MB + 1024 * 1024)];

            MockMultipartFile jpegFile = new MockMultipartFile("image", "img.jpeg", "image/jpeg", content);
            MockMultipartFile jpgFile = new MockMultipartFile("image", "img.jpg", "image/jpeg", content);
            MockMultipartFile pngFile = new MockMultipartFile("image", "img.png", "image/png", content);

            VinylCreate dtoJpeg = new VinylCreate("Titre", "Artiste", "2020", jpegFile);
            VinylCreate dtoJpg = new VinylCreate("Titre", "Artiste", "2020", jpgFile);
            VinylCreate dtoPng = new VinylCreate("Titre", "Artiste", "2020", pngFile);

            assertFalse(validator.validate(dtoJpeg).isEmpty());
            assertFalse(validator.validate(dtoJpg).isEmpty());
            assertFalse(validator.validate(dtoPng).isEmpty());
        }
    }
}