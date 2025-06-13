package io.emiliebarre.vinyl.api.dtos;

import java.time.LocalDate;

public record RentalView(
        Long rentalId,
        LocalDate startDate,
        LocalDate endDate,
        CustomerView customer
) {
}
