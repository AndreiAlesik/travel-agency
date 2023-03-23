package com.example.travelagency.domain;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Attraction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    @Column(name = "season", nullable = false)
    private String season;
    @Basic
    @Column(name = "description", length = -1)
    private String description;
    @Basic
    @Column(name = "address", nullable = false)
    private String address;
    @Basic
    @Column(name = "koszt", nullable = false)
    private Long koszt;
    @OneToMany(mappedBy = "attractionByAttractionId")
    private Collection<AttractionTravel> attractionTravelsById;
    @OneToMany(mappedBy = "attractionByAttractionId")
    private Collection<GuideAttraction> guideAttractionsById;

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
        Attraction that = (Attraction) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(season, that.season) && Objects.equals(description, that.description) && Objects.equals(address, that.address) && Objects.equals(koszt, that.koszt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, season, description, address, koszt);
    }


}
