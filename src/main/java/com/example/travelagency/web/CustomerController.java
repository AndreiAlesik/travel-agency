package com.example.travelagency.web;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.dto.CustomerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;

public interface CustomerController {
    @Operation(summary = "This is endpoint to get all customers info.", description = "Create request to get all customers info.", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified customer request not found.")})
    List<Customer> getAllCustomers();

    @Operation(summary = "This is endpoint to update customers info.", description = "Create request to update customers info.", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified customer request not found.")})
    void updateCustomer(Integer id, CustomerDto customerDto);
}

