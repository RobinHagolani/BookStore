package com.example.TheBookStore.repositories;

import com.example.TheBookStore.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
