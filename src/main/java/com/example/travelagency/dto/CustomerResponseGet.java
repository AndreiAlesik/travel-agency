package com.example.travelagency.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class CustomerResponseGet {
    @Valid
    @NotNull
    @Schema(description = "Name of an customer.", example = "Billy", required = true)
    private String name;

    @Schema(description = "Surename of an customer.", example = "Smith", required = true)
    private String surename;

    @Schema(description = "Address of an customer.", example = "Little George St, London SW1P 3BD, Great Britain", required = true)
    private String address;

    @Schema(description = "Phone number of an customer.", example = "+1234545678", required = true)
    private String phoneNumber;

    @Schema(description = "Date of birth of an customer.", example = "10-10-1990", required = true)
    private Date dateOfBirth;
}
