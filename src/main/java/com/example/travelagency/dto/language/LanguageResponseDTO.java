package com.example.travelagency.dto.language;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class LanguageResponseDTO {
    @Schema(description = "code of a language.", example = "en", required = true)
    private String code;
    @Schema(description = "name of a language.", example = "english", required = true)
    private String name;
}
