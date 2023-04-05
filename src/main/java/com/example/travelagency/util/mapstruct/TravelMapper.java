package com.example.travelagency.util.mapstruct;


import com.example.travelagency.dto.travel.TravelRequestDTO;
import com.example.travelagency.dto.travel.TravelResponseDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TravelMapper {
    com.example.travelagency.domain.Travel requestDTOToTravel(TravelRequestDTO travelRequestDTO);

    TravelResponseDTO travelToResponseDTO(com.example.travelagency.domain.Travel travel);
}
