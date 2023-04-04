package com.example.travelagency.service.guide;

import com.example.travelagency.domain.Guide;
import com.example.travelagency.dto.guide.GuideRequestDTO;
import com.example.travelagency.dto.guide.GuideResponseDTO;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface GuideService {
    GuideResponseDTO create(GuideRequestDTO guideRequestDTO);

    List<Guide> getAll();

    void delete(Integer id);

    GuideResponseDTO updateById(Integer id, GuideRequestDTO guideRequestDTO);

    GuideResponseDTO getById(Integer id);
}
