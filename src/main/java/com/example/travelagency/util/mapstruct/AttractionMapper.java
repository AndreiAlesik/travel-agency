package com.example.travelagency.util.mapstruct;

import com.example.travelagency.domain.Attraction;
import com.example.travelagency.dto.AttractionRequestDTO;
import com.example.travelagency.dto.AttractionResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttractionMapper {
    Attraction requestDTOToAttraction(AttractionRequestDTO attractionRequestDTO);
    AttractionResponseDTO attractionToResponseDTO(Attraction attraction);
}
