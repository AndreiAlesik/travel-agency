package com.example.travelagency.dto.transportcompany;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TransportCompanyRequestDTO {
    @NotNull
    @Schema(description = "Address of a transport company.", example = "address")
    private String address;
    @NotNull
    @Schema(description = "Name of a transport company.", example = "name")
    private String name;
    @NotNull
    @Schema(description = "Phone number of a transport company.", example = "+12345678")
    private String phoneNumber;

}
