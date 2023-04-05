package com.example.travelagency.service.attraction;

import com.example.travelagency.domain.Attraction;

import java.util.List;

public interface AttractionService {
    Attraction create(Attraction attraction);

    List<Attraction> getAll();

    void delete(Integer id);

    Attraction updateById(Integer id, Attraction attraction);

    Attraction getById(Integer id);
}
