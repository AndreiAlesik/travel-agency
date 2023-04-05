package com.example.travelagency.service.customer;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.dto.customer.CustomerRequestDTO;
import com.example.travelagency.dto.customer.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);

    List<Customer> getAll();

    void delete(Integer id);


    Customer updateById(Integer id, Customer customer);

    Customer getById(Integer id);
}
