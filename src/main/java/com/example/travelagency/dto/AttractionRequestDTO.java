package com.example.travelagency.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AttractionRequestDTO {
    @Schema(description = "Name of an attraction.", example = "Name", required = true)
    private String name;
    @Schema(description = "Address of an attraction.", example = "address", required = true)
    private String address;
    @Schema(description = "Description of an attraction.", example = "description", required = true)
    private String description;
    @Schema(description = "Season of an attraction.", example = "season", required = true)
    private String season;
    @Schema(description = "Price of an attraction.", example = "price", required = true)
    private Integer price;

}
