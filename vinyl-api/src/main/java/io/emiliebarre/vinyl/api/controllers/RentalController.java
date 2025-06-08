package io.emiliebarre.vinyl.api.controllers;

import io.emiliebarre.vinyl.api.entities.Rental;
import io.emiliebarre.vinyl.api.services.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/add")
    public ResponseEntity<Rental> addVinylToRental(
            @RequestParam String email,
            @RequestParam Long vinylId) {
        return ResponseEntity.ok(rentalService.addVinylToRental(email, vinylId));
    }

    @PostMapping("/validate/{id}")
    public ResponseEntity<Rental> validateRental(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.validateRental(id));
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<Rental> returnRental(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.markAsReturned(id));
    }
}

