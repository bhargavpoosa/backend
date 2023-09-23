package com.example.onlineshopping.Controller;

import com.example.onlineshopping.Entity.Product;
import com.example.onlineshopping.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public List<Product> getProductList(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable String productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/productName/{searchTerm}")
    public List<Product> getProductList(@PathVariable String searchTerm){
        List<Product> products = productService.getProductsByName(searchTerm);
        return products;
    }

    @ExceptionHandler(RuntimeException.class)
    public HttpStatus productNotFoundHandler(){
        return HttpStatus.NOT_FOUND;
    }
}
