package com.example.travelagency.repository;


import com.example.travelagency.domain.Customer;
import com.example.travelagency.domain.Employee;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Customer, Integer> {
//    @Query(value = "select * from customer", nativeQuery = true)
//    List<CustomerEntity> findAll();

    Customer getCustomerByIdAndIsDeletedIsFalse(Integer id);

    List<Customer> findAllByIsDeletedIsFalse();


}
