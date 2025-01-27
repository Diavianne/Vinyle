package io.emiliebarre.vinyl.api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "t_employees")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "identifier", unique = true, nullable = false)
    private String identifier;

    @Column(name = "employee_firstname")
    private String firstname;

    @Column(name = "employee_lastname")
    private String lastname;

    @Column(name = "employee_password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee() {
    }

 public Employee(String identifier, String firstname, String lastname, String password) {
    this.identifier = identifier;
    this.firstname = firstname;
    this.lastname = lastname;
    this.password = password;
}

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
