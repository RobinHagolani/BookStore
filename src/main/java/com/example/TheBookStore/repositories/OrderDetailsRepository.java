package com.example.TheBookStore.repositories;

import com.example.TheBookStore.models.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository <OrderDetails, Long> {
}
