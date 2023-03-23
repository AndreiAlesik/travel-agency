package com.example.travelagency.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "employee_travel", schema = "public", catalog = "database")
public class EmployeeTravel {
    @Basic
    @Column(name = "employee_id", nullable = false, insertable=false, updatable=false)
    private Long employeeId;
    @Basic
    @Column(name = "travel_travel_id", nullable = false, insertable=false, updatable=false)
    private Long travelTravelId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employeeByEmployeeId;
    @ManyToOne
    @JoinColumn(name = "travel_travel_id", referencedColumnName = "travel_id", nullable = false)
    private Travel travelByTravelTravelId;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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
        EmployeeTravel that = (EmployeeTravel) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(travelTravelId, that.travelTravelId) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, travelTravelId, id);
    }

    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    public Travel getTravelByTravelTravelId() {
        return travelByTravelTravelId;
    }

    public void setTravelByTravelTravelId(Travel travelByTravelTravelId) {
        this.travelByTravelTravelId = travelByTravelTravelId;
    }
}
