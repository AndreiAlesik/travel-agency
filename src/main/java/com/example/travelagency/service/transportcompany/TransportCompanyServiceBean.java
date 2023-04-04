package com.example.travelagency.service.transportcompany;

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
    private final TransportCompanyMapper transportCompanyMapper;
    private final TransportCompanyRepository transportCompanyRepository;
    public TransportCompanyResponseDTO create(TransportCompanyRequestDTO transportCompanyRequestDTO) {
        log.debug("TransportCompanyService ==> create() - start: transportCompany = {}", transportCompanyRequestDTO);
        var transportCompanyCreated =
                transportCompanyRepository.save(
                        transportCompanyMapper.requestDTOToTransportCompany(transportCompanyRequestDTO));
        var transportCompanyResponseDTO = transportCompanyMapper.transportCompanyToResponseDTO(transportCompanyCreated);
        log.debug("TransportCompanyService ==> create() - end: transportCompanyResponse = {}", transportCompanyResponseDTO);
        return transportCompanyResponseDTO;
    }

    public List<TransportCompany> getAll() {
        log.debug("TransportCompanyService ==> getAll() - start: ");
        try {
            var transportCompanyList = transportCompanyRepository.findAll();
            log.debug("TransportCompanyService ==> getAll() - end: ");
            return transportCompanyList;
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


    public TransportCompanyResponseDTO updateById(Integer id, TransportCompanyRequestDTO transportCompanyRequestDTO) {
        log.debug("TransportCompanyService ==> updateById() - start: id = {}, transportCompanyRequest = {}",
                id, transportCompanyRequestDTO);
        var transportCompanyToUpdate = transportCompanyMapper.requestDTOToTransportCompany(transportCompanyRequestDTO);
        try {
            return transportCompanyRepository.findById(id)
                    .map(entity -> {
                        entity.setName(transportCompanyToUpdate.getName());
                        entity.setPhoneNumber(transportCompanyToUpdate.getPhoneNumber());
                        entity.setAddress(transportCompanyToUpdate.getAddress());
                        log.debug("TransportCompanyService ==> updateById() - end: transportCompanyToUpdate = {}", entity);
                        return transportCompanyMapper.transportCompanyToResponseDTO(transportCompanyRepository.save(entity));
                    })
                    .orElseThrow(() -> new EntityNotFoundException("TransportCompany not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public TransportCompanyResponseDTO getById(Integer id) {
        log.debug("TransportCompanyService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var transportCompany = transportCompanyRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        var transportCompanyResponseDTO = transportCompanyMapper.transportCompanyToResponseDTO(transportCompany);
        log.debug("TransportCompanyService ==> getById() - end: transportCompany = {}", transportCompanyResponseDTO);
        return transportCompanyResponseDTO;
    }
}
