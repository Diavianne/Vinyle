package io.emiliebarre.vinyl.api.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "t_rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Long id;
    @Column(name = "rental_date")
    private LocalDate rentalDate;
    @Column(name = "return_date")
    private LocalDate returnDate;
}
