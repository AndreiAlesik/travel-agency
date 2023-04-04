package com.example.travelagency.service.travel;

import com.example.travelagency.domain.Travel;
import com.example.travelagency.dto.travel.TravelRequestDTO;
import com.example.travelagency.dto.travel.TravelResponseDTO;


import java.util.List;

public interface TravelService {
    TravelResponseDTO create(TravelRequestDTO travelRequestDTO);

    List<Travel> getAll();

    void delete(Integer id);

    TravelResponseDTO updateById(Integer id, TravelRequestDTO travelRequestDTO);

    TravelResponseDTO getById(Integer id);
}
