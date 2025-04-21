package io.emiliebarre.vinyl.api.services;

import io.emiliebarre.vinyl.api.dtos.VinylCreate;
import io.emiliebarre.vinyl.api.dtos.VinylUpdate;
import io.emiliebarre.vinyl.api.dtos.VinylView;
import io.emiliebarre.vinyl.api.entities.Vinyl;
import io.emiliebarre.vinyl.api.repositories.VinylRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Collection;
import java.util.UUID;

@Service
public class VinylService {

    @Value("${vinylapi.uploads.dest}")
    private String uploadsDest;

    private final VinylRepository vinyls;


    public VinylService(VinylRepository vinylRepository) {
        this.vinyls = vinylRepository;
    }


    public void create(VinylCreate inputs) {
        Vinyl entity = new Vinyl();
        entity.setTitle(inputs.title());
        entity.setArtist(inputs.artist());
        entity.setYear(inputs.year());
        MultipartFile image = inputs.image();
        if (image != null) {
            String imageId = buildImageId(image);
            storeImage(image, imageId);
            entity.setImageId(imageId);
        }
        vinyls.save(entity);

    }

    private String buildImageId(MultipartFile image) {
        UUID uuid = UUID.randomUUID();
        String name = image.getOriginalFilename();
        int index = name.lastIndexOf('.');
        String ext = name.substring(index, name.length());
        return uuid + ext;
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


    public void deleteVinyl(Long id) {
        vinyls.deleteById(id);
    }

    public void updateOne(Long id, VinylUpdate inputs) {

    }

    public void deleteOne(Long id) {
        vinyls.deleteById(id);
    }

    public Collection<VinylView> getAll() {
        return vinyls.findAllProjectedBy();
    }


    public Vinyl getVinylById(Long id) {
        return vinyls.findById(id).orElse(null);
    }
}
