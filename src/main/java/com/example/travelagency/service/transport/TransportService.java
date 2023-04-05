package com.example.travelagency.service.transport;

import com.example.travelagency.domain.Transport;


import java.util.List;

public interface TransportService {
    Transport create(Transport transport);

    List<Transport> getAll();

    void delete(Integer id);

    Transport updateById(Integer id, Transport transport);

    Transport getById(Integer id);
}
