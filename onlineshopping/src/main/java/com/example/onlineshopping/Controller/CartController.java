package com.example.onlineshopping.Controller;

import com.example.onlineshopping.Entity.Product;
import com.example.onlineshopping.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public HttpStatus addtoCart(@RequestBody Product product){
        cartService.addtoCart(product);
        return HttpStatus.OK;
    }

    @PostMapping("/remove")
    public HttpStatus removeFromCart(@RequestBody Product product){
        cartService.removeFromCart(product);
        return HttpStatus.OK;
    }

    @PostMapping("/order")
    public HttpStatus order(@RequestParam double totalPrice){
        cartService.bookProducts(totalPrice);
        return HttpStatus.OK;
    }
}
