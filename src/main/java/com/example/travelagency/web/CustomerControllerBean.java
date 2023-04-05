package com.example.travelagency.web;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.dto.customer.CustomerRequestDTO;
import com.example.travelagency.dto.customer.CustomerResponseDTO;
import com.example.travelagency.service.customer.CustomerService;
import com.example.travelagency.util.mapstruct.CustomerMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@Tag(name = "CustomerEntity", description = "CustomerEntity API")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerControllerBean implements CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;


    @Override
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @Override
    public void updateCustomer(Integer id, CustomerRequestDTO customerRequestDto) {
        var customerToUpdate=customerMapper.customerDTOToCustomer(customerRequestDto);
        customerService.updateById(id, customerToUpdate);
    }

    @Override
    public CustomerResponseDTO getCustomer(Integer id) {
        return customerMapper
                .customerToCustomerResponseDTO(
                        customerService.getById(id));
    }

    @Override
    public void removeCustomer(Integer id) {
        customerService.delete(id);
    }

}