//package io.emiliebarre.vinyl.api.entities;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "t_rentals")
//public class Rental {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "rental_id")
//    private Long id;
//
//    @Column(name = "rental_date", nullable = false)
//    private LocalDate rentalDate = LocalDate.now();
//
//    @Column(name = "return_date")
//    private LocalDate returnDate;
//
//    @ManyToOne
//    @JoinColumn(name = "vinyl_id", nullable = false)
//    private Vinyl vinyl;
//
//    @ManyToOne
//    @JoinColumn(name = "customer_id", nullable = false)
//    private Customer customer;
//
//    @ManyToOne
//    @JoinColumn(name = "employee_id", nullable = false)
//    private Employee employee;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public LocalDate getRentalDate() {
//        return rentalDate;
//    }
//
//    public void setRentalDate(LocalDate rentalDate) {
//        this.rentalDate = rentalDate;
//    }
//
//    public LocalDate getReturnDate() {
//        return returnDate;
//    }
//
//    public void setReturnDate(LocalDate returnDate) {
//        this.returnDate = returnDate;
//    }
//
//    public Vinyl getVinyl() {
//        return vinyl;
//    }
//
//    public void setVinyl(Vinyl vinyl) {
//        this.vinyl = vinyl;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//
//    public Rental() {
//    }
//
//    public Rental(LocalDate rentalDate, LocalDate returnDate, Vinyl vinyl, Customer customer, Employee employee) {
//        this.rentalDate = rentalDate != null ? rentalDate : LocalDate.now();
//        this.returnDate = returnDate;
//        this.vinyl = vinyl;
//        this.customer = customer;
//        this.employee = employee;
//    }
//
//    @Override
//    public String toString() {
//        return "Rental{" +
//                "id=" + id +
//                ", rentalDate=" + rentalDate +
//                ", returnDate=" + returnDate +
//                ", vinyl=" + vinyl +
//                ", customer=" + customer +
//                ", employee=" + employee +
//                '}';
//    }
//}
