package com.example.travelagency.service.transportcompany;

import com.example.travelagency.domain.TransportCompany;
import com.example.travelagency.domain.TransportCompany;
import com.example.travelagency.dto.transportcompany.TransportCompanyRequestDTO;
import com.example.travelagency.dto.transportcompany.TransportCompanyResponseDTO;
import com.example.travelagency.repository.TransportCompanyRepository;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;
import com.example.travelagency.util.mapstruct.TransportCompanyMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class TransportCompanyServiceBean implements TransportCompanyService{

    private final TransportCompanyRepository transportCompanyRepository;


    public TransportCompany create(TransportCompany transportCompany) {
        log.debug("TransportCompanyService ==> create() - start: travel = {}", transportCompany);
        var travelCreated =transportCompanyRepository.save(transportCompany);
        log.debug("TransportCompanyService ==> create() - end: travelResponse = {}", travelCreated);
        return travelCreated;
    }

    public List<TransportCompany> getAll() {
        log.debug("TransportCompanyService ==> getAll() - start: ");
        try {
            List<TransportCompany> travelList = transportCompanyRepository.findAll();
            log.debug("TransportCompanyService ==> getAll() - end: ");
            return travelList;
        } catch (NullPointerException e) {
            throw new ResourceNotFoundException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public void delete(Integer id) {
        log.debug("TransportCompanyService ==> removeById() - start: id = {}", id);
        transportCompanyRepository.deleteById(id);
        log.debug("TransportCompanyService ==> removeById() - end: id = {}", id);
    }


    public TransportCompany getById(Integer id) {
        log.debug("TransportCompanyService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var transportCompany = transportCompanyRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        log.debug("TransportCompanyService ==> getById() - end: transportCompany = {}", transportCompany);
        return transportCompany;
    }
    public TransportCompany updateById(Integer id, TransportCompany transportCompanyToUpdate) {
        log.debug("TransportCompanyService ==> updateById() - start: id = {}, transportCompanyToUpdate = {}",
                id, transportCompanyToUpdate);

        try {
            return transportCompanyRepository.findById(id)
                    .map(entity -> {
                        entity.setName(transportCompanyToUpdate.getName());
                        entity.setPhoneNumber(transportCompanyToUpdate.getPhoneNumber());
                        entity.setAddress(transportCompanyToUpdate.getAddress());
                        log.debug("TransportCompanyService ==> updateById() - end: transportCompanyToUpdate = {}", entity);
                        return transportCompanyRepository.save(entity);
                    })
                    .orElseThrow(() -> new EntityNotFoundException("TransportCompany not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }


}
