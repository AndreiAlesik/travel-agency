package com.example.travelagency.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Accommodation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    @Column(name = "price")
    private Long price;
    @Basic
    @Column(name = "sleeping_places_number")
    private Long sleepingPlacesNumber;
    @Basic
    @Column(name = "standard_zakwaterowania", nullable = false)
    private String standardZakwaterowania;
    @Basic
    @Column(name = "adres", nullable = false)
    private String adres;
    @OneToMany(mappedBy = "accommodationByAccommodationId")
    private Collection<AccommodationTravel> accommodationTravelsById;



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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accommodation that = (Accommodation) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(sleepingPlacesNumber, that.sleepingPlacesNumber) && Objects.equals(standardZakwaterowania, that.standardZakwaterowania) && Objects.equals(adres, that.adres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, sleepingPlacesNumber, standardZakwaterowania, adres);
    }



}
