package com.example.travelagency.service.guide;

import com.example.travelagency.domain.Guide;
import com.example.travelagency.repository.GuideRepository;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;
import com.example.travelagency.util.mapstruct.GuideMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class GuideServiceBean implements GuideService{

    private final GuideRepository guideRepository;

    public Guide create(Guide guide) {
        log.debug("GuideService ==> create() - start: guide = {}", guide);
        var guideCreated =
                guideRepository.save(
                        guide);
        log.debug("GuideService ==> create() - end: guideResponse = {}", guideCreated);
        return guideCreated;
    }

    public List<Guide> getAll() {
        log.debug("GuideService ==> getAll() - start: ");
        try {
            var guideList = guideRepository.findAll();
            log.debug("GuideService ==> getAll() - end: ");
            return guideList;
        } catch (NullPointerException e) {
            throw new ResourceNotFoundException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public void delete(Integer id) {
        log.debug("GuideService ==> removeById() - start: id = {}", id);
        guideRepository.deleteById(id);
        log.debug("GuideService ==> removeById() - end: id = {}", id);
    }


    public Guide updateById(Integer id, Guide guideToUpdate) {
        log.debug("GuideService ==> updateById() - start: id = {}, guideRequest = {}",
                id, guideToUpdate);
        try {
            return guideRepository.findById(id)
                    .map(entity -> {
                        entity.setName(guideToUpdate.getName());
                        entity.setName(guideToUpdate.getName());
                        entity.setPhoneNumber(guideToUpdate.getPhoneNumber());
                        entity.setAddress(guideToUpdate.getAddress());
                        log.debug("GuideService ==> updateById() - end: accommodationToUpdate = {}", entity);
                        return guideRepository.save(entity);
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public Guide getById(Integer id) {
        log.debug("GuideService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var guide = guideRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        log.debug("GuideService ==> getById() - end: guide = {}", guide);
        return guide;
    }
}
