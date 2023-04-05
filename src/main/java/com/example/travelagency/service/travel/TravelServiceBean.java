package com.example.travelagency.service.travel;


import com.example.travelagency.domain.Travel;
import com.example.travelagency.repository.TravelRepository;
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
public class TravelServiceBean implements TravelService {

    private final TravelRepository travelRepository;

    public Travel create(Travel travel) {
        log.debug("TravelService ==> create() - start: travel = {}", travel);
        var travelCreated =travelRepository.save(travel);
        log.debug("TravelService ==> create() - end: travelResponse = {}", travelCreated);
        return travelCreated;
    }

    public List<Travel> getAll() {
        log.debug("TravelService ==> getAll() - start: ");
        try {
            List<Travel> travelList = travelRepository.findAll();
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


    public Travel getById(Integer id) {
        log.debug("TravelService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var travel = travelRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        log.debug("TravelService ==> getById() - end: travel = {}", travel);
        return travel;
    }

    public Travel updateById(Integer id, Travel travel) {
        log.debug("TravelService ==> updateById() - start: id = {}, travel = {}",
                id, travel);
        try {
            return travelRepository.findById(id)
                    .map(entity -> {
                        entity.setName(travel.getName());
                        entity.setStartDate(travel.getStartDate());
                        entity.setEndDate(travel.getEndDate());
                        entity.setDescription(travel.getDescription());
                        entity.setPrice(travel.getPrice());
                        log.debug("TravelService ==> updateById() - end: travel = {}", entity);
                        return travelRepository.save(entity);
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Travel not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }
}
