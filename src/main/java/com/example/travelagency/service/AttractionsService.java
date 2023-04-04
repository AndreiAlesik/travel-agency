package com.example.travelagency.service;

import com.example.travelagency.domain.Accommodation;
import com.example.travelagency.domain.Attraction;
import com.example.travelagency.dto.AttractionRequestDTO;
import com.example.travelagency.dto.AttractionResponseDTO;
import com.example.travelagency.repository.AttractionRepository;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;
import com.example.travelagency.util.mapstruct.AttractionMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class AttractionsService {


    private final AttractionRepository attractionRepository;
    private final AttractionMapper attractionMapper;


    public AttractionResponseDTO create(AttractionRequestDTO attractionRequestDTO) {
        log.debug("AttractionsService ==> create() - start: attractionRequestDTO = {}", attractionRequestDTO);
        var attractionCreated =
                attractionRepository.save(
                        attractionMapper.requestDTOToAttraction(attractionRequestDTO));
        var attractionResponse = attractionMapper.attractionToResponseDTO(attractionCreated);
        log.debug("AttractionsService ==> create() - end: attractionResponse = {}", attractionResponse);
        return attractionResponse;
    }

    public List<Attraction> getAll() {
        log.debug("AttractionsService ==> getAll() - start: ");
        try {
            var allAttractions = attractionRepository.findAll();
            log.debug("AttractionsService ==> getAll() - end: ");
            return allAttractions;
        } catch (NullPointerException e) {
            throw new ResourceNotFoundException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public void delete(Integer id) {
        log.debug("AttractionsService ==> removeById() - start: id = {}", id);
        attractionRepository.deleteById(id);
        log.debug("AttractionsService ==> removeById() - end: id = {}", id);
    }


    public AttractionResponseDTO updateById(Integer id, AttractionRequestDTO attractionRequestDTO) {
        log.debug("AttractionsService ==> updateById() - start: id = {}, attractionRequestDTO = {}",
                id, attractionRequestDTO);
        var attractionToUpdate = attractionMapper.requestDTOToAttraction(attractionRequestDTO);
        try {
            return attractionRepository.findById(id)
                    .map(entity -> {
                        entity.setName(attractionToUpdate.getName());
                        entity.setSeason(attractionToUpdate.getSeason());
                        entity.setDescription(attractionToUpdate.getDescription());
                        entity.setAddress(attractionToUpdate.getAddress());
                        entity.setPrice(attractionToUpdate.getPrice());
                        log.debug("AttractionsService ==> updateById() - end: accommodationToUpdate = {}", entity);
                        return attractionMapper.attractionToResponseDTO(attractionRepository.save(entity));
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public AttractionResponseDTO getById(Integer id) {
        log.debug("AttractionsService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var attraction = attractionRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        var attractionResponseDTO = attractionMapper.attractionToResponseDTO(attraction);
        log.debug("AttractionsService ==> getById() - end: employee = {}", attractionResponseDTO);
        return attractionResponseDTO;
    }
}
