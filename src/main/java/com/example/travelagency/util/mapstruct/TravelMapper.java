package com.example.travelagency.util.mapstruct;


import com.example.travelagency.domain.Travel;
import com.example.travelagency.dto.travel.TravelRequestDTO;
import com.example.travelagency.dto.travel.TravelResponseDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TravelMapper {
    Travel requestDTOToTravel(TravelRequestDTO travelRequestDTO);

    TravelResponseDTO travelToResponseDTO(Travel travel);
}
