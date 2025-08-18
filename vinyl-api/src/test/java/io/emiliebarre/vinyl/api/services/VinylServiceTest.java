package io.emiliebarre.vinyl.api.services;

import io.emiliebarre.vinyl.api.dtos.VinylCreate;
import io.emiliebarre.vinyl.api.entities.Vinyl;
import io.emiliebarre.vinyl.api.repositories.VinylRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.web.multipart.MultipartFile;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class VinylServiceTest {

    @Test
    void testCreateVinyl() {
        VinylRepository repo = mock(VinylRepository.class);
        VinylService service = new VinylService(repo);

        MultipartFile mockFile = mock(MultipartFile.class);
        when(mockFile.getOriginalFilename()).thenReturn("img.jpg");

        VinylCreate dto = new VinylCreate("Titre", "Artiste", "2020", mockFile);
        service.create(dto);

        ArgumentCaptor<Vinyl> captor = ArgumentCaptor.forClass(Vinyl.class);
        verify(repo).save(captor.capture());
        Vinyl saved = captor.getValue();
        assertEquals("Titre", saved.getTitle());
        assertEquals("Artiste", saved.getArtist());
        assertEquals("2020", saved.getYear());
        assertTrue(saved.getImageId().endsWith(".jpg") || saved.getImageId().endsWith(".jpeg") || saved.getImageId().endsWith(".png"));
    }
}