package com.example.travelagency.domain;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Transport {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "units_number", nullable = false)
    private Long unitsNumber;
    @Basic
    @Column(name = "seats_number", nullable = false)
    private Long seatsNumber;
    @OneToMany(mappedBy = "transportByTransportId")
    private Collection<Stage> stagesById;
    @OneToMany(mappedBy = "transportByTransportId")
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

    public Long getUnitsNumber() {
        return unitsNumber;
    }

    public void setUnitsNumber(Long unitsNumber) {
        this.unitsNumber = unitsNumber;
    }

    public Long getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(Long seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Objects.equals(id, transport.id) && Objects.equals(name, transport.name) && Objects.equals(unitsNumber, transport.unitsNumber) && Objects.equals(seatsNumber, transport.seatsNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, unitsNumber, seatsNumber);
    }

    public Collection<Stage> getStagesById() {
        return stagesById;
    }

    public void setStagesById(Collection<Stage> stagesById) {
        this.stagesById = stagesById;
    }

    public Collection<TransportCompanyTransport> getTransportCompanyTransportsById() {
        return transportCompanyTransportsById;
    }

    public void setTransportCompanyTransportsById(Collection<TransportCompanyTransport> transportCompanyTransportsById) {
        this.transportCompanyTransportsById = transportCompanyTransportsById;
    }
}
