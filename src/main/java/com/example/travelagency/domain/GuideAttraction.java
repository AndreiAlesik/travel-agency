package com.example.travelagency.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "guide_attraction", schema = "public", catalog = "database")
public class GuideAttraction {
    @Basic
    @Column(name = "guide_id", nullable = false, insertable=false, updatable=false)
    private Long guideId;
    @Basic
    @Column(name = "attraction_id", nullable = false, insertable=false, updatable=false)
    private Long attractionId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "guide_id", referencedColumnName = "id", nullable = false)
    private Guide guideByGuideId;
    @ManyToOne
    @JoinColumn(name = "attraction_id", referencedColumnName = "id", nullable = false)
    private Attraction attractionByAttractionId;

    public Long getGuideId() {
        return guideId;
    }

    public void setGuideId(Long guideId) {
        this.guideId = guideId;
    }

    public Long getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(Long attractionId) {
        this.attractionId = attractionId;
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
        GuideAttraction that = (GuideAttraction) o;
        return Objects.equals(guideId, that.guideId) && Objects.equals(attractionId, that.attractionId) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guideId, attractionId, id);
    }

    public Guide getGuideByGuideId() {
        return guideByGuideId;
    }

    public void setGuideByGuideId(Guide guideByGuideId) {
        this.guideByGuideId = guideByGuideId;
    }

    public Attraction getAttractionByAttractionId() {
        return attractionByAttractionId;
    }

    public void setAttractionByAttractionId(Attraction attractionByAttractionId) {
        this.attractionByAttractionId = attractionByAttractionId;
    }
}
