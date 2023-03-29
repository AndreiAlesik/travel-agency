package com.example.travelagency.web;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.dto.CustomerDto;
import com.example.travelagency.dto.CustomerResponseGet;
import com.example.travelagency.service.Service;
import com.example.travelagency.util.mapstruct.CustomerMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@Tag(name = "CustomerEntity", description = "CustomerEntity API")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerControllerBean implements CustomerController{
    private final Service service;
    private final CustomerMapper customerMapper;
    @GetMapping("/getCustomers")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Customer> getAllCustomers() {
        return service.getAll();
    }

    @Override
    @PutMapping("/updateCustomer")
    public void updateCustomer(Integer id, CustomerDto customerDto) {
        service.updateById(id , customerMapper.customerDtoToCustomer(customerDto));
    }
    @Override
    @GetMapping("/getCustomer")
    public CustomerResponseGet getCustomer(Integer id){
        return customerMapper.customerToCustomerResponseGet(service.getCustomerGetById(id));
    }

    @Override
    public void removeCustomer(Integer id) {
        service.removeById(id);
    }

}