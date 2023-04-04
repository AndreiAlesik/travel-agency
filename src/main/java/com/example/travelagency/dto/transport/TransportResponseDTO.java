package com.example.travelagency.dto.transport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TransportResponseDTO {
    @Schema(description = "Name of a transport.", example = "Bus")
    private String name;
    @Schema(description = "Seats number of a transport.", example = "40")
    private Long seatsNumber;
    @Schema(description = "Units number of a transport.", example = "10")
    private Long unitsNumber;
}
