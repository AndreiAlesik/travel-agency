package com.example.travelagency.service.stage;


import com.example.travelagency.domain.Stage;
import com.example.travelagency.dto.stage.StageRequestDTO;
import com.example.travelagency.domain.Stage;
import com.example.travelagency.repository.StageRepository;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;
import com.example.travelagency.util.mapstruct.StageMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class StageServiceBean {

    private final StageMapper stageMapper;
    private final StageRepository stageRepository;
    public Stage create(StageRequestDTO stageRequestDTO) {
        log.debug("StageService ==> create() - start: stage = {}", stageRequestDTO);
        var stageCreated =
                stageRepository.save(
                        stageMapper.requestDTOToStage(stageRequestDTO));
        log.debug("StageService ==> create() - end: stageResponse = {}", stageCreated);
        return stageCreated;
    }

    public List<Stage> getAll() {
        log.debug("StageService ==> getAll() - start: ");
        try {
            var stageList = stageRepository.findAll();
            log.debug("StageService ==> getAll() - end: ");
            return stageList;
        } catch (NullPointerException e) {
            throw new ResourceNotFoundException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public void delete(Integer id) {
        log.debug("StageService ==> removeById() - start: id = {}", id);
        stageRepository.deleteById(id);
        log.debug("StageService ==> removeById() - end: id = {}", id);
    }


    public Stage updateById(Integer id, Stage stageToUpdate) {
        log.debug("StageService ==> updateById() - start: id = {}, stageToUpdate = {}",
                id, stageToUpdate);

        try {
            return stageRepository.findById(id)
                    .map(entity -> {
                        entity.setStartPoint(stageToUpdate.getStartPoint());
                        entity.setEndPoint(stageToUpdate.getEndPoint());
                        entity.setPrice(stageToUpdate.getPrice());
                        entity.setStartDate(stageToUpdate.getStartDate());
                        entity.setEndDate(stageToUpdate.getEndDate());
                        log.debug("StageService ==> updateById() - end: stageToUpdate = {}", entity);
                        return stageRepository.save(entity);
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Stage not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public Stage getById(Integer id) {
        log.debug("StageService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var stage = stageRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        log.debug("StageService ==> getById() - end: stage = {}", stage);
        return stage;
    }
}
