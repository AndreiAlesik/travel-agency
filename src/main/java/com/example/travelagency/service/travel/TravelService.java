package com.example.travelagency.service.travel;


import com.example.travelagency.domain.Travel;
import com.example.travelagency.dto.travel.TravelResponseDTO;


import java.util.List;

public interface TravelService {
    Travel create(Travel travel);

    List<Travel> getAll();

    void delete(Integer id);

    Travel updateById(Integer id, Travel travel);

    Travel getById(Integer id);
}
