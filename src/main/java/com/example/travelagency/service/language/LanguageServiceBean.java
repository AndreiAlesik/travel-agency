package com.example.travelagency.service.language;


import com.example.travelagency.domain.Language;
import com.example.travelagency.dto.ResponseObject;
import com.example.travelagency.repository.LanguageRepository;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class LanguageServiceBean implements LanguageService {

    private final LanguageRepository languageRepository;

    public ResponseObject create(Language language) {
        log.debug("LanguageService ==> create() - start: language = {}", language);

        // Check if language code already exists
        if (languageRepository.existsByCode(language.getCode())) {
            return new ResponseObject(HttpStatus.BAD_REQUEST, "Language code already exists", null);
        }

        var languageCreated = languageRepository.save(language);

        log.debug("LanguageService ==> create() - end: languageCreated = {}", languageCreated);

        return new ResponseObject(HttpStatus.CREATED, "Language created successfully", languageCreated);
    }

    public List<Language> getAll() {
        log.debug("LanguageService ==> getAll() - start: ");
        try {
            var languageList = languageRepository.findAll();
            log.debug("LanguageService ==> getAll() - end: ");
            return languageList;
        } catch (NullPointerException e) {
            throw new ResourceNotFoundException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public void delete(Integer id) {
        log.debug("LanguageService ==> removeById() - start: id = {}", id);
        languageRepository.deleteById(id);
        log.debug("LanguageService ==> removeById() - end: id = {}", id);
    }


    public Language updateById(Integer id, Language languageToUpdate) {
        log.debug("LanguageService ==> updateById() - start: id = {}, languageRequest = {}",
                id, languageToUpdate);
        try {
            return languageRepository.findById(id)
                    .map(entity -> {
                        entity.setName(languageToUpdate.getName());
                        entity.setCode(languageToUpdate.getCode());
                        log.debug("LanguageService ==> updateById() - end: languageToUpdate = {}", entity);
                        return languageRepository.save(entity);
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Language not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public Language getById(Integer id) {
        log.debug("LanguageService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var language = languageRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        log.debug("LanguageService ==> getById() - end: guide = {}", language);
        return language;
    }
}
