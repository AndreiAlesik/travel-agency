package com.example.travelagency.service.customer;


import com.example.travelagency.domain.Customer;
import com.example.travelagency.repository.CustomerRepository;
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
public class CustomersServiceBean implements CustomerService{

    private final CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        log.debug("CustomersService ==> create() - start: customer = {}", customer);
        var customerCreated =
                customerRepository.save(customer);
        log.debug("CustomersService ==> create() - end: attractionResponse = {}", customerCreated);
        return customerCreated;
    }

    public List<Customer> getAll() {
        log.debug("CustomersService ==> getAll() - start: ");
        try {
            var customerList = customerRepository.findAll();
            log.debug("CustomersService ==> getAll() - end: ");
            return customerList;
        } catch (NullPointerException e) {
            throw new ResourceNotFoundException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public void delete(Integer id) {
        log.debug("CustomersService ==> removeById() - start: id = {}", id);
        customerRepository.deleteById(id);
        log.debug("CustomersService ==> removeById() - end: id = {}", id);
    }


    public Customer updateById(Integer id, Customer customerToUpdate) {
        log.debug("CustomersService ==> updateById() - start: id = {}, attractionRequestDTO = {}",
                id, customerToUpdate);
        try {
            return customerRepository.findById(id)
                    .map(entity -> {
                        entity.setName(customerToUpdate.getName());
                        entity.setSurname(customerToUpdate.getSurname());
                        entity.setAddress(customerToUpdate.getAddress());
                        entity.setPhoneNumber(customerToUpdate.getPhoneNumber());
                        entity.setDateOfBirth(customerToUpdate.getDateOfBirth());
                        log.debug("CustomersService ==> updateById() - end: accommodationToUpdate = {}", entity);
                        return customerRepository.save(entity);
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found with id = " + id));
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public Customer getById(Integer id) {
        log.debug("CustomersService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var customer = customerRepository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
        log.debug("CustomersService ==> getById() - end: customer = {}", customer);
        return customer;
    }
}
