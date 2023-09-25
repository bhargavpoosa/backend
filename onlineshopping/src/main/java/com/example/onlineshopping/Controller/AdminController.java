package com.example.onlineshopping.Controller;

import com.example.onlineshopping.Entity.Product;
import com.example.onlineshopping.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ProductService productService;

    @PostMapping("/")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public HttpStatus addProduct(@RequestBody Product product){
       if(productService.addProduct(product)){
           return HttpStatus.OK;
       }
       return HttpStatus.BAD_REQUEST;
    }
}
