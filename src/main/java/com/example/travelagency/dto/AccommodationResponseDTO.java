package com.example.travelagency.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AccommodationResponseDTO {
    @Schema(description = "Name of an accommodation.", example = "Hostel", required = true)
    private String name;

    @Schema(description = "Accommodation Standard.", example = "1 or 5 stars", required = true)
    private String accommodationStandard;
    @Schema(description = "Address.", example = "street smth", required = true)
    private String address;

    @Schema(description = "Price.", example = "1000", required = true)
    private Long price;

    @Schema(description = "Sleeping Places number.", example = "100", required = true)
    private Long sleepingPlacesNumber;
}
