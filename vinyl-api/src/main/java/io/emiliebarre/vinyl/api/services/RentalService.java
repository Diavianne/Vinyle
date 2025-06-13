package io.emiliebarre.vinyl.api.services;

import io.emiliebarre.vinyl.api.entities.Customer;
import io.emiliebarre.vinyl.api.entities.Rental;
import io.emiliebarre.vinyl.api.entities.RentalItem;
import io.emiliebarre.vinyl.api.entities.Vinyl;
import io.emiliebarre.vinyl.api.repositories.CustomerRepository;
import io.emiliebarre.vinyl.api.repositories.RentalRepository;
import io.emiliebarre.vinyl.api.repositories.VinylRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;
    private final CustomerRepository customerRepository;
    private final VinylRepository vinylRepository;

    public RentalService(RentalRepository rentalRepository,
                         CustomerRepository customerRepository,
                         VinylRepository vinylRepository) {
        this.rentalRepository = rentalRepository;
        this.customerRepository = customerRepository;
        this.vinylRepository = vinylRepository;
    }

    public Rental addVinylToRental(String customerEmail, Long vinylId) {
        Customer customer = customerRepository.findByEmail(customerEmail)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Vinyl vinyl = vinylRepository.findById(vinylId)
                .orElseThrow(() -> new RuntimeException("Vinyl not found"));

        Rental rental = rentalRepository.findByCustomerEmailAndStatus(customerEmail, "PENDING")
                .orElseGet(() -> {
                    Rental newRental = new Rental();
                    newRental.setCustomer(customer);
                    newRental.setStatus("PENDING");
                    newRental.setStartDate(LocalDate.now());
                    return rentalRepository.save(newRental);
                });

        RentalItem item = new RentalItem();
        item.setRental(rental);
        item.setVinyl(vinyl);
        rental.getItems().add(item);

        return rentalRepository.save(rental);
    }

    public Rental validateRental(Long rentalId) {
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental not found"));
        rental.setStatus("ACTIVE");
        rental.setEndDate(LocalDate.now().plusWeeks(2));
        return rentalRepository.save(rental);
    }

    public Rental markAsReturned(Long rentalId) {
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental not found"));
        rental.setStatus("RETURNED");
        return rentalRepository.save(rental);
    }
}
