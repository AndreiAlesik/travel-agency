package com.example.travelagency.repository;

import com.example.travelagency.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccommodationRepository extends JpaRepository<Accommodation, Integer>, JpaSpecificationExecutor<Accommodation> {

}