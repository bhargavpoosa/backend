package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
