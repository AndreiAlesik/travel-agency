package com.example.travelagency.service.customer;


import com.example.travelagency.domain.Customer;
import com.example.travelagency.dto.ResponseObject;
import com.example.travelagency.repository.CustomerRepository;
import com.example.travelagency.util.exceptionhandling.AccessException;
import com.example.travelagency.util.exceptionhandling.ResourceNotFoundException;
import com.example.travelagency.util.exceptionhandling.WrongArgumentException;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomersServiceBean implements CustomerService {

    private final CustomerRepository customerRepository;

    public ResponseObject<String> create(Customer customer) {
        log.debug("CustomersService ==> create() - start: customer = {}", customer);
        String pesel = customer.getPersonalNumber();
        Customer existingCustomer = customerRepository.findByPersonalNumber(pesel);
        if (existingCustomer != null) {
            return new ResponseObject<>(HttpStatus.BAD_REQUEST, "Klient already exist", null);
        }
        Customer customerCreated = customerRepository.save(customer);
        log.debug("CustomersService ==> create() - end: customerCreated = {}", customerCreated);

        return new ResponseObject<>(HttpStatus.OK, "OK", null);
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


    public ResponseObject<?> updateById(String id, Customer customerToUpdate) {
        log.debug("CustomersService ==> updateById() - start: id = {}, attractionRequestDTO = {}",
                id, customerToUpdate);
        var customer = customerRepository.findByPersonalNumber(id);
        try {
            customer.setName(customerToUpdate.getName());
            customer.setSurname(customerToUpdate.getSurname());
            customer.setAddress(customerToUpdate.getAddress());
            customer.setPhoneNumber(customerToUpdate.getPhoneNumber());
            customer.setDateOfBirth(customerToUpdate.getDateOfBirth());
            log.debug("CustomersService ==> updateById() - end: accommodationToUpdate = {}", customer);
            customerRepository.save(customer);
            return new ResponseObject<>(HttpStatus.OK, "OK", null);
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException();
        } catch (DataAccessException e) {
            throw new AccessException();
        }
    }

    public ResponseObject<Customer> getById(String id) {
        log.debug("CustomersService ==> getById() - start: id = {}", id);
        if (id == null) {
            throw new WrongArgumentException();
        }
        var customer = customerRepository.findByPersonalNumber(id);
        // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
        var response = new ResponseObject<>(HttpStatus.OK, "OK", customer);
        log.debug("CustomersService ==> getById() - end: response = {}", response);
        return response;
    }

    @Override
    public ResponseObject<?> removeByPersonalNumber(String personalNumber) {
        var customer=customerRepository.findByPersonalNumber(personalNumber);
        customerRepository.delete(customer);
        return new ResponseObject<>(HttpStatus.OK, "OK", null);
    }
}
