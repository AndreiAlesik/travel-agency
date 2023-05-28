package com.example.travelagency.service.language;

import com.example.travelagency.domain.Language;
import com.example.travelagency.dto.ResponseObject;


import java.util.List;

public interface LanguageService {
    ResponseObject create(Language language);

    List<Language> getAll();

    void delete(Integer id);

    Language updateById(Integer id, Language language);

    Language getById(Integer id);
}
