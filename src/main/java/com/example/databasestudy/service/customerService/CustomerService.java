package com.example.databasestudy.service.customerService;

import com.example.databasestudy.domain.customers.Customers;
import com.example.databasestudy.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void save(Customers customers) {

    }

    public void findByName(String name) {
        customerRepository.findByName(name);
    }
}
