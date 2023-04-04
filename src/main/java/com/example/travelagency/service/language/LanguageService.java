package com.example.travelagency.service.language;

import com.example.travelagency.domain.Language;
import com.example.travelagency.dto.language.LanguageRequestDTO;
import com.example.travelagency.dto.language.LanguageResponseDTO;


import java.util.List;

public interface LanguageService {
    LanguageResponseDTO create(LanguageRequestDTO languageRequestDTO);

    List<Language> getAll();

    void delete(Integer id);

    LanguageResponseDTO updateById(Integer id, LanguageRequestDTO languageRequestDTO);

    LanguageResponseDTO getById(Integer id);
}
