package com.example.travelagency.repository;

import com.example.travelagency.domain.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TravelRepository extends JpaRepository<Travel, Integer>, JpaSpecificationExecutor<Travel> {

}