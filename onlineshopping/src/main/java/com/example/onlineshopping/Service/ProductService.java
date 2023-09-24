package com.example.onlineshopping.Service;

import com.example.onlineshopping.Entity.Product;
import com.example.onlineshopping.Entity.ProductDetails;
import com.example.onlineshopping.MongoRepository.MongoRepo;
import com.example.onlineshopping.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final MongoRepo mongoRepo;
    @Autowired
    ProductRepo productRepo;

    @Autowired
    public ProductService(MongoRepo mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    public boolean addProduct(Product p){
        Product product = new Product(p.getProductName(), p.getPrice(), p.getItemCount(), p.getImageUrl(), p.getDescription());
        productRepo.save(product);
        return true;
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        List<Product> allProducts = productRepo.findAll();
        return allProducts;
    }

    @Transactional(readOnly = true)
    public Product getProduct(int productId){
        Optional<Product> p = productRepo.findById(productId);
        if(p.isPresent())return p.get();
        else throw new RuntimeException("Product Not Found");
    }

    @Transactional(readOnly = true)
    public List<Product> getProductsByName(String searchTerm){
        return productRepo.searchProducts(searchTerm);
    }

    @Transactional(readOnly = true)
    public ProductDetails findById(int productId){
        Optional<ProductDetails> details = mongoRepo.findByProductId(productId);
        if(details.isPresent())
            return details.get();
        else
            return new ProductDetails(productId, "Superb", "5");
    }
}
