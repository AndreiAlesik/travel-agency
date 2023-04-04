package com.example.travelagency.service.customer;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.dto.customer.CustomerRequestDTO;
import com.example.travelagency.dto.customer.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO create(CustomerRequestDTO customerRequestDTO);

    List<Customer> getAll();

    void delete(Integer id);


    CustomerResponseDTO updateById(Integer id, CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO getById(Integer id);
}
