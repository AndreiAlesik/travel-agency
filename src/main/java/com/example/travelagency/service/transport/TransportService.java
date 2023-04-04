package com.example.travelagency.service.transport;

import com.example.travelagency.domain.Transport;
import com.example.travelagency.dto.transport.TransportRequestDTO;
import com.example.travelagency.dto.transport.TransportResponseDTO;


import java.util.List;

public interface TransportService {
    TransportResponseDTO create(TransportRequestDTO transportRequestDTO);

    List<Transport> getAll();

    void delete(Integer id);

    TransportResponseDTO updateById(Integer id, TransportRequestDTO transportRequestDTO);

    TransportResponseDTO getById(Integer id);
}
