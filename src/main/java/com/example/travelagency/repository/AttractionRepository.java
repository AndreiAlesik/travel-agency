package com.example.travelagency.repository;

import com.example.travelagency.domain.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttractionRepository extends JpaRepository<Attraction, Integer>, JpaSpecificationExecutor<Attraction> {

}