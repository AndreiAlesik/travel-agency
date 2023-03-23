package com.example.travelagency.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "travel_stage", schema = "public", catalog = "database")
public class TravelStage {
    @Basic
    @Column(name = "travel_travel_id", nullable = false, insertable = false, updatable = false)
    private Long travelTravelId;
    @Basic
    @Column(name = "stage_id", nullable = false, insertable = false, updatable = false)
    private Long stageId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "travel_travel_id", referencedColumnName = "travel_id", nullable = false)
    private Travel travelByTravelTravelId;
    @ManyToOne
    @JoinColumn(name = "stage_id", referencedColumnName = "id", nullable = false)
    private Stage stageByStageId;

    public Long getTravelTravelId() {
        return travelTravelId;
    }

    public void setTravelTravelId(Long travelTravelId) {
        this.travelTravelId = travelTravelId;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
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
        TravelStage that = (TravelStage) o;
        return Objects.equals(travelTravelId, that.travelTravelId) && Objects.equals(stageId, that.stageId) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(travelTravelId, stageId, id);
    }

    public Travel getTravelByTravelTravelId() {
        return travelByTravelTravelId;
    }

    public void setTravelByTravelTravelId(Travel travelByTravelTravelId) {
        this.travelByTravelTravelId = travelByTravelTravelId;
    }

    public Stage getStageByStageId() {
        return stageByStageId;
    }

    public void setStageByStageId(Stage stageByStageId) {
        this.stageByStageId = stageByStageId;
    }
}
