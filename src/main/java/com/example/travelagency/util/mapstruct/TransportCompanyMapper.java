package com.example.travelagency.util.mapstruct;

import com.example.travelagency.domain.Stage;
import com.example.travelagency.domain.TransportCompany;
import com.example.travelagency.dto.stage.StageRequestDTO;
import com.example.travelagency.dto.stage.StageResponseDTO;
import com.example.travelagency.dto.transportcompany.TransportCompanyRequestDTO;
import com.example.travelagency.dto.transportcompany.TransportCompanyResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransportCompanyMapper {
    TransportCompany requestDTOToTransportCompany(TransportCompanyRequestDTO transportCompanyRequestDTO);

    TransportCompanyResponseDTO transportCompanyToResponseDTO(TransportCompany transportCompany);
}
