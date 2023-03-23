package com.example.travelagency.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
public class Travel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "travel_id", nullable = false)
    private Long travelId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Basic
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @Basic
    @Column(name = "description", nullable = true, length = 1000)
    private String description;
    @Basic
    @Column(name = "price", nullable = false)
    private Long price;
    @OneToMany(mappedBy = "travelByTravelTravelId")
    private Collection<AccommodationTravel> accommodationTravelsByTravelId;
    @OneToMany(mappedBy = "travelByTravelTravelId")
    private Collection<AttractionTravel> attractionTravelsByTravelId;
    @OneToMany(mappedBy = "travelByTravelTravelId")
    private Collection<EmployeeTravel> employeeTravelsByTravelId;
    @OneToMany(mappedBy = "travelByTravelTravelId")
    private Collection<TravelCustomer> travelCustomersByTravelId;
    @OneToMany(mappedBy = "travelByTravelTravelId")
    private Collection<TravelStage> travelStagesByTravelId;

    public Long getTravelId() {
        return travelId;
    }

    public void setTravelId(Long travelId) {
        this.travelId = travelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travel travel = (Travel) o;
        return Objects.equals(travelId, travel.travelId) && Objects.equals(name, travel.name) && Objects.equals(startDate, travel.startDate) && Objects.equals(endDate, travel.endDate) && Objects.equals(description, travel.description) && Objects.equals(price, travel.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(travelId, name, startDate, endDate, description, price);
    }

    public Collection<AccommodationTravel> getAccommodationTravelsByTravelId() {
        return accommodationTravelsByTravelId;
    }

    public void setAccommodationTravelsByTravelId(Collection<AccommodationTravel> accommodationTravelsByTravelId) {
        this.accommodationTravelsByTravelId = accommodationTravelsByTravelId;
    }

    public Collection<AttractionTravel> getAttractionTravelsByTravelId() {
        return attractionTravelsByTravelId;
    }

    public void setAttractionTravelsByTravelId(Collection<AttractionTravel> attractionTravelsByTravelId) {
        this.attractionTravelsByTravelId = attractionTravelsByTravelId;
    }

    public Collection<EmployeeTravel> getEmployeeTravelsByTravelId() {
        return employeeTravelsByTravelId;
    }

    public void setEmployeeTravelsByTravelId(Collection<EmployeeTravel> employeeTravelsByTravelId) {
        this.employeeTravelsByTravelId = employeeTravelsByTravelId;
    }

    public Collection<TravelCustomer> getTravelCustomersByTravelId() {
        return travelCustomersByTravelId;
    }

    public void setTravelCustomersByTravelId(Collection<TravelCustomer> travelCustomersByTravelId) {
        this.travelCustomersByTravelId = travelCustomersByTravelId;
    }

    public Collection<TravelStage> getTravelStagesByTravelId() {
        return travelStagesByTravelId;
    }

    public void setTravelStagesByTravelId(Collection<TravelStage> travelStagesByTravelId) {
        this.travelStagesByTravelId = travelStagesByTravelId;
    }
}
