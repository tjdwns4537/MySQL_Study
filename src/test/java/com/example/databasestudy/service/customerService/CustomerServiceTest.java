package com.example.databasestudy.service.customerService;

import com.example.databasestudy.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
@WebMvcTest
class CustomerServiceTest {

    private final CustomerRepository customerRepository;

    @Test
    void findByName() {

    }
}
