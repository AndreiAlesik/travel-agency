package com.example.travelagency.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "attraction_travel", schema = "public", catalog = "database")
public class AttractionTravel {
    @Basic
    @Column(name = "attraction_id", nullable = false, insertable=false, updatable=false)
    private Long attractionId;
    @Basic
    @Column(name = "travel_travel_id", nullable = false, insertable=false, updatable=false)
    private Long travelTravelId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "attraction_id", referencedColumnName = "id", nullable = false)
    private Attraction attractionByAttractionId;
    @ManyToOne
    @JoinColumn(name = "travel_travel_id", referencedColumnName = "travel_id", nullable = false)
    private Travel travelByTravelTravelId;

    public Long getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(Long attractionId) {
        this.attractionId = attractionId;
    }

    public Long getTravelTravelId() {
        return travelTravelId;
    }

    public void setTravelTravelId(Long travelTravelId) {
        this.travelTravelId = travelTravelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttractionTravel that = (AttractionTravel) o;
        return Objects.equals(attractionId, that.attractionId) && Objects.equals(travelTravelId, that.travelTravelId) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attractionId, travelTravelId, id);
    }

    public Attraction getAttractionByAttractionId() {
        return attractionByAttractionId;
    }

    public void setAttractionByAttractionId(Attraction attractionByAttractionId) {
        this.attractionByAttractionId = attractionByAttractionId;
    }

    public Travel getTravelByTravelTravelId() {
        return travelByTravelTravelId;
    }

    public void setTravelByTravelTravelId(Travel travelByTravelTravelId) {
        this.travelByTravelTravelId = travelByTravelTravelId;
    }
}
