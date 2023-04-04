package com.example.travelagency.service.accommodation;

import com.example.travelagency.domain.Accommodation;
import com.example.travelagency.dto.accommodation.AccommodationRequestDTO;
import com.example.travelagency.dto.accommodation.AccommodationResponseDTO;
import com.example.travelagency.repository.AccommodationRepository;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;
import com.example.travelagency.util.mapstruct.AccommodationMapper;
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
    private final AccommodationMapper accommodationMapper;

    public AccommodationResponseDTO create(AccommodationRequestDTO accommodationRequestDTO) {
        log.debug("AccommodationService ==> create() - start: accommodationRequestDTO = {}", accommodationRequestDTO);
        var accommodationCreated =
                accommodationsRepository.save(
                        accommodationMapper.requestDtoToAccommodation(accommodationRequestDTO));
        var accommodationResponse = accommodationMapper.accommodationToResponseDto(accommodationCreated);
        log.debug("AccommodationService ==> create() - end: accommodationResponse = {}", accommodationResponse);
        return accommodationResponse;
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


    public AccommodationResponseDTO updateById(Integer id, AccommodationRequestDTO accommodationRequestDTO) {
        log.debug("AccommodationService ==> updateById() - start: id = {}, accommodationRequestDTO = {}", id, accommodationRequestDTO);
        var accommodationToUpdate = accommodationMapper.requestDtoToAccommodation(accommodationRequestDTO);
        try {
            return accommodationsRepository.findById(id)
                    .map(entity -> {
                        entity.setName(accommodationToUpdate.getName());
                        entity.setAccommodationStandard(accommodationToUpdate.getAccommodationStandard());
                        entity.setPrice(accommodationToUpdate.getPrice());
                        entity.setAddress(accommodationToUpdate.getAddress());
                        log.debug("AccommodationService ==> updateById() - end: accommodationToUpdate = {}", entity);
                        return accommodationMapper.accommodationToResponseDto(accommodationsRepository.save(entity));
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Accommodation not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public AccommodationResponseDTO getById(Integer id) {
        log.debug("AccommodationService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var accommodation = accommodationsRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        var accommodationResponse = accommodationMapper.accommodationToResponseDto(accommodation);
        log.debug("AccommodationService ==> getById() - end: employee = {}", accommodationResponse);
        return accommodationResponse;
    }


}
