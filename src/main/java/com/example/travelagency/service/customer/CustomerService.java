package com.example.travelagency.service.customer;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.dto.ResponseObject;
import com.example.travelagency.dto.customer.CustomerRequestDTO;
import com.example.travelagency.dto.customer.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    ResponseObject<String> create(Customer customer);

    List<Customer> getAll();

    void delete(Integer id);


    ResponseObject<?> updateById(String id, Customer customer);

    ResponseObject<Customer> getById(String id);

    ResponseObject<?> removeByPersonalNumber(String personalNumber);
}
