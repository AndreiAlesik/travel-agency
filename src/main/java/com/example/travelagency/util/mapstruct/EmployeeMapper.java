package com.example.travelagency.util.mapstruct;

import com.example.travelagency.domain.Employee;
import com.example.travelagency.dto.employee.EmployeeRequestDTO;
import com.example.travelagency.dto.employee.EmployeeResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee requestDTOToEmployee(EmployeeRequestDTO employeeRequestDTO);

    EmployeeResponseDTO employeeToResponseDTO(Employee employee);
}
