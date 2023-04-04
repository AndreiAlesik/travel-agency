package com.example.travelagency.dto.accommodation;


import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AccommodationRequestDTO {

    @Schema(description = "Name of an accommodation.", example = "Hostel", required = true)
    private String name;

    @Schema(description = "Accommodation Standard.", example = "1 or 5 stars", required = true)
    private String accommodationStandard;
    @Schema(description = "Address.", example = "street smth", required = true)
    private String address;

    @Schema(description = "Price.", example = "1000", required = true)
    private Integer price;

    @Schema(description = "Sleeping Places number.", example = "100", required = true)
    private Integer sleepingPlacesNumber;

}
