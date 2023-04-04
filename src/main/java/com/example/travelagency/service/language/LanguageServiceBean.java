package com.example.travelagency.service.language;


import com.example.travelagency.domain.Language;
import com.example.travelagency.dto.language.LanguageRequestDTO;
import com.example.travelagency.dto.language.LanguageResponseDTO;
import com.example.travelagency.repository.LanguageRepository;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;
import com.example.travelagency.util.mapstruct.LanguageMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class LanguageServiceBean implements LanguageService {
    private final LanguageMapper languageMapper;
    private final LanguageRepository languageRepository;

    public LanguageResponseDTO create(LanguageRequestDTO languageRequestDTO) {
        log.debug("LanguageService ==> create() - start: language = {}", languageRequestDTO);
        var languageCreated =
                languageRepository.save(
                        languageMapper.requestDTOToLanguage(languageRequestDTO));
        var languageResponseDTO = languageMapper.languageToResponseDTO(languageCreated);
        log.debug("LanguageService ==> create() - end: languageResponse = {}", languageResponseDTO);
        return languageResponseDTO;
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


    public LanguageResponseDTO updateById(Integer id, LanguageRequestDTO languageRequestDTO) {
        log.debug("LanguageService ==> updateById() - start: id = {}, languageRequest = {}",
                id, languageRequestDTO);
        var languageToUpdate = languageMapper.requestDTOToLanguage(languageRequestDTO);
        try {
            return languageRepository.findById(id)
                    .map(entity -> {
                        entity.setName(languageToUpdate.getName());
                        entity.setCode(languageToUpdate.getCode());
                        log.debug("LanguageService ==> updateById() - end: languageToUpdate = {}", entity);
                        return languageMapper.languageToResponseDTO(languageRepository.save(entity));
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Language not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public LanguageResponseDTO getById(Integer id) {
        log.debug("LanguageService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var language = languageRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        var languageResponseDTO = languageMapper.languageToResponseDTO(language);
        log.debug("LanguageService ==> getById() - end: guide = {}", languageResponseDTO);
        return languageResponseDTO;
    }
}
