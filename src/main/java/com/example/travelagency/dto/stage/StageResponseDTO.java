package com.example.travelagency.dto.stage;

import io.swagger.models.auth.In;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class StageResponseDTO {
    @Schema(description = "Start point of an stage.", example = "London", required = true)
    private String startPoint;

    @Schema(description = "End point of an stage.", example = "Poznan", required = true)
    private String endPoint;

    @Schema(description = "Price of an stage.", example = "200", required = true)
    private Integer price;

    @Schema(description = "Start date of an stage.", example = "10-10-2022", required = true)
    private OffsetDateTime startDate;
    @Schema(description = "End date of an stage.", example = "11-10-2022", required = true)
    private OffsetDateTime endDate;
}
