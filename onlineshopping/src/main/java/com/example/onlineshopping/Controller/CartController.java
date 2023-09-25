package com.example.onlineshopping.Controller;

import com.example.onlineshopping.Entity.Cart;
import com.example.onlineshopping.Entity.Order;
import com.example.onlineshopping.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "https://bhargavpoosa.github.io/frontend/frontend/")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/add/{username}/{productId}")
    public HttpStatus addtoCart(@PathVariable String username, @PathVariable int productId){
        cartService.addtoCart(username, productId);
        return HttpStatus.OK;
    }

    @PostMapping("/remove/{username}/{productId}")
    public HttpStatus removeFromCart(@PathVariable String username, @PathVariable int productId){
        cartService.removeFromCart(username, productId);
        return HttpStatus.OK;
    }

    @PostMapping("/{username}/{productId}")
    public HttpStatus deleteFromCart(@PathVariable String username, @PathVariable int productId){
        cartService.deleteFromCart(username, productId);
        return HttpStatus.OK;
    }

    @PostMapping("/order")
    public HttpStatus order(@RequestBody Order order){
        cartService.bookProducts(order);
        return HttpStatus.OK;
    }

    @GetMapping("/{username}")
    public List<Cart> getProductsFromCart(@PathVariable String username){
        return cartService.getProductList(username);
    }
}
