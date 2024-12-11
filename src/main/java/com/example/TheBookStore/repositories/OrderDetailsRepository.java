package com.example.TheBookStore.repositories;

import com.example.TheBookStore.relationships.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository <OrderDetails, Long> {
}
