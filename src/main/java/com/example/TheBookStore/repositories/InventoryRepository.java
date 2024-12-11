package com.example.TheBookStore.repositories;

import com.example.TheBookStore.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository <Inventory, Long> {
}
