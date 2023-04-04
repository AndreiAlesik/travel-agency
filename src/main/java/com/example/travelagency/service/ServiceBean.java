package com.example.travelagency.service;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.repository.CustomerRepository;
import com.example.travelagency.util.exceptionhandling.ResourceWasDeletedException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;


import java.rmi.AccessException;
import java.util.List;


@AllArgsConstructor
@Slf4j
@org.springframework.stereotype.Service
public class ServiceBean implements Service {
    private final CustomerRepository repository;

    @Override
    public Customer create(Customer customerEntity) {
        return repository.save(customerEntity);
    }

    @Override
    public List<Customer> getAll() {
        log.info("start");
        return repository.findAllByDeletedIsFalse();
    }

    @Override
    public Customer updateById(Integer id, Customer customerEntity) {
        return repository.findById(id).map(
                entity -> {
                    entity.setName(customerEntity.getName());
                    entity.setSurename(customerEntity.getSurename());
                    entity.setAddress(customerEntity.getAddress());
                    entity.setDateOfBirth(customerEntity.getDateOfBirth());
                    entity.setPhoneNumber(customerEntity.getPhoneNumber());
                    return repository.save(entity);
                }
        ).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public Customer removeById(Integer id) {
        var customer = repository.findById(id)
                .orElseThrow(ResourceWasDeletedException::new);
        customer.setDeleted(true);
        repository.save(customer);
        return customer;
    }

    @Override
    public Customer getCustomerGetById(Integer id) {
        return repository.getCustomerByIdAndDeletedIsFalse(id);
    }
}
