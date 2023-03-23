package com.example.travelagency.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
public class Stage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "start_point", nullable = false, length = 255)
    private String startPoint;
    @Basic
    @Column(name = "end_point", nullable = false, length = 255)
    private String endPoint;
    @Basic
    @Column(name = "price", nullable = false)
    private Long price;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Basic
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @Basic
    @Column(name = "transport_id", nullable = true, insertable = false, updatable = false)
    private Long transportId;
    @ManyToOne
    @JoinColumn(name = "transport_id", referencedColumnName = "id")
    private Transport transportByTransportId;
    @OneToMany(mappedBy = "stageByStageId")
    private Collection<TravelStage> travelStagesById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTransportId() {
        return transportId;
    }

    public void setTransportId(Long transportId) {
        this.transportId = transportId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stage stage = (Stage) o;
        return Objects.equals(id, stage.id) && Objects.equals(startPoint, stage.startPoint) && Objects.equals(endPoint, stage.endPoint) && Objects.equals(price, stage.price) && Objects.equals(startDate, stage.startDate) && Objects.equals(endDate, stage.endDate) && Objects.equals(transportId, stage.transportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startPoint, endPoint, price, startDate, endDate, transportId);
    }

    public Transport getTransportByTransportId() {
        return transportByTransportId;
    }

    public void setTransportByTransportId(Transport transportByTransportId) {
        this.transportByTransportId = transportByTransportId;
    }

    public Collection<TravelStage> getTravelStagesById() {
        return travelStagesById;
    }

    public void setTravelStagesById(Collection<TravelStage> travelStagesById) {
        this.travelStagesById = travelStagesById;
    }
}
