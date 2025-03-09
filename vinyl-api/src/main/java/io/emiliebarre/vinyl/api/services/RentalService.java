package io.emiliebarre.vinyl.api.services;

import io.emiliebarre.vinyl.api.entities.Rental;
import io.emiliebarre.vinyl.api.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }


    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental);
    }


    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }


    public Optional<Rental> getRentalById(Long id) {
        return rentalRepository.findById(id);
    }


    public Rental updateRental(Long id, Rental rentalDetails) {
        return rentalRepository.findById(id).map(rental -> {
            rental.setRentalDate(rentalDetails.getRentalDate());
            rental.setReturnDate(rentalDetails.getReturnDate());
            rental.setVinyl(rentalDetails.getVinyl());
            rental.setCustomer(rentalDetails.getCustomer());
            rental.setEmployee(rentalDetails.getEmployee());
            return rentalRepository.save(rental);
        }).orElseThrow(() -> new RuntimeException("Location non trouvée avec l'ID : " + id));
    }


    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }
}
