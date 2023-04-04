package com.example.travelagency.dto.travel;


import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TravelRequestDTO {
    @Schema(description = "Name of a travel.", example = "travel")
    private String name;
    @Schema(description = "Description of a travel.", example = "Bus")
    private String description;
    @Schema(description = "Start date of a travel.", example = "20-05-2023")
    private OffsetDateTime startDate;
    @Schema(description = "End date of a travel.", example = "20-06-2024")
    private OffsetDateTime endDate;
    @Schema(description = "Price of a travel.", example = "700")
    private Integer price;
}
