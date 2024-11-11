package io.emiliebarre.vinyl.api.controllers;

import io.emiliebarre.vinyl.api.dtos.VinylCreate;
import io.emiliebarre.vinyl.api.dtos.VinylUpdate;
import io.emiliebarre.vinyl.api.dtos.VinylView;
import io.emiliebarre.vinyl.api.entities.Vinyl;
import io.emiliebarre.vinyl.api.services.VinylService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/vinyls")
public class VinylController {
    private final VinylService vinylService;

@Autowired
    public VinylController(VinylService vinylService) {
        this.vinylService = vinylService;
    }

    @PostMapping
    void create(@Valid @ModelAttribute VinylCreate inputs) {
        vinylService.create(inputs);
    }

    @GetMapping
    Collection<VinylView> getAll() {
        return vinylService.getAll();
    }

    @GetMapping("/vinyls/{id}")
    public Vinyl getVinylById(@PathVariable Long id) {
        return vinylService.getVinylById(id);
    }

   @PutMapping("/{id}")
    void updateOne(@PathVariable("id") Long id,
                   @Valid @ModelAttribute VinylUpdate inputs) {
        vinylService.updateOne(id, inputs);
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable ("id") Long id) {
        vinylService.deleteOne(id);
    }
}
