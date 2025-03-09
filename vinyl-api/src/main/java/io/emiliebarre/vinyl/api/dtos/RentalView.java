package io.emiliebarre.vinyl.api.dtos;

import java.time.LocalDate;

public record RentalView(

        Long id,
        LocalDate rentalDate,
        LocalDate returnDate,
        CustomerView customer,
        String employeeFirstname,
        String vinylTitle,
        String vinylArtist,
        String vinylImage
) {
}
