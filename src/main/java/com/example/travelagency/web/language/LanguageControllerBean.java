package com.example.travelagency.web.language;

import com.example.travelagency.dto.ResponseObject;
import com.example.travelagency.dto.language.LanguageRequestDTO;
import com.example.travelagency.service.language.LanguageService;
import com.example.travelagency.util.mapstruct.LanguageMapper;
import com.example.travelagency.web.language.LanguageController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class LanguageControllerBean implements LanguageController {
    private final LanguageService languageService;
    private final LanguageMapper languageMapper;
    @Override
    public ResponseObject getAllLanguages() {
        var allLanguages=languageService.getAll();
        return new ResponseObject(HttpStatus.ACCEPTED, "OK", allLanguages);
    }

    @Override
    public ResponseObject createLanguage(LanguageRequestDTO languageRequestDTO) {
        log.info("language = {}",languageRequestDTO);
        var language=languageService.create(languageMapper.requestDTOToLanguage(languageRequestDTO));
        return language;
    }

    @Override
    public ResponseObject removeLanguage(Integer id) {
        languageService.delete(id);
        return new ResponseObject(HttpStatus.ACCEPTED, "OK", null);
    }
}
