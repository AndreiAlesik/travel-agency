package com.example.travelagency.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class Customer {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "personal_number", nullable = false)
    private String personalNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surename", nullable = false)
    private String surename;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "id_number", nullable = false)
    private String idNumber;

    @Column(name = "is_deleted")
    private Boolean deleted;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    @JsonIgnore
    private Set<Travel> travels=new HashSet<>();

}
