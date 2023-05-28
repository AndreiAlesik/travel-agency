package com.example.travelagency.dto.language;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class LanguageRequestDTO {
    @Schema(description = "code of a language.", example = "en", required = true)
    private String code;
    @Schema(description = "name of a language.", example = "english", required = true)
    private String name;

}
