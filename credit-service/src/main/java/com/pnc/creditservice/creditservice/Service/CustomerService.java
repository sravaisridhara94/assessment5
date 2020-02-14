package com.pnc.creditservice.creditservice.Service;

import com.pnc.creditservice.creditservice.API.Controller;
import com.pnc.creditservice.creditservice.Domain.Customer;
import com.pnc.creditservice.creditservice.Repository.CustomerRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer saveCustomer(Customer customer){
        return repository.save(customer);
    }

    public Optional<Customer> getCustomerById(long customerId){
        return repository.findById(customerId);
    }
}
