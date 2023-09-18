package com.example.onlineshopping.Service;

import com.example.onlineshopping.Entity.Product;
import com.example.onlineshopping.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        List<Product> allProducts = productRepo.findAll();
        return allProducts;
    }

    @Transactional(readOnly = true)
    public Product getProduct(String productId){
        Optional<Product> p = productRepo.findById(productId);
        if(p.isPresent())return p.get();
        else throw new RuntimeException("Product Not Found");
    }
}
