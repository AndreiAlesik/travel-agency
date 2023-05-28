package com.example.travelagency.web.customer;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.dto.ResponseObject;
import com.example.travelagency.dto.customer.CustomerRequestDTO;
import com.example.travelagency.service.customer.CustomerService;
import com.example.travelagency.util.mapstruct.CustomerMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@AllArgsConstructor
public class CustomerControllerBean implements CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;


    @Override
    public ResponseObject<String> createCustomer(CustomerRequestDTO customerRequestDTO) {
        log.info("CustomerController ==> createCustomer() - start: customer = {}", customerRequestDTO);

        var newCustomer = customerService.create(customerMapper.customerDTOToCustomer(customerRequestDTO));
        log.info("CustomerController ==> createCustomer() - end: customer = {}", newCustomer);
        return newCustomer;
    }

    @Override
    public ResponseObject<List<Customer>> getAllCustomers() {
        log.info("CustomerController ==> getAllCustomers() - start: ");
        List<Customer> customers = customerService.getAll();
        log.info("CustomerController ==> getAllCustomers() - end: customers = {}", customers);
        return ResponseObject.<List<Customer>>builder()
                .status(HttpStatus.OK)
                .message("OK")
                .result(customers)
                .build();
    }

    @Override
    public ResponseObject<?> updateCustomer(String id, CustomerRequestDTO customerRequestDto) {
        log.info("CustomerController ==> updateCustomer() - start: ");
        var customerToUpdate = customerMapper.customerDTOToCustomer(customerRequestDto);
        var responseObject=customerService.updateById(id, customerToUpdate);
        log.info("CustomerController ==> updateCustomer() - end: response = {}", responseObject);
        return responseObject;
    }

    @Override
    public ResponseObject<Customer> getCustomer(String id) {
        log.info("id = {}", id);
        return customerService.getById(id);
    }

    @Override
    public ResponseObject<String> removeCustomer(String id) {
        customerService.removeByPersonalNumber(id);
        return new ResponseObject<>(HttpStatus.OK,"OK", null);
    }

}