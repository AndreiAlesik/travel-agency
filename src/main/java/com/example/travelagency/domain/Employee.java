package com.example.travelagency.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class Employee {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    @JsonIgnore
    private Set<Travel> travels = new HashSet<>();
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    @JsonIgnore
    private Set<Language> languages = new HashSet<>();


}
