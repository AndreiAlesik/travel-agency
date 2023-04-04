package com.example.travelagency.service.employee;

import com.example.travelagency.domain.Employee;
import com.example.travelagency.dto.employee.EmployeeRequestDTO;
import com.example.travelagency.dto.employee.EmployeeResponseDTO;
import com.example.travelagency.repository.EmployeeRepository;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;
import com.example.travelagency.util.mapstruct.EmployeeMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class EmployeesServiceBean implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO) {
        log.debug("EmployeesServiceBean ==> create() - start: attractionRequestDTO = {}", employeeRequestDTO);
        var employeeCreated =
                employeeRepository.save(
                        employeeMapper.requestDTOToEmployee(employeeRequestDTO));
        var employeeResponseDTO = employeeMapper.employeeToResponseDTO(employeeCreated);
        log.debug("EmployeesServiceBean ==> create() - end: attractionResponse = {}", employeeResponseDTO);
        return employeeResponseDTO;
    }

    public List<Employee> getAll() {
        log.debug("EmployeesServiceBean ==> getAll() - start: ");
        try {
            var employeeList = employeeRepository.findAll();
            log.debug("EmployeesServiceBean ==> getAll() - end: ");
            return employeeList;
        } catch (NullPointerException e) {
            throw new ResourceNotFoundException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public void delete(Integer id) {
        log.debug("EmployeesServiceBean ==> removeById() - start: id = {}", id);
        employeeRepository.deleteById(id);
        log.debug("EmployeesServiceBean ==> removeById() - end: id = {}", id);
    }


    public EmployeeResponseDTO updateById(Integer id, EmployeeRequestDTO employeeRequestDTO) {
        log.debug("EmployeesServiceBean ==> updateById() - start: id = {}, employeeRequestDTO = {}",
                id, employeeRequestDTO);
        var employeeToUpdate = employeeMapper.requestDTOToEmployee(employeeRequestDTO);
        try {
            return employeeRepository.findById(id)
                    .map(entity -> {
                        entity.setName(employeeToUpdate.getName());
                        entity.setSurname(employeeToUpdate.getSurname());
                        entity.setPhoneNumber(employeeToUpdate.getPhoneNumber());
                        entity.setAddress(employeeToUpdate.getAddress());
                        log.debug("EmployeesServiceBean ==> updateById() - end: employeeToUpdate = {}", entity);
                        return employeeMapper.employeeToResponseDTO(employeeRepository.save(entity));
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public EmployeeResponseDTO getById(Integer id) {
        log.debug("EmployeesServiceBean ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var employee = employeeRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        var employeeResponseDTO = employeeMapper.employeeToResponseDTO(employee);
        log.debug("EmployeesServiceBean ==> getById() - end: employee = {}", employeeResponseDTO);
        return employeeResponseDTO;
    }
}
