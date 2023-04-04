package com.example.travelagency.service.employee;

import com.example.travelagency.domain.Employee;
import com.example.travelagency.dto.employee.EmployeeRequestDTO;
import com.example.travelagency.dto.employee.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO);

    List<Employee> getAll();

    void delete(Integer id);

    EmployeeResponseDTO updateById(Integer id, EmployeeRequestDTO employeeRequestDTO);

    EmployeeResponseDTO getById(Integer id);
}
