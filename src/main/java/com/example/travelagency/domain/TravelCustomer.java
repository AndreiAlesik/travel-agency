package com.example.travelagency.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "travel_customer", schema = "public", catalog = "database")
public class TravelCustomer {
    @Basic
    @Column(name = "travel_travel_id", nullable = false, insertable=false, updatable=false)
    private Long travelTravelId;
    @Basic
    @Column(name = "customer_id", nullable = false, insertable=false, updatable=false)
    private Long customerId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "travel_travel_id", referencedColumnName = "travel_id", nullable = false)
    private Travel travelByTravelTravelId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customerByCustomerId;

    public Long getTravelTravelId() {
        return travelTravelId;
    }

    public void setTravelTravelId(Long travelTravelId) {
        this.travelTravelId = travelTravelId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
        TravelCustomer that = (TravelCustomer) o;
        return Objects.equals(travelTravelId, that.travelTravelId) && Objects.equals(customerId, that.customerId) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(travelTravelId, customerId, id);
    }

    public Travel getTravelByTravelTravelId() {
        return travelByTravelTravelId;
    }

    public void setTravelByTravelTravelId(Travel travelByTravelTravelId) {
        this.travelByTravelTravelId = travelByTravelTravelId;
    }

    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }
}
