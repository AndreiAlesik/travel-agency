package com.example.travelagency.repository;

import com.example.travelagency.domain.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GuideRepository extends JpaRepository<Guide, Integer>, JpaSpecificationExecutor<Guide> {

}