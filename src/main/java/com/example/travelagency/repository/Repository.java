package com.example.travelagency.repository;


import com.example.travelagency.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Customer, Integer> {
//    @Query(value = "select * from customer", nativeQuery = true)
//    List<CustomerEntity> findAll();




}
