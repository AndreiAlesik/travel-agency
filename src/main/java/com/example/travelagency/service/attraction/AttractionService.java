package com.example.travelagency.service.attraction;

import com.example.travelagency.domain.Attraction;
import com.example.travelagency.dto.attraction.AttractionRequestDTO;
import com.example.travelagency.dto.attraction.AttractionResponseDTO;

import java.util.List;

public interface AttractionService {
    AttractionResponseDTO create(AttractionRequestDTO attractionRequestDTO);

    List<Attraction> getAll();

    void delete(Integer id);

    AttractionResponseDTO updateById(Integer id, AttractionRequestDTO attractionRequestDTO);

    AttractionResponseDTO getById(Integer id);
}
