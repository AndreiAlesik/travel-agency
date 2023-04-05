package com.example.travelagency.service.attraction;

import com.example.travelagency.domain.Attraction;
import com.example.travelagency.repository.AttractionRepository;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class AttractionsServiceBean implements AttractionService{


    private final AttractionRepository attractionRepository;


    public Attraction create(Attraction attraction) {
        log.debug("AttractionsService ==> create() - start: attraction = {}", attraction);
        var attractionCreated =
                attractionRepository.save(
                        attraction);
        log.debug("AttractionsService ==> create() - end: attractionCreated = {}", attractionCreated);
        return attractionCreated;
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


    public Attraction updateById(Integer id, Attraction attractionToUpdate) {
        log.debug("AttractionsService ==> updateById() - start: id = {}, attractionRequestDTO = {}",
                id, attractionToUpdate);
        try {
            return attractionRepository.findById(id)
                    .map(entity -> {
                        entity.setName(attractionToUpdate.getName());
                        entity.setSeason(attractionToUpdate.getSeason());
                        entity.setDescription(attractionToUpdate.getDescription());
                        entity.setAddress(attractionToUpdate.getAddress());
                        entity.setPrice(attractionToUpdate.getPrice());
                        log.debug("AttractionsService ==> updateById() - end: accommodationToUpdate = {}", entity);
                        return attractionRepository.save(entity);
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public Attraction getById(Integer id) {
        log.debug("AttractionsService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var attraction = attractionRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        log.debug("AttractionsService ==> getById() - end: attraction = {}", attraction);
        return attraction;
    }
}
