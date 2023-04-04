package com.example.travelagency.util.mapstruct;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.dto.customer.CustomerRequestDTO;
import com.example.travelagency.dto.customer.CustomerResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer customerDTOToCustomer(CustomerRequestDTO customerRequestDto);
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
}

