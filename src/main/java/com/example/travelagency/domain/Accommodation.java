package com.example.travelagency.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Accommodation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "price", nullable = true)
    private Long price;
    @Basic
    @Column(name = "sleeping_places_number", nullable = true)
    private Long sleepingPlacesNumber;
    @Basic
    @Column(name = "standard_zakwaterowania", nullable = false, length = 255)
    private String standardZakwaterowania;
    @Basic
    @Column(name = "adres", nullable = false, length = 255)
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getSleepingPlacesNumber() {
        return sleepingPlacesNumber;
    }

    public void setSleepingPlacesNumber(Long sleepingPlacesNumber) {
        this.sleepingPlacesNumber = sleepingPlacesNumber;
    }

    public String getStandardZakwaterowania() {
        return standardZakwaterowania;
    }

    public void setStandardZakwaterowania(String standardZakwaterowania) {
        this.standardZakwaterowania = standardZakwaterowania;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
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

    public Collection<AccommodationTravel> getAccommodationTravelsById() {
        return accommodationTravelsById;
    }

    public void setAccommodationTravelsById(Collection<AccommodationTravel> accommodationTravelsById) {
        this.accommodationTravelsById = accommodationTravelsById;
    }
}
