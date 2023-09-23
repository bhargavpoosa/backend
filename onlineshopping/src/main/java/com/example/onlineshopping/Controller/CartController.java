package com.example.onlineshopping.Controller;

import com.example.onlineshopping.Entity.Cart;
import com.example.onlineshopping.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/add/{productId}")
    public HttpStatus addtoCart(@PathVariable String productId){
        cartService.addtoCart(productId);
        return HttpStatus.OK;
    }

    @PostMapping("/remove/{productId}")
    public HttpStatus removeFromCart(@PathVariable String productId){
        cartService.removeFromCart(productId);
        return HttpStatus.OK;
    }

    @PostMapping("/{productId}")
    public HttpStatus deleteFromCart(@PathVariable String productId){
        cartService.deleteFromCart(productId);
        return HttpStatus.OK;
    }

    @PostMapping("/order/{totalPrice}/{productList}")
    public HttpStatus order(@PathVariable double totalPrice, @PathVariable String productList){
        cartService.bookProducts(totalPrice, productList);
        return HttpStatus.OK;
    }

    @GetMapping("/")
    public List<Cart> getProductsFromCart(){
        return cartService.getProductList();
    }
}
