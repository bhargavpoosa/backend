package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart, Integer> {
    List<Cart> findByUsername(String username);
}
