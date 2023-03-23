package com.example.travelagency.domain;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    @Column(name = "surename", nullable = false)
    private String surename;
    @Basic
    @Column(name = "phone_number", nullable = false, length = 12)
    private String phoneNumber;
    @Basic
    @Column(name = "address", nullable = false)
    private String address;
    @OneToMany(mappedBy = "employeeByEmployeeId")
    private Collection<EmployeeTravel> employeeTravelsById;
    @OneToMany(mappedBy = "employeeByEmployeeId")
    private Collection<LanguageEmployee> languageEmployeesById;

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

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(surename, employee.surename) && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(address, employee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surename, phoneNumber, address);
    }

    public Collection<EmployeeTravel> getEmployeeTravelsById() {
        return employeeTravelsById;
    }

    public void setEmployeeTravelsById(Collection<EmployeeTravel> employeeTravelsById) {
        this.employeeTravelsById = employeeTravelsById;
    }

    public Collection<LanguageEmployee> getLanguageEmployeesById() {
        return languageEmployeesById;
    }

    public void setLanguageEmployeesById(Collection<LanguageEmployee> languageEmployeesById) {
        this.languageEmployeesById = languageEmployeesById;
    }
}
