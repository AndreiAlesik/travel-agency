package com.example.travelagency.util.mapstruct;

import com.example.travelagency.domain.Accommodation;
import com.example.travelagency.domain.Customer;
import com.example.travelagency.dto.AccommodationRequestDTO;
import com.example.travelagency.dto.AccommodationResponseDTO;
import com.example.travelagency.dto.CustomerResponseGet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccommodationMapper {
    AccommodationResponseDTO accommodationToResponseDto(Accommodation accommodation);
    Accommodation requestDtoToAccommodation(AccommodationRequestDTO accommodationRequestDTO);

}
