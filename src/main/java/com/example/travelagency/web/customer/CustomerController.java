package com.example.travelagency.web.customer;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.dto.ResponseObject;
import com.example.travelagency.dto.customer.CustomerRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "CustomerEntity", description = "CustomerEntity API")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public interface CustomerController {


    @Operation(summary = "This is endpoint to create customer.", description = "Create request to create new customer.", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified customer request not found.")})
    @PostMapping("/push/client")
    @ResponseStatus(HttpStatus.OK)
    ResponseObject<String> createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO);
    @Operation(summary = "This is endpoint to get all customers info.", description = "Create request to get all customers info.", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified customer request not found.")})
    @GetMapping("/getCustomers")
    @ResponseStatus(HttpStatus.OK)
    ResponseObject<List<Customer>> getAllCustomers();

    @Operation(summary = "This is endpoint to update customers info.", description = "Create request to update customers info.", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified customer request not found.")})
    @PutMapping("/update/certain-client/{pesel}")
    @ResponseStatus(HttpStatus.OK)
    ResponseObject<?> updateCustomer(@PathVariable("pesel") String id, @RequestBody CustomerRequestDTO customerRequestDto);



    @Operation(summary = "This is endpoint to get certain customer info.", description = "Create request to get certain customer  info.", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified customer request not found.")})
    @GetMapping("/get/certain-client")
    @ResponseStatus(HttpStatus.OK)
    ResponseObject<Customer> getCustomer(@RequestParam String id);

    @Operation(summary = "This is endpoint to remove certain customer info.", description = "Create request to remove certain customer  info.", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified customer request not found.")})
    @GetMapping("/delete/client/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseObject<String> removeCustomer(@PathVariable String id);
}

