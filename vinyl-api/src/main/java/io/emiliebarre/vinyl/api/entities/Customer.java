package io.emiliebarre.vinyl.api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "t_customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_email", unique = true, nullable = false)
    private String email;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_city")
    private String city;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Customer() {
    }

    public Customer(Long id, String email, String name, String city) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}


