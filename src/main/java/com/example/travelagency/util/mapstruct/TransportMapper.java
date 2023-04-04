package com.example.travelagency.util.mapstruct;

import com.example.travelagency.domain.Transport;
import com.example.travelagency.dto.transport.TransportRequestDTO;
import com.example.travelagency.dto.transport.TransportResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransportMapper {
    Transport requestDTOToTransport(TransportRequestDTO transportRequestDTO);

    TransportResponseDTO transportToResponseDTO(Transport transport);
}
