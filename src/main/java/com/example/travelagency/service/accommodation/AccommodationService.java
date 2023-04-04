package com.example.travelagency.service.accommodation;

import com.example.travelagency.domain.Accommodation;
import com.example.travelagency.dto.accommodation.AccommodationRequestDTO;
import com.example.travelagency.dto.accommodation.AccommodationResponseDTO;

import java.util.List;

public interface AccommodationService {
    AccommodationResponseDTO create(AccommodationRequestDTO accommodationRequestDTO);

    List<Accommodation> getAll();

    void delete(Integer id);

    AccommodationResponseDTO updateById(Integer id, AccommodationRequestDTO accommodationRequestDTO);

    AccommodationResponseDTO getById(Integer id);
}
