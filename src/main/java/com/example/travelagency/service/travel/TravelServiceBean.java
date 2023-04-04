package com.example.travelagency.service.travel;


import com.example.travelagency.domain.Travel;
import com.example.travelagency.dto.travel.TravelRequestDTO;
import com.example.travelagency.dto.travel.TravelResponseDTO;
import com.example.travelagency.repository.TravelRepository;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;
import com.example.travelagency.util.mapstruct.TravelMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class TravelServiceBean implements TravelService {

    private final TravelMapper travelMapper;
    private final TravelRepository travelRepository;

    public TravelResponseDTO create(TravelRequestDTO travelRequestDTO) {
        log.debug("TravelService ==> create() - start: travel = {}", travelRequestDTO);
        var travelCreated =
                travelRepository.save(
                        travelMapper.requestDTOToTravel(travelRequestDTO));
        var travelResponseDTO = travelMapper.travelToResponseDTO(travelCreated);
        log.debug("TravelService ==> create() - end: travelResponse = {}", travelResponseDTO);
        return travelResponseDTO;
    }

    public List<Travel> getAll() {
        log.debug("TravelService ==> getAll() - start: ");
        try {
            var travelList = travelRepository.findAll();
            log.debug("TravelService ==> getAll() - end: ");
            return travelList;
        } catch (NullPointerException e) {
            throw new ResourceNotFoundException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public void delete(Integer id) {
        log.debug("TravelService ==> removeById() - start: id = {}", id);
        travelRepository.deleteById(id);
        log.debug("TravelService ==> removeById() - end: id = {}", id);
    }


    public TravelResponseDTO updateById(Integer id, TravelRequestDTO travelRequestDTO) {
        log.debug("TravelService ==> updateById() - start: id = {}, travelRequest = {}",
                id, travelRequestDTO);
        var travelToUpdate = travelMapper.requestDTOToTravel(travelRequestDTO);
        try {
            return travelRepository.findById(id)
                    .map(entity -> {
                        entity.setName(travelToUpdate.getName());
                        entity.setStartDate(travelToUpdate.getStartDate());
                        entity.setEndDate(travelToUpdate.getEndDate());
                        entity.setDescription(travelToUpdate.getDescription());
                        entity.setPrice(travelToUpdate.getPrice());
                        log.debug("TravelService ==> updateById() - end: travelToUpdate = {}", entity);
                        return travelMapper.travelToResponseDTO(travelRepository.save(entity));
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Travel not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public TravelResponseDTO getById(Integer id) {
        log.debug("TravelService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var travel = travelRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        var travelResponseDTO = travelMapper.travelToResponseDTO(travel);
        log.debug("TravelService ==> getById() - end: travel = {}", travelResponseDTO);
        return travelResponseDTO;
    }
}
