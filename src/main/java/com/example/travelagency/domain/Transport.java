package com.example.travelagency.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "transports")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class Transport {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "units_number", nullable = false)
    private Integer unitsNumber;

    @Column(name = "seats_number", nullable = false)
    private Integer seatsNumber;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "transports")
    @JsonIgnore
    private Set<TransportCompany> transportCompanies=new HashSet<>();

}
