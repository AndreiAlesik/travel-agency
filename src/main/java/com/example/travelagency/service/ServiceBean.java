package com.example.travelagency.service;

import com.example.travelagency.domain.Customer;
import com.example.travelagency.repository.Repository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@AllArgsConstructor
@Slf4j
@org.springframework.stereotype.Service
public class ServiceBean implements Service{
    private final Repository repository;

    @Override
    public Customer create(Customer customerEntity) {
        return repository.save(customerEntity);
    }

    @Override
    public List<Customer> getAll() {
        log.info("start");
        return repository.findAll();
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
}
