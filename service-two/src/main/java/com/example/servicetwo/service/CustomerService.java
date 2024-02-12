package com.example.servicetwo.service;

import com.example.servicetwo.entity.Customer;
import com.example.servicetwo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
