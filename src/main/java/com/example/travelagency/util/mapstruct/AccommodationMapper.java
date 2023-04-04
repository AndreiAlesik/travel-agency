package com.example.travelagency.util.mapstruct;

import com.example.travelagency.domain.Accommodation;
import com.example.travelagency.dto.accommodation.AccommodationRequestDTO;
import com.example.travelagency.dto.accommodation.AccommodationResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccommodationMapper {
    AccommodationResponseDTO accommodationToResponseDto(Accommodation accommodation);
    Accommodation requestDtoToAccommodation(AccommodationRequestDTO accommodationRequestDTO);

}
