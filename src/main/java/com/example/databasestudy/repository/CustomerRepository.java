package com.example.databasestudy.repository;

import com.example.databasestudy.domain.customers.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customers, Long> {

    @Query(name = "SELECT * FROM customers",nativeQuery = true)
    String findByName(String name);
}
