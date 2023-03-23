package com.example.travelagency.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Guide {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "surename", nullable = false, length = 255)
    private String surename;
    @Basic
    @Column(name = "address", nullable = false, length = 255)
    private String address;
    @Basic
    @Column(name = "phone_number", nullable = false, length = 12)
    private String phoneNumber;
    @OneToMany(mappedBy = "guideByGuideId")
    private Collection<GuideAttraction> guideAttractionsById;
    @OneToMany(mappedBy = "guideByGuideId")
    private Collection<GuideLanguage> guideLanguagesById;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guide guide = (Guide) o;
        return Objects.equals(id, guide.id) && Objects.equals(name, guide.name) && Objects.equals(surename, guide.surename) && Objects.equals(address, guide.address) && Objects.equals(phoneNumber, guide.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surename, address, phoneNumber);
    }

    public Collection<GuideAttraction> getGuideAttractionsById() {
        return guideAttractionsById;
    }

    public void setGuideAttractionsById(Collection<GuideAttraction> guideAttractionsById) {
        this.guideAttractionsById = guideAttractionsById;
    }

    public Collection<GuideLanguage> getGuideLanguagesById() {
        return guideLanguagesById;
    }

    public void setGuideLanguagesById(Collection<GuideLanguage> guideLanguagesById) {
        this.guideLanguagesById = guideLanguagesById;
    }
}
