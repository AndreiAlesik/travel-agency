package com.example.travelagency.repository;

import com.example.travelagency.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
    List<Customer> findAllByDeletedIsFalse();
    Customer getCustomerByIdAndDeletedIsFalse(Integer id);
}