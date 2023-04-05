package com.example.travelagency.service.employee;

import com.example.travelagency.domain.Employee;
import com.example.travelagency.repository.EmployeeRepository;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;
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

    public Employee create(Employee employee) {
        log.debug("EmployeesServiceBean ==> create() - start: attractionRequestDTO = {}", employee);
        var employeeCreated =
                employeeRepository.save(employee);
        log.debug("EmployeesServiceBean ==> create() - end: attractionResponse = {}", employeeCreated);
        return employeeCreated;
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


    public Employee updateById(Integer id, Employee employeeToUpdate) {
        log.debug("EmployeesServiceBean ==> updateById() - start: id = {}, employeeRequestDTO = {}",
                id, employeeToUpdate);
        try {
            return employeeRepository.findById(id)
                    .map(entity -> {
                        entity.setName(employeeToUpdate.getName());
                        entity.setSurname(employeeToUpdate.getSurname());
                        entity.setPhoneNumber(employeeToUpdate.getPhoneNumber());
                        entity.setAddress(employeeToUpdate.getAddress());
                        log.debug("EmployeesServiceBean ==> updateById() - end: employeeToUpdate = {}", entity);
                        return employeeRepository.save(entity);
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public Employee getById(Integer id) {
        log.debug("EmployeesServiceBean ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var employee = employeeRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        log.debug("EmployeesServiceBean ==> getById() - end: employee = {}", employee);
        return employee;
    }
}
