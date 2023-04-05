package com.example.travelagency.service.transport;

import com.example.travelagency.domain.Transport;
import com.example.travelagency.repository.TransportRepository;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;
import com.example.travelagency.util.mapstruct.TransportMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class TransportServiceBean implements TransportService{


    private final TransportRepository transportRepository;

    public Transport create(Transport transportRequestDTO) {
        log.debug("TransportService ==> create() - start: transport = {}", transportRequestDTO);
        var transportCreated =
                transportRepository.save(
                        transportRequestDTO);
        log.debug("TransportService ==> create() - end: transportResponse = {}", transportCreated);
        return transportCreated;
    }

    public List<Transport> getAll() {
        log.debug("TransportService ==> getAll() - start: ");
        try {
            var transportList = transportRepository.findAll();
            log.debug("TransportService ==> getAll() - end: ");
            return transportList;
        } catch (NullPointerException e) {
            throw new ResourceNotFoundException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public void delete(Integer id) {
        log.debug("TransportService ==> removeById() - start: id = {}", id);
        transportRepository.deleteById(id);
        log.debug("TransportService ==> removeById() - end: id = {}", id);
    }


    public Transport updateById(Integer id, Transport transportToUpdate) {
        log.debug("TransportService ==> updateById() - start: id = {}, transportRequest = {}",
                id, transportToUpdate);
        try {
            return transportRepository.findById(id)
                    .map(entity -> {
                        entity.setName(transportToUpdate.getName());
                        entity.setUnitsNumber(transportToUpdate.getUnitsNumber());
                        entity.setSeatsNumber(transportToUpdate.getSeatsNumber());
                        log.debug("TransportService ==> updateById() - end: transportToUpdate = {}", entity);
                        return transportRepository.save(entity);
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Transport not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public Transport getById(Integer id) {
        log.debug("TransportService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var transport = transportRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        log.debug("TransportService ==> getById() - end: transport = {}", transport);
        return transport;
    }
}
