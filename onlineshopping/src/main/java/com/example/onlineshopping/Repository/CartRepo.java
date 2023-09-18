package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, String> {
}
