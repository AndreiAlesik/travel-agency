package com.example.travelagency.util.mapstruct;

import com.example.travelagency.domain.Employee;
import com.example.travelagency.domain.Guide;
import com.example.travelagency.dto.employee.EmployeeRequestDTO;
import com.example.travelagency.dto.employee.EmployeeResponseDTO;
import com.example.travelagency.dto.guide.GuideRequestDTO;
import com.example.travelagency.dto.guide.GuideResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuideMapper {
    Guide requestDTOToGuide(GuideRequestDTO guideRequestDTO);

    GuideResponseDTO guideToResponseDTO(Guide guide);
}
