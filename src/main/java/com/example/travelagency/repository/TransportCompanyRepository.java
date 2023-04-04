package com.example.travelagency.repository;

import com.example.travelagency.domain.TransportCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransportCompanyRepository extends JpaRepository<TransportCompany, Integer>, JpaSpecificationExecutor<TransportCompany> {

}