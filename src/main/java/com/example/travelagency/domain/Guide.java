package com.example.travelagency.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "guides")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class Guide {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surename", nullable = false)
    private String surename;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "guides")
    @JsonIgnore
    private Set<Attraction> attractions=new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "guides")
    @JsonIgnore
    private Set<Language> languages=new HashSet<>();

}
