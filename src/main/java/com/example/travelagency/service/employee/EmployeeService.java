package com.example.travelagency.service.employee;

import com.example.travelagency.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);

    List<Employee> getAll();

    void delete(Integer id);

    Employee updateById(Integer id, Employee employee);

    Employee getById(Integer id);
}
