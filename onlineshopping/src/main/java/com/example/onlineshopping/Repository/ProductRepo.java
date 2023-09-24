package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:searchTerm% OR p.description LIKE %:searchTerm%")
    List<Product> searchProducts(String searchTerm);

}
