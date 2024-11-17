package io.emiliebarre.vinyl.api.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RentalCreate(
        @NotBlank LocalDate rentalDate,
        LocalDate returnDate,
        @NotBlank CustomerView customer,
        @NotBlank String employeeFirstname,
        @NotBlank String vinylTitle,
        @NotBlank String vinylArtist,
        String vinylImage
) {
}
