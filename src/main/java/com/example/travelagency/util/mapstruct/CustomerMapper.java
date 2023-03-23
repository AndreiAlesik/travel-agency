package com.example.travelagency.util.mapstruct;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDto customerToCustomerDto(Customer customerEntity);
    Customer customerDtoToCustomer(CustomerDto customerDto);
}

