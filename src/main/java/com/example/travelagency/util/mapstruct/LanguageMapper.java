package com.example.travelagency.util.mapstruct;

import com.example.travelagency.domain.Language;
import com.example.travelagency.dto.language.LanguageRequestDTO;
import com.example.travelagency.dto.language.LanguageResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    Language requestDTOToLanguage(LanguageRequestDTO languageRequestDTO);

    LanguageResponseDTO languageToResponseDTO(Language language);
}
