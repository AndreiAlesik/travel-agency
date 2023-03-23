package com.example.travelagency.domain;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "personal_number", nullable = false, length = 255)
    private String personalNumber;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "surename", nullable = false, length = 255)
    private String surename;
    @Basic
    @Column(name = "address", nullable = false, length = 255)
    private String address;
    @Basic
    @Column(name = "phone_number", nullable = false, length = 12)
    private String phoneNumber;
    @Basic
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<TravelCustomer> travelCustomersById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(personalNumber, customer.personalNumber) && Objects.equals(name, customer.name) && Objects.equals(surename, customer.surename) && Objects.equals(address, customer.address) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(dateOfBirth, customer.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personalNumber, name, surename, address, phoneNumber, dateOfBirth);
    }

    public Collection<TravelCustomer> getTravelCustomersById() {
        return travelCustomersById;
    }

    public void setTravelCustomersById(Collection<TravelCustomer> travelCustomersById) {
        this.travelCustomersById = travelCustomersById;
    }
}
