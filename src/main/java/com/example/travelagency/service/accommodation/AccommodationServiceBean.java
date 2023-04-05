package com.example.travelagency.service.accommodation;

import com.example.travelagency.domain.Accommodation;
import com.example.travelagency.repository.AccommodationRepository;
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
public class AccommodationServiceBean implements AccommodationService{

    private final AccommodationRepository accommodationsRepository;

    public Accommodation create(Accommodation accommodation) {
        log.debug("AccommodationService ==> create() - start: accommodation = {}", accommodation);
        var accommodationCreated =
                accommodationsRepository.save(accommodation);
        log.debug("AccommodationService ==> create() - end: accommodationCreated = {}", accommodationCreated);
        return accommodationCreated;
    }

    public List<Accommodation> getAll() {
        log.debug("AccommodationService ==> getAll() - start: ");
        try {
            var allAccommodations = accommodationsRepository.findAll();
            log.debug("AccommodationService ==> getAll() - end: ");
            return allAccommodations;
        } catch (NullPointerException e) {
            throw new ResourceNotFoundException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public void delete(Integer id) {
        log.debug("AccommodationService ==> removeById() - start: id = {}", id);
        accommodationsRepository.deleteById(id);
        log.debug("AccommodationService ==> removeById() - end: id = {}", id);
    }


    public Accommodation updateById(Integer id, Accommodation accommodationToUpdate) {
        log.debug("AccommodationService ==> updateById() - start: id = {}, accommodationToUpdate = {}", id, accommodationToUpdate);
        try {
            return accommodationsRepository.findById(id)
                    .map(entity -> {
                        entity.setName(accommodationToUpdate.getName());
                        entity.setAccommodationStandard(accommodationToUpdate.getAccommodationStandard());
                        entity.setPrice(accommodationToUpdate.getPrice());
                        entity.setAddress(accommodationToUpdate.getAddress());
                        log.debug("AccommodationService ==> updateById() - end: accommodationToUpdate = {}", entity);
                        return accommodationsRepository.save(entity);
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Accommodation not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public Accommodation getById(Integer id) {
        log.debug("AccommodationService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var accommodation = accommodationsRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        log.debug("AccommodationService ==> getById() - end: accommodation = {}", accommodation);
        return accommodation;
    }


}
