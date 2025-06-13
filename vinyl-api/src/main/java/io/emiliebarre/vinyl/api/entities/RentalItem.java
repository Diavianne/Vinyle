package io.emiliebarre.vinyl.api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "t_rental_items")
public class RentalItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalItemId;

    @ManyToOne
    @JoinColumn(name = "vinyl_id", nullable = false)
    private Vinyl vinyl;

    public Long getRentalItemId() {
        return rentalItemId;
    }

    public void setRentalItemId(Long rentalItemId) {
        this.rentalItemId = rentalItemId;
    }

    public Vinyl getVinyl() {
        return vinyl;
    }

    public void setVinyl(Vinyl vinyl) {
        this.vinyl = vinyl;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    @ManyToOne
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rental;
}

