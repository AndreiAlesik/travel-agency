package com.example.travelagency.service.language;

import com.example.travelagency.domain.Language;


import java.util.List;

public interface LanguageService {
    Language create(Language language);

    List<Language> getAll();

    void delete(Integer id);

    Language updateById(Integer id, Language language);

    Language getById(Integer id);
}
