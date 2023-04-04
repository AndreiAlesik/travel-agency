package com.example.travelagency.dto.guide;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GuideResponseDTO {
    @Schema(description = "Name of an guide.", example = "Billy", required = true)
    private String name;

    @Schema(description = "Surname of an guide.", example = "Chilly", required = true)
    private String surname;

    @Schema(description = "Phone number of an guide.", example = "+123456788", required = true)
    private String phoneNumber;

    @Schema(description = "Address of an guide.", example = "address", required = true)
    private String address;
}
