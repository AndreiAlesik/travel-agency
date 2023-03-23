package com.example.travelagency.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "accommodation_travel", schema = "public", catalog = "database")
public class AccommodationTravel {
    @Basic
    @Column(name = "accommodation_id", nullable = false, insertable=false, updatable=false)
    private Long accommodationId;
    @Basic
    @Column(name = "travel_travel_id", nullable = false, insertable=false, updatable=false)
    private Long travelTravelId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "accommodation_id", referencedColumnName = "id", nullable = false)
    private Accommodation accommodationByAccommodationId;
    @ManyToOne
    @JoinColumn(name = "travel_travel_id", referencedColumnName = "travel_id", nullable = false)
    private Travel travelByTravelTravelId;


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
        AccommodationTravel that = (AccommodationTravel) o;
        return Objects.equals(accommodationId, that.accommodationId) && Objects.equals(travelTravelId, that.travelTravelId) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accommodationId, travelTravelId, id);
    }


}
