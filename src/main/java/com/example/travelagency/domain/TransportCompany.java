package com.example.travelagency.domain;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "transport_company", schema = "public", catalog = "database")
public class TransportCompany {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "phone_number", nullable = false, length = 12)
    private String phoneNumber;
    @Basic
    @Column(name = "address", nullable = false, length = 255)
    private String address;
    @OneToMany(mappedBy = "transportCompanyByTransportCompanyId")
    private Collection<TransportCompanyTransport> transportCompanyTransportsById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportCompany that = (TransportCompany) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, address);
    }

    public Collection<TransportCompanyTransport> getTransportCompanyTransportsById() {
        return transportCompanyTransportsById;
    }

    public void setTransportCompanyTransportsById(Collection<TransportCompanyTransport> transportCompanyTransportsById) {
        this.transportCompanyTransportsById = transportCompanyTransportsById;
    }
}
