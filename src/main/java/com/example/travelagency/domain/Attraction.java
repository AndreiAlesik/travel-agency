package com.example.travelagency.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Attraction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "season", nullable = false, length = 255)
    private String season;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "address", nullable = false, length = 255)
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

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getKoszt() {
        return koszt;
    }

    public void setKoszt(Long koszt) {
        this.koszt = koszt;
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

    public Collection<AttractionTravel> getAttractionTravelsById() {
        return attractionTravelsById;
    }

    public void setAttractionTravelsById(Collection<AttractionTravel> attractionTravelsById) {
        this.attractionTravelsById = attractionTravelsById;
    }

    public Collection<GuideAttraction> getGuideAttractionsById() {
        return guideAttractionsById;
    }

    public void setGuideAttractionsById(Collection<GuideAttraction> guideAttractionsById) {
        this.guideAttractionsById = guideAttractionsById;
    }
}
