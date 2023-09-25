package com.example.onlineshopping.MongoRepository;

import com.example.onlineshopping.Entity.ProductDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface MongoRepo extends MongoRepository<ProductDetails, Integer> {
    ProductDetails findByProductId(int productId);
}
