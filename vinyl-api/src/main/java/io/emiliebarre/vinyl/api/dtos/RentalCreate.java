package io.emiliebarre.vinyl.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RentalCreate(
        @NotNull LocalDate rentalDate,
        LocalDate returnDate,
        @NotNull CustomerView customer,
        @NotBlank String employeeFirstname,
        @NotBlank String vinylTitle,
        @NotBlank String vinylArtist,
        String vinylImage
) {

}
