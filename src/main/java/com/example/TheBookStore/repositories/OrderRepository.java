package com.example.TheBookStore.repositories;

import com.example.TheBookStore.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long> {
}
