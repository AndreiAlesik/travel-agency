package com.example.travelagency.service.accommodation;

import com.example.travelagency.domain.Accommodation;

import java.util.List;

public interface AccommodationService {
    Accommodation create(Accommodation accommodation);

    List<Accommodation> getAll();

    void delete(Integer id);

    Accommodation updateById(Integer id, Accommodation accommodation);

    Accommodation getById(Integer id);
}
