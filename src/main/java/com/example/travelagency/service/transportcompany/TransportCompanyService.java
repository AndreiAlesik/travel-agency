package com.example.travelagency.service.transportcompany;

import com.example.travelagency.domain.TransportCompany;
import com.example.travelagency.dto.transportcompany.TransportCompanyRequestDTO;
import com.example.travelagency.dto.transportcompany.TransportCompanyResponseDTO;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface TransportCompanyService {
    TransportCompany create(TransportCompany transportCompany);
    List<TransportCompany> getAll();
    void delete(Integer id);
    TransportCompany updateById(Integer id, TransportCompany transportCompanyToUpdate);
}
