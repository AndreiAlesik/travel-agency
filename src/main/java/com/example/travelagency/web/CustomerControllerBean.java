package com.example.travelagency.web;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.service.Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@Tag(name = "CustomerEntity", description = "CustomerEntity API")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerControllerBean implements CustomerController{
    private final Service service;

    @GetMapping("/getAllCustomers")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Customer> getAllCustomers() {
        return service.getAll();
    }

    @Override
    public void updateCustomer(Customer customerEntity) {

    }


}