package io.emiliebarre.vinyl.api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "t_customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    @Column(name = "customer_email")
    private String email;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "customer_address")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer() {
    }

    public Customer(Long id, String email, String name, String address) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.address = address;
    }
}


