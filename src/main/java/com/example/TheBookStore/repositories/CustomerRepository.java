package com.example.TheBookStore.repositories;

import com.example.TheBookStore.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
