package com.example.travelagency.repository;

import com.example.travelagency.domain.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransportRepository extends JpaRepository<Transport, Integer>, JpaSpecificationExecutor<Transport> {

}