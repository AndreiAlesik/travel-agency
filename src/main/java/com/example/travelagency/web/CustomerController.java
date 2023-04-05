package com.example.travelagency.web;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.dto.customer.CustomerRequestDTO;
import com.example.travelagency.dto.customer.CustomerResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CustomerController {
    @Operation(summary = "This is endpoint to get all customers info.", description = "Create request to get all customers info.", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified customer request not found.")})
    @GetMapping("/getCustomers")
    @ResponseStatus(HttpStatus.OK)
    List<Customer> getAllCustomers();

    @Operation(summary = "This is endpoint to update customers info.", description = "Create request to update customers info.", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified customer request not found.")})
    @PutMapping("/updateCustomer")
    @ResponseStatus(HttpStatus.OK)
    void updateCustomer(@RequestParam Integer id,@RequestBody CustomerRequestDTO customerRequestDto);


    @Operation(summary = "This is endpoint to get certain customer info.", description = "Create request to get certain customer  info.", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified customer request not found.")})
    @GetMapping("/getCustomer")
    @ResponseStatus(HttpStatus.OK)
    CustomerResponseDTO getCustomer(@RequestParam Integer id);

    @Operation(summary = "This is endpoint to remove certain customer info.", description = "Create request to remove certain customer  info.", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified customer request not found.")})
    @GetMapping("/removeCustomer")
    @ResponseStatus(HttpStatus.OK)
    void removeCustomer(@RequestParam Integer id);
}

