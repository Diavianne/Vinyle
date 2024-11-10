package io.emiliebarre.vinyl.api.services;

import io.emiliebarre.vinyl.api.dtos.VinylCreate;
import io.emiliebarre.vinyl.api.entities.Vinyl;
import io.emiliebarre.vinyl.api.repositories.VinylRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class VinylService {

    @Value("${spotmebusiness.uploads.dest}")
    private String uploadsDest;


    private final VinylRepository vinylRepository;

    @Autowired
    public VinylService(VinylRepository vinylRepository) {
        this.vinylRepository = vinylRepository;
    }

    public List<Vinyl> getAllVinyls() {
        return vinylRepository.findAll();
    }

    public Vinyl getVinylById(Long id) {
        return vinylRepository.findById(id).orElse(null);
    }

    public void create(VinylCreate inputs) {
        Vinyl entity = new Vinyl();
        entity.setTitle(inputs.title());
        entity.setArtist(inputs.artist());
        entity.setStyle(inputs.style());
        entity.setYear(inputs.year());
        entity.setLabel(inputs.label());
        MultipartFile image = inputs.image();
        if (image != null) {
            String imageId = buildImageId(image);
            storeImage(image, imageId);
            entity.setImageId(imageId);
        }
        vinyls.save(entity);

    }

    private void storeImage(MultipartFile image, String imageId) {
        try {
            String dest = String.format("%s/%s", uploadsDest, imageId);
            File file = new File(dest);
            image.transferTo(file);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private String buildImageId(MultipartFile image) {
        UUID uuid = UUID.randomUUID();
        String name = image.getOriginalFilename();
        int index = name.lastIndexOf('.');
        String ext = name.substring(index, name.length());
        return uuid + ext;
    }


    public void deleteVinyl(Long id) {
        vinylRepository.deleteById(id);
    }
}
