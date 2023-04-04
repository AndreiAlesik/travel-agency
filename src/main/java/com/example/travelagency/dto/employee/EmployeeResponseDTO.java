package com.example.travelagency.dto.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class EmployeeResponseDTO {
    @Schema(description = "Name of an employee.", example = "Billy", required = true)
    private String name;
    @Schema(description = "Surname of an employee.", example = "Chilly", required = true)
    private String surname;
    @Schema(description = "Phone number of an employee.", example = "Phone number", required = true)
    private String phoneNumber;
    @Schema(description = "Address of an employee.", example = "Address", required = true)
    private String address;
}
