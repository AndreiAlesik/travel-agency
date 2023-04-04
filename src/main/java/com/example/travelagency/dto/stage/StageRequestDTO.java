package com.example.travelagency.dto.stage;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class StageRequestDTO {

    @Schema(description = "Start point of an stage.", example = "London", required = true)
    private String startPoint;

    @Schema(description = "End point of an stage.", example = "Poznan", required = true)
    private String endPoint;

    @Schema(description = "Price of an stage.", example = "200", required = true)
    private Long price;

    @Schema(description = "Start date of an stage.", example = "10-10-2022", required = true)
    private LocalDateTime startDate;
    @Schema(description = "End date of an stage.", example = "11-10-2022", required = true)
    private LocalDateTime endDate;



}
