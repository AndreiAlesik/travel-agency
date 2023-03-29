package com.example.travelagency.service;

import com.example.travelagency.domain.Customer;

import java.util.List;

public interface Service {
    Customer create(Customer customer);

    List<Customer> getAll();

    Customer updateById(Integer id, Customer customer);

    Customer removeById(Integer id);

    Customer getCustomerGetById(Integer id);

}

