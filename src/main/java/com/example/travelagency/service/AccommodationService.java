package com.example.travelagency.service;

import com.example.travelagency.domain.Accommodation;
import com.example.travelagency.dto.AccommodationRequestDTO;
import com.example.travelagency.dto.AccommodationResponseDTO;
import com.example.travelagency.repository.AccommodationRepository;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.ResourceWasDeletedException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;
import com.example.travelagency.util.mapstruct.AccommodationMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@AllArgsConstructor
public class AccommodationService {

    private final AccommodationRepository accommodationsRepository;
    private final AccommodationMapper accommodationMapper;

    public AccommodationResponseDTO create(AccommodationRequestDTO accommodationRequestDTO) {
        log.debug("Service ==> create() - start: accommodationRequestDTO = {}", accommodationRequestDTO);
        var accommodationCreated =
                accommodationsRepository.save(
                        accommodationMapper.requestDtoToAccommodation(accommodationRequestDTO));
        var accommodationResponse = accommodationMapper.accommodationToResponseDto(accommodationCreated);
        log.debug("Service ==> create() - end: accommodationResponse = {}", accommodationResponse);
        return accommodationResponse;
    }

    public List<Accommodation> getAll() {
        log.debug("Service ==> getAll() - start: ");
        try {
            var allAccommodations = accommodationsRepository.findAll();
            log.debug("Service ==> getAll() - end: ");
            return allAccommodations;
        } catch (NullPointerException e) {
            throw new ResourceNotFoundException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public void delete(Integer id) {
        log.debug("Service ==> removeById() - start: id = {}", id);
        accommodationsRepository.deleteById(id);
        log.debug("Service ==> removeById() - end: id = {}", id);
    }


    public AccommodationResponseDTO updateById(Integer id, AccommodationRequestDTO accommodationRequestDTO) {
        log.debug("Service ==> updateById() - start: id = {}, accommodationRequestDTO = {}", id, accommodationRequestDTO);
        var accommodationToUpdate = accommodationMapper.requestDtoToAccommodation(accommodationRequestDTO);
        try {
            return accommodationsRepository.findById(id)
                    .map(entity -> {
                        entity.setName(accommodationToUpdate.getName());
                        entity.setAccommodationStandard(accommodationToUpdate.getAccommodationStandard());
                        entity.setPrice(accommodationToUpdate.getPrice());
                        entity.setAddress(accommodationToUpdate.getAddress());
                        log.debug("Service ==> updateById() - end: accommodationToUpdate = {}", entity);
                        return accommodationMapper.accommodationToResponseDto(accommodationsRepository.save(entity));
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public AccommodationResponseDTO getById(Integer id) {
        log.debug("Service ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var accommodation = accommodationsRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        var accommodationResponse = accommodationMapper.accommodationToResponseDto(accommodation);
        log.debug("Service ==> getById() - end: employee = {}", accommodationResponse);
        return accommodationResponse;
    }


}
