package com.example.travelagency.web.language;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.dto.ResponseObject;
import com.example.travelagency.dto.language.LanguageRequestDTO;
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
public interface LanguageController {
    @Operation(summary = "This is endpoint to get all customers info.", description = "Create request to get all customers info.", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified customer request not found.")})
    @GetMapping("/get/all_languages")
    @ResponseStatus(HttpStatus.OK)
    ResponseObject getAllLanguages();

    @Operation(summary = "This is endpoint to get all customers info.", description = "Create request to get all customers info.", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified customer request not found.")})
    @PostMapping("/push/language")
    @ResponseStatus(HttpStatus.OK)
    ResponseObject createLanguage(@RequestBody LanguageRequestDTO languageRequestDTO);

    @Operation(summary = "This is endpoint to get all customers info.", description = "Create request to get all customers info.", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified customer request not found.")})
    @PostMapping("/delete/language")
    @ResponseStatus(HttpStatus.OK)
    ResponseObject removeLanguage(@RequestParam Integer id);
}
